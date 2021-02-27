package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.ExpeditedCart;
import es.urjc.code.ejem1.domain.ExpeditedCartDTO;
import es.urjc.code.ejem1.domain.ExpeditedCartRepository;
import es.urjc.code.ejem1.domain.FullShoppingCartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CompletedCartUpdater {

	private ExpeditedCartRepository expeditedCartRepository;

	private ModelMapper mapper = new ModelMapper();

	public CompletedCartUpdater(ExpeditedCartRepository expeditedCartRepository) {
		this.expeditedCartRepository = expeditedCartRepository;
	}

	@EventListener
	public void saveExpeditedCart(FullShoppingCartDTO shoppingCartDTO) {
		ExpeditedCart expeditedCart = new ExpeditedCart(shoppingCartDTO.getId(), shoppingCartDTO.getPrice());
		expeditedCartRepository.save(mapper.map(expeditedCart, ExpeditedCartDTO.class));
	}
}
