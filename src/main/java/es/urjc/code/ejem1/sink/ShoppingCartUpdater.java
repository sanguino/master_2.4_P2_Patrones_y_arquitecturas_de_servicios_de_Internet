package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import es.urjc.code.ejem1.event.CreateShoppingCartEvent;
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

}
