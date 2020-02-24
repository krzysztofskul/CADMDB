package pl.krzysztofskul.product.productCategory;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.product.Product;

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

    public List<ProductCategory> loadAllWithProducts() {
        List<ProductCategory> productCategoryList = productCategoryRepo.findAll();
        for (ProductCategory productCategory : productCategoryList) {
            Hibernate.initialize(productCategory.getProductList());
        }
        return productCategoryList;
    }

    public ProductCategory loadById(Long id) {
        return productCategoryRepo.findById(id).get();
    }

    public ProductCategory loadByCode(String code) {
        return productCategoryRepo.findByCode(code);
    }

    public void delete(ProductCategory productCategory) {
        productCategoryRepo.delete(productCategory);
    }

}
