package pl.krzysztofskul.product.socket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.krzysztofskul.organization.hospital.department.room.Room;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
//@MappedSuperclass
@Entity(name = "sockets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "socket_type",
        discriminatorType = DiscriminatorType.STRING
    )
public /*abstract*/ class Socket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int plugsInFrame;

    private String installationType;

    private int installationHeightInCm;

    private String description;

    private String dedicatedTo;

    @ManyToMany(mappedBy = "socketList")
    @JsonIgnore
    private List<Room> roomList = new ArrayList<>();

    public Socket() {
    }

    public Socket(int plugsInFrame, String installationType, int installationHeightInCm, String description, String dedicatedTo) {
        this.plugsInFrame = plugsInFrame;
        this.installationType = installationType;
        this.installationHeightInCm = installationHeightInCm;
        this.description = description;
        this.dedicatedTo = dedicatedTo;
    }

}