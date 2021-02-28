package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.Service.ProductService;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.event.CreateProductEvent;
import es.urjc.code.ejem1.event.DeleteProductEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandService {

  private ProductService productService;
  private ProductQueryService productQueryService;
  private ApplicationEventPublisher applicationEventPublisher;

  public ProductCommandService(ProductService productService, ProductQueryService productQueryService, ApplicationEventPublisher applicationEventPublisher) {
    this.productService = productService;
    this.productQueryService = productQueryService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public FullProductDTO createProduct(ProductDTO productDTO) {
    FullProductDTO fullProductDTO = productService.createProduct(productDTO);
    applicationEventPublisher.publishEvent(new CreateProductEvent(this, fullProductDTO));
    return fullProductDTO;
  }

  public FullProductDTO deleteProduct(String id) {
    FullProductDTO fullProductDTO = productQueryService.findById(id);
    applicationEventPublisher.publishEvent(new DeleteProductEvent(this, fullProductDTO));
    return fullProductDTO;
  }
}


