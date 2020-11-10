package pl.krzysztofskul.organization.companyAddress;

import com.thedeanda.lorem.LoremIpsum;

import java.util.Random;

public class CompanyAddressDemoGenerator {

    private static LoremIpsum loremIpsum = LoremIpsum.getInstance();

    private static Random random = new Random();

    public static CompanyAddress getCompanyAddressDemo() {
        CompanyAddress companyAddressDemo = new CompanyAddress();

        companyAddressDemo.setCountry(loremIpsum.getCountry());
        companyAddressDemo.setPostalCode(loremIpsum.getZipCode());
        companyAddressDemo.setCity(loremIpsum.getCity());
        companyAddressDemo.setStreet(loremIpsum.getName()+" street");
        companyAddressDemo.setStreetNo(String.valueOf(random.nextInt(200)));
        companyAddressDemo.setWww("www.google.com");
        companyAddressDemo.setEmail("demo@example.com");
        companyAddressDemo.setPhone(loremIpsum.getPhone());

        return companyAddressDemo;
    }

}
