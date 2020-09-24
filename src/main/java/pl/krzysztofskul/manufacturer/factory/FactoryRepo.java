package pl.krzysztofskul.manufacturer.factory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FactoryRepo extends JpaRepository<Factory, Long> {
}
