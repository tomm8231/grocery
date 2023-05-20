package dat3.grocerydeliverysystem.service;

import dat3.grocerydeliverysystem.dto.ProductRequest;
import dat3.grocerydeliverysystem.dto.ProductResponse;
import dat3.grocerydeliverysystem.entity.Product;
import dat3.grocerydeliverysystem.repo.ProductRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

  ProductRepo productRepo;

  public ProductService(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }
  public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepo.findAll();
    return products.stream().map(product -> new ProductResponse(product)).toList();
  }

  public ProductResponse addProduct(ProductRequest body) {
    if(productRepo.existsById(body.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Varen findes allerede");
    }

    Product newProduct = ProductRequest.getProductEntity(body);
    productRepo.save(newProduct);
    return new ProductResponse(newProduct);
  }

  public ProductResponse findProductByName(String productName) {
    Product product = productRepo.findById(productName).orElseThrow(()
        -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Varen findes ikke"));
    return new ProductResponse(product);
  }
}
