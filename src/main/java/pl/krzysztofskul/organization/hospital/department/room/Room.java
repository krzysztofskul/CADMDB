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

    private String fullPath;

    private float area;

    private float height;

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

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
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

    @PrePersist
    public void postPersist() {
        this.setFullPath(
                this.getDepartment().getHospital().getName() + " " +
                        this.getDepartment().getDepartmentCategory().getName() + " " +
                        this.getNumber() + " " + this.getRoomCategory().getName()
        );
    }

}