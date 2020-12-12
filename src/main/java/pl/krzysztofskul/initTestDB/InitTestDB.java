package pl.krzysztofskul.initTestDB;

import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.organization.OrganizationType;
import pl.krzysztofskul.organization.companyAddress.CompanyAddress;
import pl.krzysztofskul.organization.companyAddress.CompanyAddressDemoGenerator;
import pl.krzysztofskul.organization.companyType.CompanyType;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategory;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;
import pl.krzysztofskul.organization.investor.Investor;
import pl.krzysztofskul.organization.investor.InvestorDemoGenerator;
import pl.krzysztofskul.organization.organizationStatus.OrganisationStatusSingleton;
import pl.krzysztofskul.organization.organizationStatus.OrganizationStatus;
import pl.krzysztofskul.organization.organizationStatus.OrganizationStatusEnum;
import pl.krzysztofskul.product.InstallationType;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.productCategory.ProductCategory;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.userCategory.UserCategory;
import pl.krzysztofskul.user.userCategory.UserCategoryEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Singleton class to initialize demo/test database.
 * */

public class InitTestDB {

    /**
     * Field which stores information if demo/test database has been initialized.
     * */
    private static boolean initDB = false;

    /**
     * Field which stores the singleton InitTestDB instance.
     * */
    private static InitTestDB initTestDBInstance;

    /**
     * Constructor.
     * */
    private InitTestDB(){};

    /**
     * InitTestDB creator.
     * */
    public static InitTestDB getInitTestDBInstance() {
        if (initTestDBInstance == null) {
            initTestDBInstance = new InitTestDB();
        }
        return initTestDBInstance;
    }

    /**
     * Getters and setters for static initDB field
     * */

    public static boolean isInitDB() {
        return initDB;
    }

    public static void setInitDB(boolean initDB) {
        InitTestDB.initDB = initDB;
    }

    /**
     * Methods which initialize demo/test objects to set up into the database.
     * */

