package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.ProductService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class ProductManager {

    private ProductService productService;
    private RoomService roomService;
    private DepartmentService departmentService;
    private HospitalService hospitalService;

    @Autowired
    public ProductManager(ProductService productService, RoomService roomService, DepartmentService departmentService, HospitalService hospitalService) {
        this.productService = productService;
        this.roomService = roomService;
        this.departmentService = departmentService;
        this.hospitalService = hospitalService;
    }

    public void addProductToRoom(Long productId, Long roomId) {
        Product product = productService.loadByIdWithRoomList(productId);
        Room room = roomService.loadByIdWithProducts(roomId);
        List<Product> productList = room.getProductList();
        productList.add(product);
        room.setProductList(productList);
        recalculateCostsInRoom(room);
    };

    public void removeProductFromRoom(Long productId, Long roomId) {

    };

    public void recalculateCostsInRoom(Room room) {
        BigDecimal costOfProducts = room.getCostOfProductsActual();
        for (Product product : room.getProductList()) {
            costOfProducts = costOfProducts.add(product.getPrice());
        }
        room.setCostOfProductsActual(costOfProducts);
        roomService.save(room);
    }

    public void recalculateCostsInDepartment() {

    }

    public void recalculateCostsInHospital() {

    }



}
