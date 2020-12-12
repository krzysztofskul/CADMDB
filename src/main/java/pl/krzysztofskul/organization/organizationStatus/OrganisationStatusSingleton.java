package pl.krzysztofskul.organization.organizationStatus;

import java.util.ArrayList;
import java.util.List;

public class OrganisationStatusSingleton {

    private static OrganisationStatusSingleton organisationStatusSingleton;

    private List<OrganizationStatus> organizationStatusList = new ArrayList<>();

    private OrganisationStatusSingleton(){};

    public static OrganisationStatusSingleton getOrganisationStatusSingleton() {
        if (null == organisationStatusSingleton) {
            organisationStatusSingleton = new OrganisationStatusSingleton();
            for (OrganizationStatusEnum organizationStatusEnum : OrganizationStatusEnum.values()) {
                organisationStatusSingleton.organizationStatusList.add(new OrganizationStatus(organizationStatusEnum));
            }
        }
        return organisationStatusSingleton;
    }

    public OrganizationStatus getOrganizationStatus(OrganizationStatusEnum organizationStatusEnum) {
        for (OrganizationStatus organizationStatus : organizationStatusList) {
            if (organizationStatus.getOrganizationStatusEnum().equals(organizationStatusEnum)) {
                return organizationStatus;
            }
        }
        return null;
    }

    public int getOrganizationListSize() {
        return organizationStatusList.size();
    }

}
