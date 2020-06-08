package pl.krzysztofskul.manufacturer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.manufacturer.distributor.Distributor;
import pl.krzysztofskul.manufacturer.distributor.DistributorService;

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
    private DistributorService distributorService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void whenSaveManufacturer_shouldSaveDistributors() {
        // given
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Manufacturer name");
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
        assertTrue(manufacturerLoaded.getName().equals("Manufacturer name"));
        assertTrue(manufacturerLoaded.getDistributorList().size() == 2);
    }

    @Test
    public void loadAll() {
    }

    @Test
    public void loadAllWithProducts() {
    }

    @Test
    public void loadById() {
    }

    @Test
    public void delete() {
    }

}