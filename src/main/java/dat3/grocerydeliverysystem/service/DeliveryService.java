package dat3.grocerydeliverysystem.service;

import dat3.grocerydeliverysystem.dto.DeliveryRequest;
import dat3.grocerydeliverysystem.dto.DeliveryResponse;
import dat3.grocerydeliverysystem.entity.Delivery;
import dat3.grocerydeliverysystem.entity.ProductOrder;
import dat3.grocerydeliverysystem.repo.DeliveryRepo;
import dat3.grocerydeliverysystem.repo.ProductOrderRepo;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeliveryService {
  private final DeliveryRepo deliveryRepo;
  private final ProductOrderRepo productOrderRepo;

  public DeliveryService(DeliveryRepo deliveryRepo,
                         ProductOrderRepo productOrderRepo) {
    this.deliveryRepo = deliveryRepo;
    this.productOrderRepo = productOrderRepo;
  }

  public DeliveryResponse addDelivery(DeliveryRequest body) {

    if(deliveryRepo.existsById(body.getId())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delivery med ID #" + body.getId() + " findes allerede");
    }

    Delivery newDelivery = DeliveryRequest.getDeliveryEntity(body);
    deliveryRepo.save(newDelivery);
    return new DeliveryResponse(newDelivery);
  }

  public ResponseEntity<Boolean> assignProductOrdersToDelivery(Long deliveryId, List<Long> productOrderIds) {
    Delivery delivery = deliveryRepo.findById(deliveryId).orElseThrow(()
        ->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delivery was not found"));

    List<ProductOrder> assignedProductOrders = productOrderRepo.findAllById(productOrderIds);

    delivery.setProductOrders(assignedProductOrders);
    deliveryRepo.save(delivery);


    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  public List<DeliveryResponse> getDeliveries() {
    List<Delivery> deliveries = deliveryRepo.findAll();

    return deliveries.stream().map(delivery -> new DeliveryResponse(delivery)).toList();
  }
}
