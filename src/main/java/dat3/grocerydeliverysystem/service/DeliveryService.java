package dat3.grocerydeliverysystem.service;

import dat3.grocerydeliverysystem.dto.DeliveryRequest;
import dat3.grocerydeliverysystem.dto.DeliveryResponse;
import dat3.grocerydeliverysystem.entity.Delivery;
import dat3.grocerydeliverysystem.repo.DeliveryRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeliveryService {
  private final DeliveryRepo deliveryRepo;

  public DeliveryService(DeliveryRepo deliveryRepo) {
    this.deliveryRepo = deliveryRepo;
  }

  public DeliveryResponse addDelivery(DeliveryRequest body) {

    if(deliveryRepo.existsById(body.getId())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delivery med ID #" + body.getId() + " findes allerede");
    }

    Delivery newDelivery = DeliveryRequest.getDeliveryEntity(body);
    deliveryRepo.save(newDelivery);
    return new DeliveryResponse(newDelivery);
  }
}
