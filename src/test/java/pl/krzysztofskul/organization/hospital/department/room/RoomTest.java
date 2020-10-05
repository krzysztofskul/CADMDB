//package pl.krzysztofskul.organization.hospital.department.room;
//
//import org.junit.Test;
//import org.mockito.internal.matchers.Or;
//import org.springframework.core.annotation.Order;
//import pl.krzysztofskul.product.Product;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class RoomTest {
//
//    private Product product1;
//    private Product product2;
//    private Room room;
//
//    private void prepareTestProductsAndRoom() {
//        product1 = new Product();
//        product1.setPrice(BigDecimal.valueOf(1000));
//        product1.setWeight(100f);
//        product2 = new Product();
//        product2.setPrice(BigDecimal.valueOf(500));
//        product2.setWeight(50f);
//        room = new Room();
//    }
//
//    @Test
//    @Order(1)
//    public void whenAddProduct_shouldRecalculateLoadActualInRoom() {
//        // given
//        prepareTestProductsAndRoom();
//        // when
//        room.addProduct(product1);
//        room.addProduct(product1);
//        room.addProduct(product1);
//        room.addProduct(product2);
//        // should
//        assertEquals(product1.getWeight()*3 + product2.getWeight(), room.getLoadActual(), 0.0);
//    }
//
//    @Test
//    @Order(2)
//    public void whenSetProductList_shouldRecalculateLoadActualInRoom() {
//        // given
//        prepareTestProductsAndRoom();
//        // when
//        room.addProduct(product1);
//        room.addProduct(product1);
//        room.addProduct(product2);
//        room.addProduct(product2);
//        room.addProduct(product2);
//        List<Product> productList = new ArrayList<Product>(Arrays.asList(product1, product1, product2));
//        room.setProductList(productList);
//        // should
//        assertEquals(product1.getWeight()*2 + product2.getWeight(), room.getLoadActual(), 0.0);
//    }
//
//
//    @Test
//    @Order(3)
//    public void whenRemoveProduct_shouldRecalculateLoadActualInRoom() {
//        // given
//        prepareTestProductsAndRoom();
//        List<Product> productList = new ArrayList<Product>(Arrays.asList(product1, product2));
//        room.setProductList(productList);
//        // when
//        room.removeProduct(product2);
//        // should
//        assertEquals(product1.getWeight(), room.getLoadActual(), 0.0);
//    }
//
//    @Test
//    @Order(4)
//    public void whenRemoveProductNull_should_() {       // todo
//        // given
//        prepareTestProductsAndRoom();
//        List<Product> productList = new ArrayList<Product>(Arrays.asList(product1, product2));
//        room.setProductList(productList);
//        Product product = new Product();
//        room.addProduct(product);
//        room.removeProduct(product);
//        room.removeProduct(product);
//        // when
//        room.removeProduct(null);
//        // should
//        assertEquals(product1.getWeight()+product2.getWeight(), room.getLoadActual(), 0.0);
//    }
//
//}