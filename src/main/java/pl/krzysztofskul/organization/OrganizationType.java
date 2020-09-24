package pl.krzysztofskul.organization;

import java.util.ArrayList;
import java.util.Random;

public class OrganizationType {

    private static OrganizationType organizationTypeInstance;

    private ArrayList<String> organizationTypes = new ArrayList<>();

    private OrganizationType() {
        this.setOrganizationTypes();
    }

    public static OrganizationType getOrganizationTypeInstance() {
        if (organizationTypeInstance == null) {
            organizationTypeInstance = new OrganizationType();
        }
        return organizationTypeInstance;
    }

    public String getOrganizationType() {
        return this.organizationTypes.get(new Random().nextInt(this.organizationTypes.size()));
    }

    public void setOrganizationTypes() {
        this.organizationTypes.add("GmbH");
        this.organizationTypes.add("GmbH & Co. KG");

        this.organizationTypes.add("Ltd.");
        this.organizationTypes.add("Corp.");
        this.organizationTypes.add("Inc.");

        this.organizationTypes.add("Sp. z o.o.");
        this.organizationTypes.add("S. A.");
    }
}
