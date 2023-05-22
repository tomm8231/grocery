package dat3.grocerydeliverysystem.api;

import dat3.grocerydeliverysystem.dto.DeliveryRequest;
import dat3.grocerydeliverysystem.dto.DeliveryResponse;
import dat3.grocerydeliverysystem.entity.Delivery;
import dat3.grocerydeliverysystem.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/deliveries")
public class DeliveryController {

  private DeliveryService deliveryService;

  public DeliveryController(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
  }

  @GetMapping()
  public List<DeliveryResponse> getDeliveries() {
    return deliveryService.getDeliveries();
  }


  @PostMapping()
  public DeliveryResponse addDelivery(@RequestBody DeliveryRequest body) {
    return deliveryService.addDelivery(body);
  }

  @PostMapping("{deliveryId}/assign-product-orders")
  public ResponseEntity<Boolean> assignProductOrdersToDelivery(
      @PathVariable Long deliveryId,
      @RequestBody List<Long> productOrderIds) {
    return deliveryService.assignProductOrdersToDelivery(deliveryId, productOrderIds);
  }

}
