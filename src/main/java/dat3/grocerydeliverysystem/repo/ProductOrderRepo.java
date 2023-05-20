package dat3.grocerydeliverysystem.repo;

import dat3.grocerydeliverysystem.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepo extends JpaRepository<ProductOrder, Long> {
}
