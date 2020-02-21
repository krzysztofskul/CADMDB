package pl.krzysztofskul.bigDecimal;

import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

public class BigDecimalConverter implements Converter<String, BigDecimal> {

    @Override
    public BigDecimal convert(String string) {
        return new BigDecimal(string);
    }
}
