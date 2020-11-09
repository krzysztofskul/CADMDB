package pl.krzysztofskul.numberConverters;

import org.springframework.core.convert.converter.Converter;

public class FloatConverter implements Converter<String, Float> {

    @Override
    public Float convert(String s) {
        Float number = Float.parseFloat(s);
        return number;
    }
}
