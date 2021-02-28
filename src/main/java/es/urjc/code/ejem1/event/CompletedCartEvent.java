package es.urjc.code.ejem1.event;

import es.urjc.code.ejem1.domain.model.CompletedCart;
import org.springframework.context.ApplicationEvent;

public class CompletedCartEvent extends ApplicationEvent {

  CompletedCart completedCart;

  public CompletedCartEvent(Object source, CompletedCart completedCart) {
    super(source);
    this.completedCart = completedCart;
  }

  public CompletedCart getCompletedCart() {
    return completedCart;
  }

}
