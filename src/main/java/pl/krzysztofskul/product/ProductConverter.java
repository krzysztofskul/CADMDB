package pl.krzysztofskul.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ProductConverter implements Converter<String, Product> {

    @Autowired
    private ProductService productService;

    @Override
    public Product convert(String id) {
        return productService.loadById(Long.valueOf(id));
    }

}
