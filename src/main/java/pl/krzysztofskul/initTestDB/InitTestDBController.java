package pl.krzysztofskul.initTestDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class InitTestDBController {

    private InitTestDBService initTestDBService;

    @Autowired
    public InitTestDBController(
            InitTestDBService initTestDBService
    ) {
        this.initTestDBService = initTestDBService;
    }

    @GetMapping("/initTestDB")
    public String initTestDB(HttpSession httpSession) {

        if (!InitTestDB.isInitDB()) {
            //initTestDBService.createUsersCategory();
            initTestDBService.createInitTestUsersCategory();
            //initTestDBService.createTestUsers();
            initTestDBService.createInitTestUsers();

            initTestDBService.createDepartmentCategories();
            initTestDBService.createRoomCategories();
            initTestDBService.createProductCategories();

            initTestDBService.createTestManufacturers();
            //initTestDBService.createTestProducts();
            initTestDBService.createInitTestProductsForTestManufacturers();

            initTestDBService.createTestHospitals();
            initTestDBService.createTestDepartments();
            initTestDBService.createTestRooms();
            initTestDBService.addTestProductsToTestRooms();

            initTestDBService.setInitDBTrue(httpSession);
        }

        return "index";
    }

}
