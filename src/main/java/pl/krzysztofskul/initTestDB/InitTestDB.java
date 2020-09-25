package pl.krzysztofskul.initTestDB;

import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.organization.OrganizationType;
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

public class InitTestDB {

    private static InitTestDB initTestDBInstance;

    private InitTestDB(){};

    public static InitTestDB getInitTestDBInstance() {
        if (initTestDBInstance == null) {
            initTestDBInstance = new InitTestDB();
        }
        return initTestDBInstance;
    }

    public List<Manufacturer> getInitTestManufacturers(int amount) {
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

    public List<Product> getInitTestProducts(ProductCategory productCategory) {
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

    public List<UserCategory> getInitTestUserCategories() {
        List<UserCategory> userCategoryList = new ArrayList<>();

        UserCategory userCategory;

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.ADMINISTRATOR);
        userCategory.setCode("ADMIN");
        userCategory.setName("Admin");
        userCategory.setDescription("Administrator of the website");
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
        userCategory.setUserCategoryEnum(UserCategoryEnum.MANUFACTURER_EMPLOYEE);
        userCategory.setCode("MANUFACTURER EMPLOYEE");
        userCategory.setName("Manufacturer employee");
        userCategory.setDescription("Manufacturer employee");
        userCategoryList.add(userCategory);

        userCategory = new UserCategory();
        userCategory.setUserCategoryEnum(UserCategoryEnum.MANUFACTURER_EMPLOYEE_GUEST);
        userCategory.setCode("MANUFACTURER EMPLOYEE (GUEST)");
        userCategory.setName("Manufacturer employee (guest)");
        userCategory.setDescription("Manufacturer employee (guest)");
        userCategoryList.add(userCategory);

        return userCategoryList;
    }

    public List<User> getInitTestUsers(List<UserCategory> userCategoryList) {
        List<User> userList = new ArrayList<>();

        for (UserCategory userCategory : userCategoryList) {
            for (int i = 0; i < 2 ; i++) {
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

                user.setUserCategory(userCategory);

                userList.add(user);

            }
        }

        return userList;
    }

}