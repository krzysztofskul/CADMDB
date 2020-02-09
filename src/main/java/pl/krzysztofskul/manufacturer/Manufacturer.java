package pl.krzysztofskul.manufacturer;

import pl.krzysztofskul.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String details;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> productList = new ArrayList<>();

}