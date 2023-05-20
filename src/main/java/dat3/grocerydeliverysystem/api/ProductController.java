package dat3.grocerydeliverysystem.api;

import dat3.grocerydeliverysystem.dto.ProductRequest;
import dat3.grocerydeliverysystem.dto.ProductResponse;
import dat3.grocerydeliverysystem.entity.Product;
import dat3.grocerydeliverysystem.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/products")
public class ProductController {

  ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

    @GetMapping()
    public List<ProductResponse> getAllProducts() {
      return productService.getAllProducts();
    }

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest body) {
      return productService.addProduct(body);
    }

    @GetMapping("/{productName}")
    public ProductResponse findProductByName(@PathVariable String productName) {
      return productService.findProductByName(productName);
    }

    @PutMapping()
    public ResponseEntity<Boolean> editProduct(@RequestBody ProductRequest body) {
      return productService.editProduct(body);
    }

  }

