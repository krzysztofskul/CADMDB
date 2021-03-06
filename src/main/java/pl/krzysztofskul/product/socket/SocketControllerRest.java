package pl.krzysztofskul.product.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SocketControllerRest {

    private SocketService socketService;

    @Autowired
    public SocketControllerRest(SocketService socketService) {
        this.socketService = socketService;
    }

    @GetMapping
    @RequestMapping("/sockets-demo-test")
    public List<Socket> socketsDemoTest() {
        return SocketDemoGenerator.getSocketDemoGenerator().getDemoSockets();
    }

    @GetMapping
    @RequestMapping("/sockets-demo-init")
    public String socketsDemoInit() {
        for (Socket socket : SocketDemoGenerator.getSocketDemoGenerator().getDemoSockets()) {
            socketService.save(socket);
        }
        return "Sockets demo initialization to DB finished!";
    }

    @GetMapping
    @RequestMapping(value = "/sockets", produces = "application/json")
    public List<Socket> getSockets() {
        return socketService.loadAll();
    }

    @GetMapping
    @RequestMapping(value = "/socket/{id}", produces = "application/json")
    public Socket getSockets(
            @PathVariable Long id
    ) {
        return socketService.loadById(id);
    }

}