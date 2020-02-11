package pl.krzysztofskul.product.productCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductCategoryService {

    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    public ProductCategoryService(ProductCategoryRepo productCategoryRepo) {
        this.productCategoryRepo = productCategoryRepo;
    }

    public void save(ProductCategory productCategory) {
        productCategoryRepo.save(productCategory);
    }

    public List<ProductCategory> loadAll() {
        return productCategoryRepo.findAll();
    }

    public ProductCategory loadById(Long id) {
        return productCategoryRepo.findById(id).get();
    }

    public void delete(ProductCategory productCategory) {
        productCategoryRepo.delete(productCategory);
    }

}
