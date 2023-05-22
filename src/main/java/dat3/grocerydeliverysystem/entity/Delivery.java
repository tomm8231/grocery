package dat3.grocerydeliverysystem.entity;

import dat3.grocerydeliverysystem.dto.ProductOrderRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "deliveries")
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate deliveryDate;
  private String fromWarehouse;
  private String destination;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProductOrder> productOrders = new ArrayList<>();

  public Delivery(LocalDate deliveryDate, String fromWarehouse, String destination) {
    this.deliveryDate = deliveryDate;
    this.fromWarehouse = fromWarehouse;
    this.destination = destination;
  }


  public void addProductOrder(ProductOrder po) {
    productOrders.add(po);
    po.setDelivery(this);

  }


}
