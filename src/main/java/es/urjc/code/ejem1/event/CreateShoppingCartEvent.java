package es.urjc.code.ejem1.event;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import org.springframework.context.ApplicationEvent;

public class CreateShoppingCartEvent extends ApplicationEvent {

  FullShoppingCartDTO fullShoppingCartDTO;

  public CreateShoppingCartEvent(Object source, FullShoppingCartDTO fullShoppingCartDTO) {
    super(source);
    this.fullShoppingCartDTO = fullShoppingCartDTO;
  }

  public FullShoppingCartDTO getFullShoppingCartDTO() {
    return fullShoppingCartDTO;
  }

}
