package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShoppingCartQueryService {

  private ShoppingCartRepository shoppingCartRepository;

  public ShoppingCartQueryService(ShoppingCartRepository shoppingCartRepository) {
    this.shoppingCartRepository = shoppingCartRepository;
  }

  public FullShoppingCartDTO findById(String id) {
    return shoppingCartRepository.findById(UUID.fromString(id));
  }
}


