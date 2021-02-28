package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import es.urjc.code.ejem1.event.SaveShoppingCartEvent;
import es.urjc.code.ejem1.event.DeleteShoppingCartEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartUpdater {

	private ShoppingCartRepository repository;

	public ShoppingCartUpdater(ShoppingCartRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void saveShoppingCart(SaveShoppingCartEvent event) {
		repository.save(event.getFullShoppingCartDTO());
	}

	@EventListener
	public void deleteShoppingCart(DeleteShoppingCartEvent event) {
		FullShoppingCartDTO fullShoppingCartDTO = event.getFullShoppingCartDTO();
		repository.deleteById(fullShoppingCartDTO.getId());
	}

}
