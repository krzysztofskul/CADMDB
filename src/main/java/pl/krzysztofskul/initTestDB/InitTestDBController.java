package pl.krzysztofskul.initTestDB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitTestDBController {

    private InitTestDBService initTestDBService;

    public InitTestDBController(
            InitTestDBService initTestDBService
    ) {
        this.initTestDBService = initTestDBService;
    }

    @GetMapping("/initTestDB")
    public String initTestDB() {

            initTestDBService.createUsersCategory();
            initTestDBService.createTestUsers();

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

        return "index";
    }

}
