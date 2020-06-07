package pl.krzysztofskul.product;

import org.junit.Before;
import org.junit.Test;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductTest {

    private List<Room> testRooms = new ArrayList<>();
    private List<Product> testProducts = new ArrayList<>();

    @Before
    public void setRooms() {
        for (int i = 0; i < 4; i++) {
            Room room = new Room();
            room.setBudget(BigDecimal.valueOf(100));
            testRooms.add(room);
        }
    }

    @Before
    public void setProducts() {
        for (int i = 0; i < 4; i++) {
            Product product = new Product();
            product.setPrice(BigDecimal.valueOf(10));
            testProducts.add(product);
        }
    }

    @Test
    public void addRoom() {
        //given - beginning conditions
        Room room = new Room();
        Product product = new Product();
        //when - method tested
        product.addRoom(room);
        //then - expected (expected, value to check)
        assertEquals(room, product.getRoomList().get(0));
    }

    @Test
    public void addProductsToRoom() {
        // given
            Product product = testProducts.get(0);
        // when
            product.addRoom(testRooms.get(0));
            product.addRoom(testRooms.get(1));
        // should be
            assertTrue(product.getRoomList().get(0).equals(testRooms.get(0)));

    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnNullPointerException() {
        //given - beginning conditions
        Product product = new Product();
        //when - method tested
        product.addRoom(null);
        //then should throw exception
    }

    @Test
    public void removeRoom() {
        // given
            Product product = testProducts.get(0);
        // when
            product.addRoom(testRooms.get(1));
            product.removeRoom(testRooms.get(0));
            product.removeRoom(testRooms.get(1));
        // then should be
            assertTrue(product.getRoomList().size() == 0);
    }
}