package pl.krzysztofskul.product;

import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.product.productCategory.ProductCategory;
import pl.krzysztofskul.organization.hospital.department.room.Room;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private Manufacturer manufacturer;

    private String modelName;

    private BigDecimal price;

    private float powerConnectionNeeded;

    private float weight;

    private InstallationType installationType;

    @ManyToMany(mappedBy = "productList", cascade = CascadeType.ALL)
    private List<Room> roomList = new ArrayList<>();

    public Product() {
    }

    public Product(boolean test) {
        if (test) {
            createTestProduct();
        } else {
            new Product();
        }
    }

    private Product createTestProduct() {
        LoremIpsum loremIpsum = new LoremIpsum();
        Random random = new Random();
        /* change first char for uppercase */
        this.setModelName(loremIpsum.getWords(1));
        String modelNameString = this.getModelName();
        char ch = Character.toUpperCase(modelNameString.charAt(0));
        this.setModelName(modelNameString.replace(modelNameString.charAt(0), ch));
        /**/
        /* set values */
//        this.setModelName(loremIpsum.getWords(1));
        this.setPrice(BigDecimal.valueOf(random.nextInt(500000)).divide(BigDecimal.valueOf(100)));
        this.setPowerConnectionNeeded(random.nextInt(100)+101);
        this.setWeight(random.nextInt(50)+51);
        this.setInstallationType(InstallationType.getRandomInstallationType());
        /**/
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String model) {
        this.modelName = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public float getPowerConnectionNeeded() {
        return powerConnectionNeeded;
    }

    public void setPowerConnectionNeeded(float powerConnection) {
        this.powerConnectionNeeded = powerConnection;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public InstallationType getInstallationType() {
        return installationType;
    }

    public void setInstallationType(InstallationType installationType) {
        this.installationType = installationType;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public void addRoom(Room room) {
//        this.roomList.add(room);
        if (room != null) {
            this.roomList.add(room);
        } else {
            throw new NullPointerException();
        }
    }

    public void removeRoom(Room room) {
        this.roomList.remove(room);
        room.removeProduct(this);
    }

}
