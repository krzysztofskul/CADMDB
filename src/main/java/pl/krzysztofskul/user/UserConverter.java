package pl.krzysztofskul.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, User> {

    @Autowired
    private UserService userService;

    @Override
    public User convert(String id) {
        return userService.loadById(Long.parseLong(id));
    }
}
