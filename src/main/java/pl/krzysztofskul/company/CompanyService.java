package pl.krzysztofskul.company;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService {

	private CompanyRepo companyRepo;

	public CompanyService(CompanyRepo companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}
	
	public Company save(Company company) {
		return companyRepo.save(company);
	}
	
	public List<Company> loadAll() {
		return companyRepo.findAll();
	}
	
}
