package dat3.grocerydeliverysystem.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.grocerydeliverysystem.entity.ProductOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrderResponse {

  private int quantity;
  private Long deliveryId;
  private String productName;

  public ProductOrderResponse(ProductOrder productOrder) {
    this.quantity = productOrder.getQuantity();
    this.deliveryId = productOrder.getDelivery().getId();
    this.productName = productOrder.getProduct().getName();
  }
}
