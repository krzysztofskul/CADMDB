package pl.krzysztofskul.investmentcompany;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvestmentCompanyService {

	/**
	 * params.
	 */
	private InvestmentCompanyRepo investmentCompanyRepo;

	/**
	 * constr.
	 */
	
	public InvestmentCompanyService(InvestmentCompanyRepo investmentCompanyRepo) {
		super();
		this.investmentCompanyRepo = investmentCompanyRepo;
	}
	
	/**
	 * crud methods
	 */
	
	public InvestmentCompany save(InvestmentCompany investmentCompany) {
		return investmentCompanyRepo.save(investmentCompany);
	}
	
	public List<InvestmentCompany> loadAll() {
		return investmentCompanyRepo.findAll();
	}

	public InvestmentCompany loadById(Long id) {
		return investmentCompanyRepo.findById(id).get();
	}
	
}
