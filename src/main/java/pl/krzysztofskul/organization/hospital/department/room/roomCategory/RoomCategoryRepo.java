package pl.krzysztofskul.organization.hospital.department.room.roomCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomCategoryRepo extends JpaRepository<RoomCategory, Long> {

    RoomCategory findByCode(String code);

}