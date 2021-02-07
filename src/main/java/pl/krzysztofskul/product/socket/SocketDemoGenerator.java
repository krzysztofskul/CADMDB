package pl.krzysztofskul.product.socket;

import java.util.ArrayList;
import java.util.List;

public class SocketDemoGenerator {

    private static SocketDemoGenerator socketDemoGenerator;

    private SocketDemoGenerator(){};

    public static SocketDemoGenerator getSocketDemoGenerator() {
        if (socketDemoGenerator == null) {
            socketDemoGenerator = new SocketDemoGenerator();
        }
        return socketDemoGenerator;
    }

    public List<Socket> getDemoSockets() {
        List<Socket> socketList = new ArrayList<>();
        socketList.add(new SocketElect(1, "Wall mounted", 30, "no description", "Dedicated: general", "230 V", "16 A"));
        socketList.add(new SocketElect(2, "Wall mounted", 30, "SEP", "Dedicated: OR-Table", "230 V", "10 A"));
        socketList.add(new SocketTelTech(1, "Wall mounted", 30, "no description", "general dedicated", SocketTelTechEnum.LAN_RJ45));
        socketList.add(new SocketTelTech(2, "Wall mounted", 30, "no description", "general dedicated", SocketTelTechEnum.TELEPHONE_RJ11));
        return socketList;

    }

}
