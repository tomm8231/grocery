package dat3.grocerydeliverysystem.config;

import dat3.grocerydeliverysystem.entity.Delivery;
import dat3.grocerydeliverysystem.entity.Product;
import dat3.grocerydeliverysystem.entity.ProductOrder;
import dat3.grocerydeliverysystem.repo.DeliveryRepo;
import dat3.grocerydeliverysystem.repo.ProductOrderRepo;
import dat3.grocerydeliverysystem.repo.ProductRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Configuration
public class DeveloperData implements ApplicationRunner {
  DeliveryRepo deliveryRepo;
  ProductOrderRepo productOrderRepo;
  ProductRepo productRepo;

  public DeveloperData(DeliveryRepo deliveryRepo, ProductOrderRepo productOrderRepo, ProductRepo productRepo){
    this.deliveryRepo = deliveryRepo;
    this.productOrderRepo = productOrderRepo;
    this.productRepo = productRepo;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

    Product prod1 = new Product("Tomato", 5.0, 30.0);
    Product prod2 = new Product("Cucumber", 10.0, 25.0);
    Product prod3 = new Product("Orange", 7.0, 50.0);
    productRepo.save(prod1);
    productRepo.save(prod2);
    productRepo.save(prod3);

    LocalDate deliveryDate1 = LocalDate.parse("2023-06-07");
    LocalDate deliveryDate2 = LocalDate.parse("2023-07-07");
    LocalDate deliveryDate3 = LocalDate.parse("2023-08-07");
    Delivery delivery1 = new Delivery(deliveryDate1, "Grindsted", "Varde");
    Delivery delivery2 = new Delivery(deliveryDate2, "Billund", "Vejle");
    Delivery delivery3 = new Delivery(deliveryDate3, "Ansager", "Skovlund");
    deliveryRepo.save(delivery1);
    deliveryRepo.save(delivery2);
    deliveryRepo.save(delivery3);

    ProductOrder productOrder1 = new ProductOrder(50,prod1,delivery1);
    ProductOrder productOrder2 = new ProductOrder(40,prod2,delivery1);
    ProductOrder productOrder3 = new ProductOrder(100,prod3,delivery3);
    productOrderRepo.save(productOrder1);
    productOrderRepo.save(productOrder2);
    productOrderRepo.save(productOrder3);


  }
}
