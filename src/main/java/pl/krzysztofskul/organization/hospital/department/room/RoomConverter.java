package pl.krzysztofskul.organization.hospital.department.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class RoomConverter implements Converter<String, Room> {

    @Autowired
    private RoomService roomService;

    @Override
    public Room convert(String id) {
        return roomService.loadById(Long.valueOf(id));
    }
}
