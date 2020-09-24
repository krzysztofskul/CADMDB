package pl.krzysztofskul.manufacturer.factory;

import pl.krzysztofskul.manufacturer.Manufacturer;

import javax.persistence.*;

@Entity
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "ManufacturerFactories",
            joinColumns = @JoinColumn(name = "factory_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id")
    )
    private Manufacturer manufacturer;

    public Factory() {
    }

    public Factory(String name) {
        setName(name);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
