package pl.krzysztofskul.organization.organizationStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationStatusService {

    private OrganizationStatusRepo organizationStatusRepo;

    @Autowired
    public OrganizationStatusService(OrganizationStatusRepo organizationStatusRepo) {
        this.organizationStatusRepo = organizationStatusRepo;
    }

    public List<OrganizationStatus> loadAll() {
        return organizationStatusRepo.findAll();
    }

}
