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
            initTestDBService.saveInitTestUsersCategory();
            initTestDBService.saveInitTestUsers();

            initTestDBService.saveInitTestInvestors();
            initTestDBService.addAndSaveUsersToInvestors();

            initTestDBService.saveInitTestDepartmentCategoryList();
            initTestDBService.saveInitTestRoomCategoryList();
            initTestDBService.createProductCategories();

            initTestDBService.saveInitTestManufacturers();
            initTestDBService.saveInitTestProductsForTestManufacturers();

            initTestDBService.saveInitTestHospitalsWithDepartmentsAndRoomsAndInvestors();
            //initTestDBService.addTestProductsToTestRooms();
            initTestDBService.addAndSaveInitTestProductsToRooms();

            initTestDBService.addAndSaveHospitalsToInvestors();
            initTestDBService.addAndSaveUsersToHospitals();

            if (httpSession != null) {
                initTestDBService.setInitDBTrue(httpSession);
            }
        }

        return "index";
    }

}
