package pl.krzysztofskul.organization.hospital.department.room;

import pl.krzysztofskul.organization.organizationStatus.OrganizationStatus;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.organization.Organization;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;
import pl.krzysztofskul.product.socket.Socket;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends Organization {

    /**
     * PARAMETERS
     */

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private Integer streetNo;

    private String www;

    private String email;

    private String phone;

    private String number;

    private String fullPath;

    @ManyToOne
    private User userManager;

    private float area;

    private float height;

    private float loadActual;

    private float loadCapacity;

    private float temperature;

    private int illumination;

    private float airChanges;

    private boolean airConditioning;

    private String floor;

    private String ceiling;

    private String walls;

    @Column(length = 255*8)
    private String remarks;

    @ManyToOne
    private Department department;

    @ManyToOne
    private RoomCategory roomCategory;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private OrganizationStatus organizationStatus;

    @ManyToMany
    @JoinTable(
            name = "rooms_products",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "rooms_sockets",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "socket_id")
    )
    private List<Socket> socketList = new ArrayList<>();

    /**
     * CONSTRUCTORS
     */

    public Room() {
    }

    @Override
    public void setName(String name) {
        if (null == name || name.equals("")) {
            super.setName(this.getRoomCategory().getName());
        }
        super.setName(name);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * GETTERS AND SETTERS
     */



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

    public float getLoadActual() {
        return loadActual;
    }

    public void setLoadActual(float loadActual) {
        this.loadActual = loadActual;
    }

    public float getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(float loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public OrganizationStatus getOrganizationStatus() {
        return organizationStatus;
    }

    public void setOrganizationStatus(OrganizationStatus organizationStatus) {
        this.organizationStatus = organizationStatus;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        setLoadActual(0f);
        this.productList = productList;
        for (Product product : this.productList) {
            this.loadActual += product.getWeight();
        }
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public User getUserManager() {
        return userManager;
    }

    public void setUserManager(User userManager) {
        this.userManager = userManager;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getIllumination() {
        return illumination;
    }

    public void setIllumination(int illumination) {
        this.illumination = illumination;
    }

    public float getAirChanges() {
        return airChanges;
    }

    public void setAirChanges(float airChanges) {
        this.airChanges = airChanges;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCeiling() {
        return ceiling;
    }

    public void setCeiling(String ceiling) {
        this.ceiling = ceiling;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Socket> getSocketList() {
        return socketList;
    }

    public void setSocketList(List<Socket> socketList) {
        this.socketList = socketList;
    }

    /**
     * OTHER METHODS
     */

    public void addProduct(Product product) {
        this.productList.add(product);
        if (this.productList != null) {
            this.loadActual += product.getWeight();
        } else {
            this.loadActual = 0f;
        }
    }

    public void removeProduct(Product product) {
        if (product != null) {
            this.productList.remove(product);
            if (this.productList != null) {
                this.loadActual -= product.getWeight();
            } else {
                this.loadActual = 0f;
            }
        }
    }

    @PrePersist
    public void postPersist() {
        this.setFullPath(
                this.getDepartment().getHospital().getName() + " " +
                        this.getDepartment().getDepartmentCategory().getName() + " " +
                        this.getNumber() + " " + this.getRoomCategory().getName()
        );
    }

    public String getClassName() {
        return "room";
    }

}