    public List<Manufacturer> createAndGetInitTestManufacturers(int amount) {
        List<Manufacturer> manufacturerList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(LoremIpsum.getInstance().getTitle(1, 3));
            manufacturer.setCompanyType(OrganizationType.getOrganizationTypeInstance().getOrganizationType());
            manufacturer.setCountry(LoremIpsum.getInstance().getCountry());
            manufacturer.setPostalCode(LoremIpsum.getInstance().getZipCode());
            manufacturer.setCity(LoremIpsum.getInstance().getCity());
            manufacturer.setStreetName(LoremIpsum.getInstance().getName());
            manufacturer.setStreetNumber(String.valueOf(new Random().nextInt(298)+1));
            manufacturer.setPhoneNumber(LoremIpsum.getInstance().getPhone());
            manufacturer.setEmail(LoremIpsum.getInstance().getEmail());
            manufacturer.setWebsite(LoremIpsum.getInstance().getUrl());
            manufacturer.setDescription(LoremIpsum.getInstance().getParagraphs(1, 2));
            manufacturerList.add(manufacturer);
        }
        return manufacturerList;
    }

    public List<Product> createAndGetInitTestProducts(ProductCategory productCategory) {
        List<Product> productInitTestList = new ArrayList<>();

        if (productCategory.getCode().equals("AA0000")) {
            for (int i = 0; i < 4; i++) {
                Product product = new Product();
                product.setProductCategory(productCategory);
                product.setModelName(LoremIpsum.getInstance().getTitle(1));
                product.setPrice(
                        BigDecimal.valueOf(Long.parseLong("75000"))
                                .add(BigDecimal.valueOf(new Random().nextDouble()*10000))
                );
                product.setPowerConnectionNeeded(
                        1000.00f - new Random().nextFloat()*100)
                ;
                product.setWeight(150.00f - new Random().nextFloat()*10);
                switch (i) {
                    case 0: {
                        product.setInstallationType(InstallationType.FIXED_FLOOR);
                        break;
                    }
                    case 1: {
                        product.setInstallationType(InstallationType.STANDALONE_FLOOR);
                        break;
                    }
                    case 2:
                    case 3: {
                        product.setInstallationType(InstallationType.MOBILE);
                        break;
                    }
                }
                productInitTestList.add(product);
            }
        }

        if (productCategory.getCode().equals("AB1000")) {
            for (int i = 0; i < 4; i++) {
                Product product = new Product();
                product.setProductCategory(productCategory);
                product.setModelName(LoremIpsum.getInstance().getTitle(1));
                product.setPrice(
                        BigDecimal.valueOf(Long.parseLong("125000"))
                                .add(BigDecimal.valueOf(new Random().nextDouble()*10000))
                );
                product.setPowerConnectionNeeded(
                        1000.00f - new Random().nextFloat()*100)
                ;
                product.setWeight(150.00f - new Random().nextFloat()*10);
                switch (i) {
                    case 0: {
                        product.setInstallationType(InstallationType.FIXED_FLOOR);
                        break;
                    }
                    case 1: {
                        product.setInstallationType(InstallationType.STANDALONE_FLOOR);
                        break;
                    }
                    case 2:
                    case 3: {
                        product.setInstallationType(InstallationType.MOBILE);
                        break;
                    }
                }
                productInitTestList.add(product);
            }
        }

        if (productCategory.getCode().equals("AC1000")) {

            for (int i = 0; i < 3; i++) {
                Product product = new Product();
                product.setProductCategory(productCategory);
                product.setModelName(LoremIpsum.getInstance().getTitle(1));
                product.setPrice(
                        BigDecimal.valueOf(Long.parseLong("150000"))
                                .add(BigDecimal.valueOf(new Random().nextDouble()*10000))
                );
                product.setPowerConnectionNeeded(
                        1000.00f - new Random().nextFloat()*100)
                ;
                product.setWeight(150.00f - new Random().nextFloat()*10);
                switch (i) {
                    case 0: {
                        product.setInstallationType(InstallationType.FIXED_CEILING);
                        break;
                    }
                    case 1: {
                        product.setInstallationType(InstallationType.FIXED_WALL);
                        break;
                    }
                    case 2: {
                        product.setInstallationType(InstallationType.MOBILE);
                        break;
                    }
                }
                productInitTestList.add(product);
            }
        }

        if (productCategory.getCode().equals("AH1000")) {

            for (int i = 0; i < 3; i++) {
                Product product = new Product();
                product.setProductCategory(productCategory);
                product.setModelName(LoremIpsum.getInstance().getTitle(1));
                product.setPrice(
                        BigDecimal.valueOf(Long.parseLong("150000"))
                                .add(BigDecimal.valueOf(new Random().nextDouble()*10000))
                );
                product.setPowerConnectionNeeded(
                        1000.00f - new Random().nextFloat()*100)
                ;
                product.setWeight(150.00f - new Random().nextFloat()*10);
                switch (i) {
                    case 0: {
                        product.setInstallationType(InstallationType.FIXED_FLOOR);
                        break;
                    }
                    case 1: {
                        product.setInstallationType(InstallationType.MOBILE);
                        break;
                    }
                    case 2: {
                        product.setInstallationType(InstallationType.BIULT_IN);
                        break;
                    }
                }
                productInitTestList.add(product);
            }
        }

        return productInitTestList;
    }

    public List<UserCategory> createAndGetInitTestUserCategories() {
        List<UserCategory> userCategoryList = new ArrayList<>();

        UserCategory userCategory;

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.ADMIN);
        userCategory.setCode("ADMIN");
        userCategory.setName("Admin");
        userCategory.setDescription("Administrator of the website");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.INVESTOR);
        userCategory.setCode("INVESTOR");
        userCategory.setName("Investor");
        userCategory.setDescription("Investor");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.INVESTOR_GUEST);
        userCategory.setCode("INVESTOR (GUEST)");
        userCategory.setName("Investor (guest)");
        userCategory.setDescription("Investor (guest)");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER);
        userCategory.setCode("HOSPITAL MANAGER");
        userCategory.setName("Hospital manager");
        userCategory.setDescription("Hospital manager");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER_GUEST);
        userCategory.setCode("HOSPITAL MANAGER (GUEST)");
        userCategory.setName("Hospital manager (guest)");
        userCategory.setDescription("Hospital manager (guest)");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.HOSPITAL_EMPLOYEE);
        userCategory.setCode("HOSPITAL EMPLOYEE");
        userCategory.setName("Hospital employee");
        userCategory.setDescription("Hospital employee");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.HOSPITAL_EMPLOYEE_GUEST);
        userCategory.setCode("HOSPITAL EMPLOYEE (GUEST)");
        userCategory.setName("Hospital employee (guest)");
        userCategory.setDescription("Hospital employee (guest)");
        userCategoryList.add(userCategory);
        
        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.MANUFACTURER);
        userCategory.setCode("MANUFACTURER");
        userCategory.setName("Manufacturer");
        userCategory.setDescription("Manufacturer");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.MANUFACTURER_GUEST);
        userCategory.setCode("MANUFACTURER (GUEST)");
        userCategory.setName("Manufacturer (guest)");
        userCategory.setDescription("Manufacturer (guest)");
        userCategoryList.add(userCategory);

        return userCategoryList;
    }

    public List<User> createAndGetInitTestUsers(List<UserCategory> userCategoryList) {
        List<User> userList = new ArrayList<>();

        int j;
        for (UserCategory userCategory : userCategoryList) {
            if (userCategory.getCode().contains("GUEST") || userCategory.getCode().contains("ADMIN")) {
              j = 1;
            } else {
                j = 3;
            }
            for (int i = 0; i < j ; i++) {
                User user = new User();

                user.setNameFirst(LoremIpsum.getInstance().getFirstName());
                user.setNameLast(LoremIpsum.getInstance().getLastName());
                user.setEmail(
                        user.getNameFirst().toLowerCase()+"."+user.getNameLast().toLowerCase()+"@example.com"
                );

                if (userCategory.getCode().contains("GUEST")) {
                    user.setPassword("guest");
                } else {
                    user.setPassword(LoremIpsum.getInstance().getWords(1));
                }

                //user.setUserCategory(userCategory);
                user.addUserCategory(userCategory);

                userList.add(user);

            }
        }

        return userList;
    }

    public List<Investor> createAndGetInitTestInvestors() {

        List<Investor> initTestInvestors = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Investor investor = new Investor();
            investor.setName(LoremIpsum.getInstance().getTitle(1)+" Investments");
            CompanyAddress companyAddress = CompanyAddressDemoGenerator.getCompanyAddressDemo();
            investor.setCompanyAddress(companyAddress);

            initTestInvestors.add(investor);
        }

        return initTestInvestors;
    }

    public List<Hospital> createAndGetInitTestHospitals() {
        List<Hospital> hospitalList = new ArrayList<>();
        
        LoremIpsum loremIpsum = LoremIpsum.getInstance();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Hospital hospital = new Hospital();
            hospital.setCountry(loremIpsum.getCountry());
            hospital.setPostalCode(loremIpsum.getZipCode());
            hospital.setCity(loremIpsum.getCity());
            hospital.setStreet(loremIpsum.getName());
            hospital.setStreetNo(random.nextInt(200)+1);
            hospital.setName(loremIpsum.getTitle(1, 2) + " Hospital");
            hospital.setRemarks(loremIpsum.getParagraphs(1, 1));
//            hospital.setArea(new Random().nextInt(1000)+1000);
            hospital.setArea(Float.parseFloat(String.valueOf(new Random().nextInt(1000)+1000)));
            hospital.setBudget(BigDecimal.valueOf(new Random().nextFloat()*10000000).add(BigDecimal.valueOf(+10000000f)));
            hospitalList.add(hospital);
        }

        return hospitalList;
    }

    public List<DepartmentCategory> createAndGetInitTestDepartmentCategoryList() {
        List<DepartmentCategory> departmentCategoryList = new ArrayList<>();

        departmentCategoryList.add(new DepartmentCategory("A", "Administration"));
        departmentCategoryList.add(new DepartmentCategory("CSSD", "Central sterile services department"));
        departmentCategoryList.add(new DepartmentCategory("OT", "Operating theater"));
        departmentCategoryList.add(new DepartmentCategory("ICU", "Intensive care unit"));
        departmentCategoryList.add(new DepartmentCategory("E", "Emergency department"));
        return departmentCategoryList;
    }

    public List<Department> createAndGetInitTestDepartmentList(List<DepartmentCategory> departmentCategoryList) {
        List<Department> departmentList = new ArrayList<>();

        for (DepartmentCategory departmentCategory : departmentCategoryList) {
            Department department = new Department();
            department.setDepartmentCategory(departmentCategory);
            department.setName(departmentCategory.getName());
            department.setRemarks(LoremIpsum.getInstance().getParagraphs(1, 1));
            department.setArea(new Random().nextInt(100)+100);
            department.setBudget(BigDecimal.valueOf(new Random().nextFloat()*1000000).add(BigDecimal.valueOf(1000000f)));
            departmentList.add(department);
        }

        return departmentList;
    }
    
    public List<RoomCategory> createAndGetInitTestRoomCategoryList() {
        List<RoomCategory> roomCategoryList = new ArrayList<>();
        
        roomCategoryList.add(new RoomCategory("OR", "Operating room"));
        roomCategoryList.add(new RoomCategory("OR-S", "Operating room (surgical)"));
        roomCategoryList.add(new RoomCategory("OR-NS", "Operating room (neuro-surgical)"));
        roomCategoryList.add(new RoomCategory("OR-PP", "Preparation room (patients)"));
        roomCategoryList.add(new RoomCategory("OR-SP", "Preparation room (doctors)"));
        roomCategoryList.add(new RoomCategory("OR-POST", "Post-operating room"));
        roomCategoryList.add(new RoomCategory("PR", "Patient room"));
        roomCategoryList.add(new RoomCategory("PR1", "Patient room (1 bed)"));
        roomCategoryList.add(new RoomCategory("PR2", "Patient room (2 beds)"));
        roomCategoryList.add(new RoomCategory("ICR", "Intensive care room"));
        roomCategoryList.add(new RoomCategory("ICR1", "Intensive care room (1 bed)"));
        roomCategoryList.add(new RoomCategory("ICR2", "Intensive care room (2 beds)"));
        roomCategoryList.add(new RoomCategory("CSSD-C", "Cleaning room"));
        roomCategoryList.add(new RoomCategory("CSSD-S", "Sterilization room"));

        return roomCategoryList;        
    }

    public List<Room> createAndGetInitTestRoomList(List<RoomCategory> roomCategoryList) {
        List<Room> roomList = new ArrayList<>();

        Random random = new Random();
        
        for (RoomCategory roomCategory : roomCategoryList) {
            Room room = new Room();

            room.setRoomCategory(roomCategory);
            room.setName(roomCategory.getName());
            room.setRemarks(LoremIpsum.getInstance().getParagraphs(1, 1));
            room.setArea(random.nextInt(10)+15);
            room.setHeight(3.5f);
            room.setBudget(BigDecimal.valueOf(random.nextFloat()*500000).add(BigDecimal.valueOf(250000f)));
            room.setTemperature(20.0f + random.nextFloat()*0.5f);
            room.setAirConditioning(random.nextBoolean());
            room.setAirChanges(random.nextFloat()*10);
            room.setIllumination(1000 + random.nextInt(1000));
            room.setWalls(LoremIpsum.getInstance().getWords(2, 5));
            room.setCeiling(LoremIpsum.getInstance().getWords(2, 5));
            room.setFloor(LoremIpsum.getInstance().getWords(1, 5));
            room.setNumber(String.valueOf(random.nextInt(999)+1));

            room.setOrganizationStatus(getRandomOrganizationStatus());

            roomList.add(room);
        }

        return roomList;

    }

    private OrganizationStatus getRandomOrganizationStatus() {

        int randomNumber = new Random().nextInt(OrganisationStatusSingleton.getOrganisationStatusSingleton().getOrganizationListSize());

        switch (randomNumber) {
            case 0: return OrganisationStatusSingleton.getOrganisationStatusSingleton().getOrganizationStatus(OrganizationStatusEnum.PLANNING);
            case 1: return OrganisationStatusSingleton.getOrganisationStatusSingleton().getOrganizationStatus(OrganizationStatusEnum.DESIGNING);
            case 2: return OrganisationStatusSingleton.getOrganisationStatusSingleton().getOrganizationStatus(OrganizationStatusEnum.DESIGNING_FINISHED);
            case 3: return OrganisationStatusSingleton.getOrganisationStatusSingleton().getOrganizationStatus(OrganizationStatusEnum.CONSTRUCTION_WORKS);
            case 4: return OrganisationStatusSingleton.getOrganisationStatusSingleton().getOrganizationStatus(OrganizationStatusEnum.CONSTRUCTION_WORKS_FINISHED);
            case 5: return OrganisationStatusSingleton.getOrganisationStatusSingleton().getOrganizationStatus(OrganizationStatusEnum.IN_EXPLOITATION);
            default: return null;
        }

    }

}