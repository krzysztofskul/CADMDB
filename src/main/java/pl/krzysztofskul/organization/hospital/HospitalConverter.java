package pl.krzysztofskul.organization.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class HospitalConverter implements Converter<String, Hospital> {

    @Autowired
    private HospitalService hospitalService;

    @Override
    public Hospital convert(String id) {
        return hospitalService.loadById(Long.parseLong(id));
    }
}
