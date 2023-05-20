package dat3.grocerydeliverysystem.api;

import dat3.grocerydeliverysystem.dto.ProductOrderResponse;
import dat3.grocerydeliverysystem.service.ProductOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product-orders")
@CrossOrigin
public class ProductOrderController {

  ProductOrderService productOrderService;

  public ProductOrderController(ProductOrderService productOrderService) {
    this.productOrderService = productOrderService;
  }

  @GetMapping()
  public List<ProductOrderResponse> getAllProductOrders() {
    return productOrderService.getAllProductOrders();
  }


}
