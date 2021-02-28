package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.dto.DeletedShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartUpdater {

	private ShoppingCartRepository repository;

	public ShoppingCartUpdater(ShoppingCartRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void saveShoppingCart(FullShoppingCartDTO createdCart) {
		repository.save(createdCart);
	}

	@EventListener
	public void deleteShoppingCart(DeletedShoppingCartDTO deletedCart) {
		repository.deleteById(deletedCart.getId());
	}

}
