package es.urjc.code.ejem1.event;

import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import org.springframework.context.ApplicationEvent;

public class UpdateShoppingCartEvent extends ApplicationEvent {

  FullShoppingCartDTO fullShoppingCartDTO;

  public UpdateShoppingCartEvent(Object source, FullShoppingCartDTO fullShoppingCartDTO) {
    super(source);
    this.fullShoppingCartDTO = fullShoppingCartDTO;
  }

  public FullShoppingCartDTO getFullShoppingCartDTO() {
    return fullShoppingCartDTO;
  }

}
