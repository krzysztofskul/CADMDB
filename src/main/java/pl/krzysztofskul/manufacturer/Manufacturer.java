package pl.krzysztofskul.manufacturer;

import pl.krzysztofskul.manufacturer.distributor.Distributor;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String details;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> productList = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer")
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.PERSIST)
    private List<Distributor> distributorList = new ArrayList<>();;

    public Manufacturer() {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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

    public void addDistributor(Distributor distributor) {
        this.distributorList.add(distributor);
        for (Distributor d : this.distributorList) {
            d.setManufacturer(this);
        }
    }

    public void removeDistributor(Distributor distributor) {
        this.distributorList.remove(distributor);
        for (Distributor d : this.distributorList) {
            d.setManufacturer(null);
        }
    }

}