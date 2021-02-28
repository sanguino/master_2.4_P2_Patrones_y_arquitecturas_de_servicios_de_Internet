package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartCommandService {

  private ShoppingCartService shoppingCartService;
  private ShoppingCartQueryService shoppingCartQueryService;
  private ProductQueryService productQueryService;

  public ShoppingCartCommandService(
      ShoppingCartService shoppingCartService,
      ShoppingCartQueryService shoppingCartQueryService,
      ProductQueryService productQueryService
  ) {
    this.shoppingCartService = shoppingCartService;
    this.shoppingCartQueryService = shoppingCartQueryService;
    this.productQueryService = productQueryService;
  }

  public FullShoppingCartDTO createShoppingCart() {
    return shoppingCartService.createShoppingCart();
  }

  public FullShoppingCartDTO updateShoppingCart(String id, ShoppingCartDTO shoppingCartDTO) {
    FullShoppingCartDTO currentFullShoppingCartDTO = shoppingCartQueryService.findById(id);
    return shoppingCartService.updateShoppingCart(currentFullShoppingCartDTO, shoppingCartDTO);

  }

  public FullShoppingCartDTO deleteShoppingCart(String id) {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(id);
      return shoppingCartService.deleteShoppingCart(fullShoppingCartDTO);
    }

  public FullShoppingCartDTO addProduct(String idShoppingCart, String idProduct, int quantity) {
    FullProductDTO fullProductDTO = productQueryService.findById(idProduct);
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(idShoppingCart);
    return shoppingCartService.addProduct(fullShoppingCartDTO, fullProductDTO, quantity);
  }

  public FullShoppingCartDTO deleteProduct(String idShoppingCart, String idProduct) {
    FullProductDTO fullProductDTO = productQueryService.findById(idProduct);
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(idShoppingCart);
    return shoppingCartService.deleteProduct(fullShoppingCartDTO, fullProductDTO);
  }
}


