package pl.krzysztofskul;

import org.springframework.web.bind.annotation.GetMapping;

public class InitTestDBController {

    private InitTestDBService initTestDBService;

    public InitTestDBController(
            InitTestDBService initTestDBService
    ) {
        this.initTestDBService = initTestDBService;
    }

    @GetMapping("/initTestDB")
    public String initTestDB() {

            initTestDBService.createTestManufacturers();
            initTestDBService.createProductCategories();
            initTestDBService.createTestProducts();

            initTestDBService.createUsersCategory();
            initTestDBService.createTestUsers();

            initTestDBService.createDepartmentCategories();
            initTestDBService.createRoomCategories();

            initTestDBService.createTestHospitals();
            initTestDBService.createTestDepartments();
            initTestDBService.createTestRooms();

        return "/";
    }

}
