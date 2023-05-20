package dat3.grocerydeliverysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_orders")
public class ProductOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int quantity;

  @ManyToOne
  @JoinColumn(name = "delivery_id")
  private Delivery delivery;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public ProductOrder(int quantity, Product product, Delivery delivery) {
    this.quantity = quantity;
    this.product = product;
    this.delivery = delivery;
  }
}
