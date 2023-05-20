package dat3.grocerydeliverysystem.service;

import dat3.grocerydeliverysystem.dto.ProductOrderResponse;
import dat3.grocerydeliverysystem.entity.ProductOrder;
import dat3.grocerydeliverysystem.repo.ProductOrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

  ProductOrderRepo productOrderRepo;

  public ProductOrderService(ProductOrderRepo productOrderRepo) {
    this.productOrderRepo = productOrderRepo;
  }
  public List<ProductOrderResponse> getAllProductOrders() {
    List<ProductOrder> productOrders = productOrderRepo.findAll();
    return productOrders.stream().map(productOrder -> new ProductOrderResponse(productOrder)).toList();
  }


}
