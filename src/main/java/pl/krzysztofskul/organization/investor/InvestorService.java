package pl.krzysztofskul.organization.investor;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvestorService {

    private InvestorRepo investorRepo;

    @Autowired
    public InvestorService(InvestorRepo investorRepo) {
        this.investorRepo = investorRepo;
    }

    public void save(Investor investor) {
        investorRepo.save(investor);
    }

    public List<Investor> loadAll() {
        return investorRepo.findAll();
    }

    public List<Investor> loadAllWithHospitals() {
        List<Investor> investorList = this.loadAll();
        for (Investor investor : investorList) {
            Hibernate.initialize(investor.getHospitalList());
        }
        return investorList;
    }

    public Investor loadById(Long id) {
        return investorRepo.findById(id).get();
    }

}
