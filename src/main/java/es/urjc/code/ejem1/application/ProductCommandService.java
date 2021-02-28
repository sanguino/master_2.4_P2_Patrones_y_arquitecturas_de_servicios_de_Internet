package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandService {

  private ProductService productService;
  private ProductQueryService productQueryService;

  public ProductCommandService(ProductService productService, ProductQueryService productQueryService) {
    this.productService = productService;
    this.productQueryService = productQueryService;
  }

  public FullProductDTO createProduct(ProductDTO productDTO) {
    return productService.createProduct(productDTO);
  }

  public FullProductDTO deleteProduct(String id) {
    FullProductDTO fullProductDTO = productQueryService.findById(id);
    return productService.deleteProduct(fullProductDTO);
  }
}
