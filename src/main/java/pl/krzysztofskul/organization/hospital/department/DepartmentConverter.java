package pl.krzysztofskul.organization.hospital.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class DepartmentConverter implements Converter<String, Department> {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Department convert(String id) {
        return departmentService.loadById(Long.parseLong(id));
    }
}
