package pl.krzysztofskul.organization.organizationStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationStatusRepo extends JpaRepository<OrganizationStatus, Long> {
}
