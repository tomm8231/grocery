package dat3.grocerydeliverysystem.repo;

import dat3.grocerydeliverysystem.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery,Long> {
}
