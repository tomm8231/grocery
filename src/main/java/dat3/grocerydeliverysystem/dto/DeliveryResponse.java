package dat3.grocerydeliverysystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.grocerydeliverysystem.entity.Delivery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponse {

  private Long id; //primary key
  private LocalDate deliveryDate;
  private String fromWarehouse;
  private String destination;

  public DeliveryResponse(Delivery delivery) {
    this.id = delivery.getId();
    this.deliveryDate = delivery.getDeliveryDate();
    this.fromWarehouse = delivery.getFromWarehouse();
    this.destination = delivery.getDestination();
  }
}
