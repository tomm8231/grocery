package dat3.grocerydeliverysystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.grocerydeliverysystem.entity.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequest {

  private Long id;
  private String name;
  private Double price;
  private Double weight;

  public static Product getProductEntity(ProductRequest p) {
    return new Product(p.getName(),p.getPrice(),p.getWeight());
  }

  public ProductRequest(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.price = product.getPrice();
    this.weight = product.getWeight();
  }
}
