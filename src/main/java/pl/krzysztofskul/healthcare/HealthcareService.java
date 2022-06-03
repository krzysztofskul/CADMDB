package pl.krzysztofskul.healthcare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HealthcareService<T> {

	private HealthcareRepo healthcareRepo;

	@Autowired
	public HealthcareService(HealthcareRepo healthcareRepo) {
		super();
		this.healthcareRepo = healthcareRepo;
	}
	
	public Healthcare save(Healthcare<T> healthcare) {
		healthcareRepo.save(healthcare);
		return healthcare;
		
	}
	
}
