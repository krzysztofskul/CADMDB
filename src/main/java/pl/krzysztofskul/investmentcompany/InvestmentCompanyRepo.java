package pl.krzysztofskul.investmentcompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentCompanyRepo extends JpaRepository<InvestmentCompany, Long> {

}
