package pl.krzysztofskul.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void save(Product product) {
        productRepo.save(product);
    }

    public List<Product> loadAll() {
        return productRepo.findAll();
    }

    public Product loadById(Long id) {
        return productRepo.findById(id).get();
    }

    public void delete(Product product) {
        productRepo.delete(product);
    }

}
