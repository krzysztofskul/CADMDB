package pl.krzysztofskul;

import org.junit.Assert;
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
import pl.krzysztofskul.initTestDB.InitTestDBController;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.ProductService;

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
    private ProductService productService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HospitalService hospitalService;

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
//    @Order(1)
//    public void whenInitTestDB_roomServiceShouldLoadNotNull() {
    public void test01() {
        Assert.assertNotNull(roomService.loadAll());
    }

    @Test
//    @Order(2)
//    public void whenInitTestDB_roomServiceShouldLoadMoreThanZero() {
    public void test02() {
        Assert.assertTrue(roomService.loadAll().size() > 0);
    }

    @Test
//    @Order(3)
//    public void whenAddProductToRoom_costsShouldBeRecalculated() {
    public void test03() {
        Room room = roomService.loadByIdWithProducts(Long.parseLong("1"));
        BigDecimal costOfProductsAddedToRoom = room.getCostOfProductsActual();

        productManager.addProductToRoom(Long.parseLong("1"), room.getId());
        productManager.addProductToRoom(Long.parseLong("2"), room.getId());
        productManager.addProductToRoom(Long.parseLong("3"), room.getId());

        costOfProductsAddedToRoom = costOfProductsAddedToRoom.add(productService.loadById(Long.parseLong("1")).getPrice());
        costOfProductsAddedToRoom = costOfProductsAddedToRoom.add(productService.loadById(Long.parseLong("2")).getPrice());
        costOfProductsAddedToRoom = costOfProductsAddedToRoom.add(productService.loadById(Long.parseLong("3")).getPrice());

        room = roomService.loadByIdWithProducts(Long.parseLong("1"));
        BigDecimal costOfProductsActualInRoom = room.getCostOfProductsActual();

        Assert.assertEquals(costOfProductsAddedToRoom, costOfProductsActualInRoom);

    }

    @Test
//    @Order(4)
//    public void whenAddProductToDepartmentRooms_costsOfDepartmentShouldBeRecalculated() {
    public void test04() {
        Department department = departmentService.loadByIdWithRoomsAndItsProducts(Long.parseLong("1"));
        BigDecimal costsOfProducts = department.getCostOfProductsActual();
        for (Room room : department.getRoomList()) {
            productManager.addProductToRoom(Long.parseLong("1"), room.getId());
        }
        department = departmentService.loadByIdWithRoomsAndItsProducts(Long.parseLong("1"));
        Assert.assertTrue(department.getCostOfProductsActual().compareTo(costsOfProducts) > 0 );

    }

    @Test
//    @Order(5)
//    public void whenRemoveProductsFromRoom_costsShouldBeRecalculated() {
    public void test05() {
        Room room = roomService.loadByIdWithProducts(Long.parseLong("1"));
        Department department = departmentService.loadById(room.getDepartment().getId());
        Hospital hospital = hospitalService.loadById(department.getHospital().getId());

        List<Product> productListInRoom = room.getProductList();
        for (Product product : productListInRoom) {
            productManager.removeProductFromRoom(product.getId(), room.getId());
        }

        room = roomService.loadByIdWithProducts(Long.parseLong("1"));

        Assert.assertTrue(room.getProductList().size() == 0);
        Assert.assertEquals(room.getCostOfProductsActual(), BigDecimal.valueOf(Long.parseLong("0"), 2));
        Assert.assertTrue(department.getCostOfProductsActual().compareTo(departmentService.loadById(room.getDepartment().getId()).getCostOfProductsActual()) > 0);
        Assert.assertTrue(hospital.getCostOfProductsActual().compareTo(hospitalService.loadById(departmentService.loadById(room.getDepartment().getId()).getId()).getCostOfProductsActual()) > 0);

    }

}