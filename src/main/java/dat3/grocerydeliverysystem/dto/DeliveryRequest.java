package dat3.grocerydeliverysystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.grocerydeliverysystem.entity.Delivery;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryRequest {
  private Long id;
  private LocalDate deliveryDate;
  private String fromWarehouse;
  private String destination;

  public static Delivery getDeliveryEntity(DeliveryRequest d) {
    return new Delivery(d.getDeliveryDate(),d.getFromWarehouse(),d.getDestination());
  }

  public DeliveryRequest(Delivery delivery) {
    this.id = delivery.getId();
    this.deliveryDate = delivery.getDeliveryDate();
    this.fromWarehouse = delivery.getFromWarehouse();
    this.destination = delivery.getDestination();
  }
}
