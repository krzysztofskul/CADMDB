package pl.krzysztofskul.manufacturer.distributor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistributorService {

    private DistributorRepo distributorRepo;

    @Autowired
    public DistributorService(DistributorRepo distributorRepo) {
        this.distributorRepo = distributorRepo;
    }

    public void save(Distributor distributor) {
        distributorRepo.save(distributor);
    }

    public Distributor loadById(Long id) {
        return distributorRepo.findById(id).get();
    }

    public List<Distributor> loadAll() {
        return distributorRepo.findAll();
    }

}
