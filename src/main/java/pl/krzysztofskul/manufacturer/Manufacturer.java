package pl.krzysztofskul.manufacturer;

import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.manufacturer.distributor.Distributor;
import pl.krzysztofskul.manufacturer.factory.Factory;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String companyType;

    private String country;

    private String postalCode;

    private String city;

    private String streetName;

    private String streetNumber;

    private String phoneNumber;

    private String email;

    private String website;

    @Column(length = 2040)
    private String description;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer")
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.PERSIST)
    private List<Distributor> distributorList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE})
    @JoinTable(
            name = "ManufacturerFactories",
            joinColumns = @JoinColumn(name = "manufacturer_id"),
            inverseJoinColumns = @JoinColumn(name = "factory_id")
    )
    private List<Factory> factoryList = new ArrayList<>();

    public Manufacturer() {
    }

    public Manufacturer(boolean test) {
        if (test) {
            createTestManufacturer();
        } else {
            new Manufacturer();
        }
    }

    public Manufacturer createTestManufacturer() {
        LoremIpsum loremIpsum = new LoremIpsum();
        Random random = new Random();
        this.setName(loremIpsum.getTitle(1)+" Ltd.");
        this.setDescription(loremIpsum.getCountry()+", "+loremIpsum.getZipCode()+" "+loremIpsum.getCity()+", "+loremIpsum.getName()+" Street no. "+(random.nextInt(100)+1));
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String details) {
        this.description = details;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
            List<Product> productListExisting = this.productList;
            for (Product product : productListExisting) {
                this.removeProduct(product);
            }
        for (Product product : productList) {
            this.addProduct(product);
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Distributor> getDistributorList() {
        return distributorList;
    }

    public void setDistributorList(List<Distributor> distributorList) {
        this.distributorList = distributorList;
    }

    public List<Factory> getFactoryList() {
        return factoryList;
    }

    public void setFactoryList(List<Factory> factoryList) {
        this.factoryList = factoryList;
    }

    public void addProduct(Product product) {
        product.setManufacturer(this);
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
//            for (Product productExisted : productList) {
//                if (product.getId().equals(productExisted.getId())) {
//                    productList.remove(productExisted);
//                }
//            }
        product.setManufacturer(null);
        this.productList.remove(product);
    }

    public void addDistributor(Distributor distributor) {
        this.distributorList.add(distributor);
        distributor.setManufacturer(this);
    }

    public void removeDistributor(Distributor distributor) {
        this.distributorList.remove(distributor);
        distributor.setManufacturer(null);
    }

    public void addFactory(Factory factory) {
        this.factoryList.add(factory);
    }

    public void removeFactory(Factory factory) {
        this.factoryList.remove(factory);
    }

}