package pl.krzysztofskul.organization.hospital.department.room;

import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.organization.Organization;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends Organization {

    private String number;

    @ManyToOne
    private Department department;

    @ManyToOne
    private RoomCategory roomCategory;

    @ManyToMany
    @JoinTable(
            name = "rooms_products",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList = new ArrayList<>();

    public Room() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }

}