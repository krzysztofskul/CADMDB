package pl.krzysztofskul.initTestDB;

import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.organization.OrganizationType;
import pl.krzysztofskul.product.InstallationType;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.productCategory.ProductCategory;

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
        return productInitTestList;
    }

}
