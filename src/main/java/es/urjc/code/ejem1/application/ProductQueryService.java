package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class ProductQueryService {

  private ProductRepository productRepository;

  public ProductQueryService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Collection<FullProductDTO> findAll() {
    return productRepository.finAll();
  }

  public FullProductDTO findById(String id) {
    return productRepository.findById(UUID.fromString(id));
  }
}


