package dat3.grocerydeliverysystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.grocerydeliverysystem.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
  private String name;
  private Double price;
  private Double weight;

  public ProductResponse(Product product) {
    this.name = product.getName();
    this.price = product.getPrice();
    this.weight = product.getWeight();
  }
}
