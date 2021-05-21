package pl.krzysztofskul;

import org.junit.Assert;
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
import pl.krzysztofskul.initTestDB.InitTestDBController;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;
import pl.krzysztofskul.product.Product;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ProductManagerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private InitTestDBController initTestDBController;

    @Autowired
    private ProductManager productManager;

    @Autowired
    private RoomService roomService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    private static boolean initDB = false;
    @Before
    public void initTestDB() {

        if (!initDB) {
            initTestDBController.initTestDB(null);
            initDB = true;
        }

    }

    @Test
    @Order(1)
    public void whenInitTestDB_roomServiceShouldLoadNotNull() {
        Assert.assertNotNull(roomService.loadAll());
    }

    @Test
    @Order(2)
    public void whenInitTestDB_roomServiceShouldLoadMoreThanZero() {
        Assert.assertTrue(roomService.loadAll().size() > 0);
    }

    @Test
    @Order(3)
    public void whenAddProductToRoom_costsShouldBeRecalculated() {
        productManager.addProductToRoom(Long.parseLong("1"), Long.parseLong("1"));
        List<Product> productListInRoom = roomService.loadByIdWithProducts(Long.parseLong("1")).getProductList();

        BigDecimal costOfProductsAddedToRoom = BigDecimal.ZERO;
        for (Product product : productListInRoom) {
            costOfProductsAddedToRoom = costOfProductsAddedToRoom.add(product.getPrice());
        }

        Room roomFromDB = roomService.loadById(Long.parseLong("1"));
        BigDecimal costOfProductsActualInRoom = roomFromDB.getCostOfProductsActual();

        Assert.assertEquals(costOfProductsAddedToRoom, costOfProductsActualInRoom);

    }

}