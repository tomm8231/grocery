package dat3.grocerydeliverysystem.entity;

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

  @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
  List<ProductOrder> productOrders = new ArrayList<>();

  public Delivery(LocalDate deliveryDate, String fromWarehouse, String destination) {
    this.deliveryDate = deliveryDate;
    this.fromWarehouse = fromWarehouse;
    this.destination = destination;
  }

}
