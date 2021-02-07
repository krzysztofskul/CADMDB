package pl.krzysztofskul.product.socket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@Entity
@DiscriminatorValue("socket_elect")
public class SocketElect extends Socket {

    private String voltage;

    private String current;

    public SocketElect() {
    }

    public SocketElect(int plugsInFrame, String installationType, int installationHeightInCm, String description, String dedicatedTo, String voltage, String current) {
        super(plugsInFrame, installationType, installationHeightInCm, description, dedicatedTo);
        this.voltage = voltage;
        this.current = current;
    }
}
