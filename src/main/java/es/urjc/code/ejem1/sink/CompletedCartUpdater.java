package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.CompletedCart;
import es.urjc.code.ejem1.domain.CompletedCartDTO;
import es.urjc.code.ejem1.domain.CompletedCartRepository;
import es.urjc.code.ejem1.domain.FullShoppingCartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CompletedCartUpdater {

	private CompletedCartRepository completedCartRepository;

	private ModelMapper mapper = new ModelMapper();

	public CompletedCartUpdater(CompletedCartRepository completedCartRepository) {
		this.completedCartRepository = completedCartRepository;
	}

	@EventListener
	public void saveCompletedCart(FullShoppingCartDTO shoppingCartDTO) {
		CompletedCart completedCart = new CompletedCart(shoppingCartDTO.getId(), shoppingCartDTO.getPrice());
		completedCartRepository.save(mapper.map(completedCart, CompletedCartDTO.class));
	}
}
