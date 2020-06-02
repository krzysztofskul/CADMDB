package pl.krzysztofskul.product;

import org.junit.Test;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.user.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void getRoomList() {
    }

    @Test
    public void setRoomList() {
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
    }
}