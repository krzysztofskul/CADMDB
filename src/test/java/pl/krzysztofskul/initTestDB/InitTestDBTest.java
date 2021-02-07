package pl.krzysztofskul.initTestDB;

import org.junit.Test;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.organizationStatus.OrganizationStatus;
import pl.krzysztofskul.product.socket.Socket;
import pl.krzysztofskul.product.socket.SocketDemoGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InitTestDBTest {

    @Test
    public void whenCreateAndGetInitTestRoomList_shouldRoomsHaveStatusSet() {
        // given
        List<Room> roomList = InitTestDB.getInitTestDBInstance().createAndGetInitTestRoomList(InitTestDB.getInitTestDBInstance().createAndGetInitTestRoomCategoryList());
        //when
        List<OrganizationStatus> organizationStatusList = new ArrayList<>();
        for (Room room : roomList) {
            organizationStatusList.add(room.getOrganizationStatus());
            System.out.println("Test room: "+room.getOrganizationStatus().toString());
        }

        //should
        for (Room room : roomList) {
            assertNotNull(room.getOrganizationStatus());
        }
    }

    @Test
    public void whenAddSocketsToRooms_shouldRoomsHaveSetSocketList() {
        //given
        List<Room> roomList = InitTestDB.getInitTestDBInstance().createAndGetInitTestRoomList(InitTestDB.getInitTestDBInstance().createAndGetInitTestRoomCategoryList());
        List<Socket> socketList = SocketDemoGenerator.getSocketDemoGenerator().getDemoSockets();

        // when
        for (Room room : roomList) {
            room.setSocketList(socketList);
        }

        // should
        for (Room room : roomList) {
            assertNotNull(room.getSocketList());
        }

    }
}