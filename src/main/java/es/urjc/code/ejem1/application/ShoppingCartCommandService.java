package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.Service.ShoppingCartService;
import es.urjc.code.ejem1.domain.dto.DeletedShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartCommandService {

  private ShoppingCartService shoppingCartService;
  private ShoppingCartQueryService shoppingCartQueryService;
  private ProductQueryService productQueryService;
  private ApplicationEventPublisher applicationEventPublisher;

  public ShoppingCartCommandService(
      ShoppingCartService shoppingCartService,
      ShoppingCartQueryService shoppingCartQueryService,
      ProductQueryService productQueryService,
      ApplicationEventPublisher applicationEventPublisher
  ) {
    this.shoppingCartService = shoppingCartService;
    this.shoppingCartQueryService = shoppingCartQueryService;
    this.productQueryService = productQueryService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public FullShoppingCartDTO createShoppingCart() {
    FullShoppingCartDTO createdFullShoppingCartDTO = shoppingCartService.createShoppingCart();
    applicationEventPublisher.publishEvent(createdFullShoppingCartDTO);
    return createdFullShoppingCartDTO;
  }

  public FullShoppingCartDTO updateShoppingCart(String id, ShoppingCartDTO shoppingCartDTO) {
    FullShoppingCartDTO currentFullShoppingCartDTO = shoppingCartQueryService.findById(id);
    FullShoppingCartDTO updatedFullCartDTO = shoppingCartService.updateShoppingCart(currentFullShoppingCartDTO, shoppingCartDTO);
    applicationEventPublisher.publishEvent(updatedFullCartDTO);
    return updatedFullCartDTO;

  }

  public FullShoppingCartDTO deleteShoppingCart(String id) {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(id);
      applicationEventPublisher.publishEvent(new DeletedShoppingCartDTO(fullShoppingCartDTO.getId()));
      return fullShoppingCartDTO;
    }

  public FullShoppingCartDTO addProduct(String idShoppingCart, String idProduct, int quantity) {
    FullProductDTO fullProductDTO = productQueryService.findById(idProduct);
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(idShoppingCart);

    FullShoppingCartDTO updatedFullCartDTO = shoppingCartService.addProduct(fullShoppingCartDTO, fullProductDTO, quantity);
    applicationEventPublisher.publishEvent(updatedFullCartDTO);
    return updatedFullCartDTO;
  }

  public FullShoppingCartDTO deleteProduct(String idShoppingCart, String idProduct) {
    FullProductDTO fullProductDTO = productQueryService.findById(idProduct);
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(idShoppingCart);

    FullShoppingCartDTO updatedFullCartDTO = shoppingCartService.deleteProduct(fullShoppingCartDTO, fullProductDTO);
    applicationEventPublisher.publishEvent(updatedFullCartDTO);
    return updatedFullCartDTO;
  }
}


