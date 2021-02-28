package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import es.urjc.code.ejem1.event.CreateShoppingCartEvent;
import es.urjc.code.ejem1.event.DeleteShoppingCartEvent;
import es.urjc.code.ejem1.event.UpdateShoppingCartEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartUpdater {

	private ShoppingCartRepository repository;

	public ShoppingCartUpdater(ShoppingCartRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void saveShoppingCart(CreateShoppingCartEvent event) {
		repository.save(event.getFullShoppingCartDTO());
	}

	@EventListener
	public void updateShoppingCart(UpdateShoppingCartEvent event) {
		FullShoppingCartDTO fullShoppingCartDTO = event.getFullShoppingCartDTO();
		repository.save(fullShoppingCartDTO);
	}

	@EventListener
	public void deleteShoppingCart(DeleteShoppingCartEvent event) {
		FullShoppingCartDTO fullShoppingCartDTO = event.getFullShoppingCartDTO();
		repository.deleteById(fullShoppingCartDTO.getId());
	}

}
