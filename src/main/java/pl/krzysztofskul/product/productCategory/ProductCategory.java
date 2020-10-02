package pl.krzysztofskul.product.productCategory;

import pl.krzysztofskul.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String nameSingular;

    private String namePlural;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> productList = new ArrayList<>();

    public ProductCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameSingular() {
        return nameSingular;
    }

    public void setNameSingular(String nameSingular) {
        this.nameSingular = nameSingular;
    }

    public String getNamePlural() {
        return namePlural;
    }

    public void setNamePlural(String name) {
        this.namePlural = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
