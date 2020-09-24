package pl.krzysztofskul.manufacturer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.manufacturer.distributor.Distributor;
import pl.krzysztofskul.manufacturer.distributor.DistributorService;
import pl.krzysztofskul.manufacturer.factory.Factory;
import pl.krzysztofskul.manufacturer.factory.FactoryService;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ManufacturerServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DistributorService distributorService;

    @Autowired
    private FactoryService factoryService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void whenSaveManufacturer_shouldSaveDistributors() {
        // given
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Manufacturer 1 name");
        Distributor distributor1 = new Distributor();
        distributor1.setName("Distributor 1 name");
        Distributor distributor2 = new Distributor();
        distributor2.setName("Distributor 2 name");
        manufacturer.addDistributor(distributor1);
        manufacturer.addDistributor(distributor2);
        // when
        manufacturerService.save(manufacturer);
        // should
        Manufacturer manufacturerLoaded = manufacturerService.loadByIdWithDistributors(Long.parseLong("1"));
        assertTrue(manufacturerLoaded.getName().equals("Manufacturer 1 name"));
        assertTrue(manufacturerLoaded.getDistributorList().size() == 2);
        assertTrue(distributorService.loadById(Long.parseLong("1")).getManufacturer().getName().equals("Manufacturer 1 name"));
        assertTrue(distributorService.loadById(Long.parseLong("2")).getManufacturer().getName().equals("Manufacturer 1 name"));
    }

    @Test
    public void whenSaveManufacturer_shouldSaveFactoryList() {
        // given
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Manufacturer test");
        //
        Factory factory1 = new Factory();
        factory1.setName("Factory no. 1");
        Factory factory2 = new Factory();
        factory2.setName("Factory no. 2");
        List<Factory> factoryList = new ArrayList<>();
        factoryList.add(factory1);
        factoryList.add(factory2);
        //
        manufacturer.setFactoryList(factoryList);
        // when
        manufacturerService.save(manufacturer);
        // should
        assertTrue(manufacturerService.loadByIdWithFactoryList(Long.parseLong("1")).getFactoryList().size() == 2);
        assertTrue(factoryService.loadAll().size() == 2);
        assertTrue(factoryService.loadById(Long.parseLong("1")).getManufacturer().getId() == 1);
        assertTrue(factoryService.loadById(Long.parseLong("2")).getManufacturer().getId() == 1);
    }

    @Test
    public void whenSaveManufacturerWithNewFactoryList_shouldUpdateAll() {
        // given
        Manufacturer manufacturer = new Manufacturer(true);
        Factory factory3 = new Factory("Factory no. 3");
        Factory factory4 = new Factory("Factory no. 4");
        Factory factory5 = new Factory("Factory no. 5");
        List<Factory> newFactoryList = new ArrayList<>();
        newFactoryList.add(factory3);
        newFactoryList.add(factory4);
        newFactoryList.add(factory5);
        // when
        manufacturer.setFactoryList(newFactoryList);
        manufacturerService.save(manufacturer);
        // should
        assertTrue(manufacturerService.loadByIdWithFactoryList(Long.parseLong("1")).getFactoryList().size() == 3);
        assertTrue(manufacturerService.loadById(Long.parseLong("1")).getDetails() != null);
    }

    @Test
    public void whenFactorySaveWithManufacturer_shouldBothSaveToDB() {
        // given
        Manufacturer manufacturer = new Manufacturer(true);
        manufacturer.setName("Test manufacturer");
        Factory factory = new Factory("Test factory");
        // when
        factory.setManufacturer(manufacturer);
        factoryService.save(factory);
        // should
        assertEquals(
          "Test manufacturer",
                factoryService.loadById(Long.parseLong("1")).getManufacturer().getName()
        );
        assertEquals(
                "Test manufacturer",
                manufacturerService.loadByIdWithFactoryList(Long.parseLong("1")).getFactoryList()
                .get(0).getManufacturer().getName()
        );
    }

    @Test
    public void whenManufacturerRemoveFactory_shouldBeFactoryRefreshedInDB() {
        // given
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Manufacturer for test 4");
        List<Factory> factoryList = new ArrayList<>();
        Factory factory1 = new Factory("Factory 14");
        Factory factory2 = new Factory("Factory 24");
        factoryList.add(factory1);
        factoryList.add(factory2);
        manufacturer.setFactoryList(factoryList);
        manufacturerService.save(manufacturer);
        // when
        Manufacturer manufacturerToUpdate = manufacturerService.loadByIdWithFactoryList(Long.parseLong("1"));
        manufacturerToUpdate.removeFactory(manufacturerToUpdate.getFactoryList().get(1));
        manufacturerService.save(manufacturerToUpdate);
        // should
        assertTrue(manufacturerService.loadByIdWithFactoryList(Long.parseLong("1")).getFactoryList().size() == 1);
    }

    @Test
    public void whenManufacturerAddAndDeleteProducts_shouldActualizeEverything() {
        // given
        Manufacturer manufacturer = new Manufacturer(true);
        manufacturerService.save(manufacturer);
        Product product1 = new Product(true);
        Product product2 = new Product(true);
        Product product3 = new Product(true);
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        // when
        Manufacturer manufacturerToUpdate = manufacturerService.loadByIdWithProductList(Long.parseLong("1"));
        manufacturerToUpdate.addProduct(productService.loadById(Long.parseLong("1")));
        manufacturerToUpdate.addProduct(productService.loadById(Long.parseLong("2")));
        manufacturerToUpdate.addProduct(productService.loadById(Long.parseLong("3")));
        manufacturerService.save(manufacturerToUpdate);
        Manufacturer manufacturerToUpdate2 = manufacturerService.loadByIdWithProductList(Long.parseLong("1"));
        manufacturerToUpdate2.removeProduct(manufacturerToUpdate2.getProductList().get(1));
        manufacturerService.save(manufacturerToUpdate2);
        // should
        assertTrue(manufacturerService.loadByIdWithProductList(Long.parseLong("1")).getProductList().size() == 2);
    }

    @Test
    public void whenManufacturerSetNewProductList_shouldActualizeEverything() {
        // given
        Manufacturer manufacturer = new Manufacturer(true);
        List<Product> productList = new ArrayList<Product>(Arrays.asList(new Product(true), new Product(true)));
        manufacturer.setProductList(productList);
        manufacturerService.save(manufacturer);
        List<Product> newProductList = new ArrayList<Product>(Arrays.asList(new Product(true), new Product(true), new Product(true)));
        // when
        Manufacturer manufacturerLoaded = manufacturerService.loadByIdWithProductList(Long.parseLong("1"));
        manufacturerLoaded.setProductList(newProductList);
        manufacturerService.save(manufacturerLoaded);
        // should
        assertTrue(manufacturerService.loadByIdWithProductList(Long.parseLong("1")).getProductList().size() == 3);
        assertTrue(manufacturerService.loadByIdWithProductList(Long.parseLong("1")).getProductList().get(3).getModelName().equals(productService.loadById(Long.parseLong("5")).getModelName()));
        assertTrue(productService.loadById(Long.parseLong("1")).getManufacturer() == null);
        assertTrue(productService.loadById(Long.parseLong("2")).getManufacturer() == null);
        assertTrue(productService.loadById(Long.parseLong("3")).getManufacturer().getName().equals(manufacturer.getName()));
        assertTrue(productService.loadById(Long.parseLong("4")).getManufacturer().getName().equals(manufacturer.getName()));
        assertTrue(productService.loadById(Long.parseLong("5")).getManufacturer().getName().equals(manufacturer.getName()));
    }

}