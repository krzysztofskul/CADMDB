package pl.krzysztofskul.manufacturer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.initTestDB.InitTestDBService;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;
import pl.krzysztofskul.product.ProductService;
import pl.krzysztofskul.product.productCategory.ProductCategoryService;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ManufacturerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private InitTestDBService initTestDBService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(webApplicationContext.getBean("manufacturerController"));
    }

    @Test
    public void whenGetManufacturersAll_shouldAddManufacturersAndProductCategoriesToModel() throws Exception {
//        initTestDBService.createTestManufacturers();
//        assertTrue(manufacturerService.loadAll().size() == 2);

        mockMvc.perform(get("/manufacturers/all")).andExpect(status().isOk())
                .andExpect(model().attributeExists("manufacturers"))
                .andExpect(model().attributeExists("productCategories"));

    }

    @Test
    public void newManufacturer() {
    }

    @Test
    public void testNewManufacturer() {
    }

    @Test
    public void productAddToRoom() {
    }

    @Test
    public void testProductAddToRoom() {
    }
}