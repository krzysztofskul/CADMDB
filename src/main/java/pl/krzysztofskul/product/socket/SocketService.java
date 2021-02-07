package pl.krzysztofskul.product.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SocketService {

    private SocketRepo socketRepo;

    @Autowired
    public SocketService(SocketRepo socketRepo) {
        this.socketRepo = socketRepo;
    }

    public void save(Socket socket) {
        socketRepo.save(socket);
    }

    public List<Socket> loadAll() {
        return socketRepo.findAll();
    }

    public Socket loadById(Long id) {
        return socketRepo.findById(id).get();
    }

}
