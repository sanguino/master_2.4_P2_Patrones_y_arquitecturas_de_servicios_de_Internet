package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.dto.CompletedCartDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.model.CompletedCart;
import es.urjc.code.ejem1.domain.repository.CompletedCartRepository;
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
