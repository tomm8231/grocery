package dat3.grocerydeliverysystem.api;

import dat3.grocerydeliverysystem.dto.DeliveryRequest;
import dat3.grocerydeliverysystem.dto.DeliveryResponse;
import dat3.grocerydeliverysystem.entity.Delivery;
import dat3.grocerydeliverysystem.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/deliveries")
public class DeliveryController {

  private DeliveryService deliveryService;

  public DeliveryController(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
  }


  @PostMapping()
  public DeliveryResponse addDelivery(@RequestBody DeliveryRequest body) {
    return deliveryService.addDelivery(body);
  }

}
