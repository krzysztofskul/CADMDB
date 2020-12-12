package pl.krzysztofskul.initTestDB;

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
import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.userCategory.UserCategory;
import pl.krzysztofskul.user.userCategory.UserCategoryEnum;
import pl.krzysztofskul.user.userCategory.UserCategoryService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class InitTestDBServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private InitTestDBController initTestDBController;
    @Autowired
    private InitTestDBService initTestDBService;
    @Autowired
    private UserCategoryService userCategoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DepartmentService departmentService;
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
    public void saveInitTestUsersCategory() {
        List<UserCategory> userCategoryList = userCategoryService.loadAll();
        Assert.assertTrue(null != userCategoryList && userCategoryList.size() != 0);
    }

    @Test
    public void saveInitTestUsers() {

        List<User> userList = userService.loadAll();
        Assert.assertTrue(null != userList && userList.size() != 0);
    }

    @Test
    public void addAndSaveHospitalsToInvestors() {

        List<Hospital> hospitalList = hospitalService.loadAll();
        List<User> investorList = userService.loadAllByUserCategoryEnum(UserCategoryEnum.INVESTOR);
        investorList.add(userService.loadByUserCategoryEnum(UserCategoryEnum.INVESTOR_GUEST));

        boolean isAnyHospitalHasInvestor = false;
        boolean isAnyInvestorHasHospital = false;

        for (Hospital hospital : hospitalList) {
            if (hospital.getInvestor() != null) {
                isAnyHospitalHasInvestor = true;
                break;
            }
        }

        for (User investor : investorList) {

            if (investor.getHospitalListAsInvestor() != null) {
                isAnyInvestorHasHospital = true;
                break;
            }
        }

        Assert.assertTrue(isAnyHospitalHasInvestor);
        Assert.assertTrue(isAnyInvestorHasHospital);

    }

    @Test
    public void whenSaveInitTestHospitalsWithDepartmentsAndRoomsAndInvestors_shouldRoomsHaveSetOrganizationStatus() {
        //given @Before: initTestDBService.saveInitTestHospitalsWithDepartmentsAndRoomsAndInvestors()
        System.out.println("test");
        //when
        List<Room> roomList = roomService.loadAll();
        //should
        for (Room room : roomList) {
            System.out.println("Test room from DB: "+room.getOrganizationStatus().toString());
            Assert.assertNotNull(room.getOrganizationStatus());
        }
    }

}