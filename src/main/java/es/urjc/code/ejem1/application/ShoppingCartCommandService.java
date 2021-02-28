package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.Service.ShoppingCartService;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.event.CreateShoppingCartEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartCommandService {

  private ShoppingCartService shoppingCartService;
  private ShoppingCartQueryService shoppingCartQueryService;
  private ApplicationEventPublisher applicationEventPublisher;

  public ShoppingCartCommandService(ShoppingCartService shoppingCartService, ShoppingCartQueryService shoppingCartQueryService, ApplicationEventPublisher applicationEventPublisher) {
    this.shoppingCartService = shoppingCartService;
    this.shoppingCartQueryService = shoppingCartQueryService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public FullShoppingCartDTO createShoppingCart() {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartService.createShoppingCart();
    applicationEventPublisher.publishEvent(new CreateShoppingCartEvent(this, fullShoppingCartDTO));
    return fullShoppingCartDTO;
  }

}


