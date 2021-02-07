package pl.krzysztofskul.product.socket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@Entity
@DiscriminatorValue("socket_teltech")
public class SocketTelTech extends Socket {

    private SocketTelTechEnum type;

    public SocketTelTech() {
        super();
    }

    public SocketTelTech(int plugsInFrame, String installationType, int installationHeightInCm, String description, String dedicatedTo, SocketTelTechEnum type) {
        super(plugsInFrame, installationType, installationHeightInCm, description, dedicatedTo);
        this.type = type;
    }
}
