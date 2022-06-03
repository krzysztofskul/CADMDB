package pl.krzysztofskul.healthcare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthcareRepo extends JpaRepository<Healthcare, Long>{

}
