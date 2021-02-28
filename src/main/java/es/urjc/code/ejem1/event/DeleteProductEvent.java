package es.urjc.code.ejem1.event;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import org.springframework.context.ApplicationEvent;

public class DeleteProductEvent extends ApplicationEvent {

  FullProductDTO fullProductDTO;

  public DeleteProductEvent(Object source, FullProductDTO fullProductDTO) {
    super(source);
    this.fullProductDTO = fullProductDTO;
  }

  public FullProductDTO getFullProductDTO() {
    return fullProductDTO;
  }

}
