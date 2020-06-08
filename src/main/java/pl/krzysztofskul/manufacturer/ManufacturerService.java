package pl.krzysztofskul.manufacturer;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ManufacturerService {

    private ManufacturerRepo manufacturerRepo;

    @Autowired
    public ManufacturerService(ManufacturerRepo manufacturerRepo) {
        this.manufacturerRepo = manufacturerRepo;
    }

    public void save(Manufacturer manufacturer) {
        manufacturerRepo.save(manufacturer);
    }

    public List<Manufacturer> loadAll() {
        return manufacturerRepo.findAll();
    }

    public List<Manufacturer> loadAllWithProducts() {
        List<Manufacturer> manufacturers = manufacturerRepo.findAll();
        for (Manufacturer manufacturer : manufacturers) {
            Hibernate.initialize(manufacturer.getProductList());
        }

        return manufacturers;
    }

    public Manufacturer loadById(Long id) {
        return manufacturerRepo.findById(id).get();
    }

    public Manufacturer loadByIdWithDistributors(Long id) {
        Manufacturer manufacturer = manufacturerRepo.findById(id).get();
        Hibernate.initialize(manufacturer.getDistributorList());
        return manufacturer;
    }

    public void delete(Manufacturer manufacturer) {
        manufacturerRepo.delete(manufacturer);
    }

}
