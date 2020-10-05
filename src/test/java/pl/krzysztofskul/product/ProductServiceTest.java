//package pl.krzysztofskul.product;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.core.annotation.Order;
//import pl.krzysztofskul.organization.hospital.Hospital;
//import pl.krzysztofskul.organization.hospital.department.Department;
//import pl.krzysztofskul.organization.hospital.department.room.Room;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class ProductServiceTest {
//
//    private Hospital hospital;
//    private List<Department> departmentList = new ArrayList<>();
//    private List<Room> roomList = new ArrayList<>();
//    private List<Product> productList = new ArrayList<>();
//
//    @Before
//    public void setOrganizations() {
//
//        // create Hospital
//        hospital = new Hospital();
//        hospital.setBudget(BigDecimal.valueOf(1000000));
//
//        // create Departments in Hospital
//        for (int i = 0; i < 2 ; i++) {
//            Department department = new Department();
//            department.setBudget(BigDecimal.valueOf(1000));
//            department.setHospital(hospital);
//            departmentList.add(department);
//        }
//        hospital.setDepartmentList(departmentList);
//
//        // create Rooms in Departments
//        for (int i = 0; i < 5 ; i++) {
//            Room room = new Room();
//            room.setBudget(BigDecimal.valueOf(100));
//            if (i < 3) {
//                room.setDepartment(departmentList.get(0));
//            } else {
//                room.setDepartment(departmentList.get(1));
//            }
//            roomList.add(room);
//        }
//        for (Room room : roomList) {
//            for (Department department : departmentList) {
//                if (room.getDepartment().equals(department)) {
//                    department.addRoom(room);
//                }
//            }
//        }
//
//        // create Products (not connected)
//        for (int i = 0; i < 10 ; i++) {
//            Product product = new Product();
//            product.setPrice(BigDecimal.valueOf(10));
//            productList.add(product);
//        }
//
//    }
//
//    @Test
//    public void save() {
//    }
//
//    @Test
//    public void loadAll() {
//    }
//
//    @Test
//    public void loadAllSorted() {
//    }
//
//    @Test
//    public void loadAllByCategoryCode() {
//    }
//
//    @Test
//    public void loadById() {
//    }
//
//    @Test
//    public void loadByIdWithRoomList() {
//    }
//
//    @Test
//    public void delete() {
//    }
//
//    @Test
//    @Order(1)
//    public void whenAddProductToRoom_shouldBudgetsBeDecreased() {
//        // given
//        Product product = productList.get(0);
//        Department department = departmentList.get(0);
//        Room room = roomList.get(0);
//
//        // when
//
//        room.addProduct(product);
//        room.setBudget(room.getBudget().subtract(product.getPrice()));
//        department.setBudget(department.getBudget().subtract(product.getPrice()));
//        hospital.setBudget(hospital.getBudget().subtract(product.getPrice()));
//
//
//        // should be
//
//        assertTrue(room.getBudget().equals(BigDecimal.valueOf(90)));
//        assertTrue(department.getBudget().equals(BigDecimal.valueOf(990)));
//        assertTrue(hospital.getBudget().equals(BigDecimal.valueOf(999990)));
//
//    }
//
//    @Test
//    @Order(2)
//    public void whenRemoveProductFromRoom_shouldBudgetsBeIncreased() {
//        // given
//        Product product = productList.get(0);
//        Room room = roomList.get(0);
//        Department department = departmentList.get(0);
//
////        room.addProduct(product);
////        room.setBudget(room.getBudget().subtract(product.getPrice()));
////        department.setBudget(department.getBudget().subtract(product.getPrice()));
////        hospital.setBudget(hospital.getBudget().subtract(product.getPrice()));
//        whenAddProductToRoom_shouldBudgetsBeDecreased();
//
//        // when
//
//        room.removeProduct(product);
//        room.setBudget(room.getBudget().add(product.getPrice()));
//        department.setBudget(department.getBudget().add(product.getPrice()));
//        hospital.setBudget(hospital.getBudget().add(product.getPrice()));
//
//
//        // should be
//
//        assertTrue(room.getBudget().equals(BigDecimal.valueOf(100)));
//        assertTrue(department.getBudget().equals(BigDecimal.valueOf(1000)));
//        assertTrue(hospital.getBudget().equals(BigDecimal.valueOf(1000000)));
//
//    }
//
//    @Test
//    @Order(3)
//    public void whenRemoveProductFromEmptyRoom_shouldRoomListBeSize0() {
//        // given
//        Product product = productList.get(0);
//        Room room = roomList.get(0);
//        Department department = room.getDepartment();
//        Hospital hospital = department.getHospital();
//
//        // when
//        room.removeProduct(product);
//        room.setBudget(room.getBudget().add(product.getPrice()));
//        department.setBudget(department.getBudget().add(product.getPrice()));
//        hospital.setBudget(hospital.getBudget().add(product.getPrice()));
//
//        // should
//        assertEquals(0, room.getProductList().size());
//    }
//}