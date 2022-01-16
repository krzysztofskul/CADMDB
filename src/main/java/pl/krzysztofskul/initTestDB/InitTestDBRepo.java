package pl.krzysztofskul.initTestDB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InitTestDBRepo extends JpaRepository<InitTestDBEntity, Long> {
}
