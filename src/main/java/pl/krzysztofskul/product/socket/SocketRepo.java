package pl.krzysztofskul.product.socket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketRepo extends JpaRepository<Socket, Long> {
}
