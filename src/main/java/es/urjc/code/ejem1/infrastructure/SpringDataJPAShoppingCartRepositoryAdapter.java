package es.urjc.code.ejem1.infrastructure;

import es.urjc.code.ejem1.domain.ShoppingCartStatus;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import es.urjc.code.ejem1.domain.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartRepository;

@Component
public class SpringDataJPAShoppingCartRepositoryAdapter implements ShoppingCartRepository {

	private SpringDataJPAShoppingCartRepository repository;
	private ModelMapper mapper = new ModelMapper();
	private final ApplicationEventPublisher applicationEventPublisher;

	public SpringDataJPAShoppingCartRepositoryAdapter(SpringDataJPAShoppingCartRepository repository, ApplicationEventPublisher applicationEventPublisher) {
		this.repository = repository;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public FullShoppingCartDTO findById(Long id) {
		return mapper.map(repository.findById(id).orElseThrow(ShoppingCartNotFoundException::new),
		        FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart) {
		ShoppingCartEntity shoppingCartEntity = mapper.map(shoppingCart, ShoppingCartEntity.class);
		repository.save(shoppingCartEntity);

		if (shoppingCart.getStatus() == ShoppingCartStatus.COMPLETED) {
			applicationEventPublisher.publishEvent(shoppingCart);
		}

		return findById(shoppingCartEntity.getId());
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
