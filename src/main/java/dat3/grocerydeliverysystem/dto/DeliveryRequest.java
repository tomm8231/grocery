package dat3.grocerydeliverysystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.grocerydeliverysystem.entity.Delivery;
import dat3.grocerydeliverysystem.entity.ProductOrder;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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

  private List<ProductOrder> productOrders; //Skal det være en liste af ProductOrderRequest?

  public static Delivery getDeliveryEntity(DeliveryRequest d) {
    return new Delivery(d.getDeliveryDate(),d.getFromWarehouse(),d.getDestination());
  }

  public DeliveryRequest(Delivery delivery) {
    this.id = delivery.getId();
    this.deliveryDate = delivery.getDeliveryDate();
    this.fromWarehouse = delivery.getFromWarehouse();
    this.destination = delivery.getDestination();
    this.productOrders = delivery.getProductOrders();
  }
}
