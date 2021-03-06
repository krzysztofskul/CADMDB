package pl.krzysztofskul.product.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class SocketController {

    private SocketService socketService;

    @Autowired
    public SocketController(SocketService socketService) {
        this.socketService = socketService;
    }


    @GetMapping
    @RequestMapping("/sockets-demo-init")
    public String socketsDemoInit() {
        for (Socket socket : SocketDemoGenerator.getSocketDemoGenerator().getDemoSockets()) {
            socketService.save(socket);
        }
        return "redirect:/";
    }

    @GetMapping("/sockets")
    @ResponseBody
    public List<Socket> sockets() {
        return socketService.loadAll();
    }

    @GetMapping
    @RequestMapping(value = "/socket/{id}", produces = "application/json")
    @ResponseBody
    public Socket getSockets(
            @PathVariable Long id
    ) {
        return socketService.loadById(id);
    }

}