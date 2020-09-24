package pl.krzysztofskul.manufacturer.factory;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FactoryService {

    private FactoryRepo factoryRepo;

    @Autowired
    public FactoryService(FactoryRepo factoryRepo) {
        this.factoryRepo = factoryRepo;
    }

    public void save(Factory factory) {
        factoryRepo.save(factory);
    }

    public Factory loadById(Long id) {
        return factoryRepo.findById(id).get();
    }

    public List<Factory> loadAll() {
        return factoryRepo.findAll();
    }

}
