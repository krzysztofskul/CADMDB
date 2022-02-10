package pl.krzysztofskul.initTestDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InitTestDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isTestDBInitiated = false;

    public InitTestDBEntity() {
    }

    public InitTestDBEntity(Long id, boolean isTestDBInitiated) {
        this.id = id;
        this.isTestDBInitiated = isTestDBInitiated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTestDBInitiated() {
        return isTestDBInitiated;
    }

    public void setTestDBInitiated(boolean testDBInitiated) {
        isTestDBInitiated = testDBInitiated;
    }
}
