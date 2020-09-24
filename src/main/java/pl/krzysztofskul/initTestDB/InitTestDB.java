package pl.krzysztofskul.initTestDB;

import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.organization.OrganizationType;

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

}
