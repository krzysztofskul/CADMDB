package pl.krzysztofskul.product.productCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {

    ProductCategory findByCode(String code);

}