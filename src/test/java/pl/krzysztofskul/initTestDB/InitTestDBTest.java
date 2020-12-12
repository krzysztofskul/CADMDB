package pl.krzysztofskul.initTestDB;

import org.junit.Test;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.organizationStatus.OrganizationStatus;

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
}