package pl.krzysztofskul.manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
}