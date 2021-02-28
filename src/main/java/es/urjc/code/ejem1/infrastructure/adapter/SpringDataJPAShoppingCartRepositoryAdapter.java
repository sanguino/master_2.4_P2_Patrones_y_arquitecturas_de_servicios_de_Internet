package es.urjc.code.ejem1.infrastructure.adapter;

import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import es.urjc.code.ejem1.infrastructure.entity.ShoppingCartEntity;
import es.urjc.code.ejem1.infrastructure.exception.ShoppingCartNotFoundException;
import es.urjc.code.ejem1.infrastructure.repository.SpringDataJPAShoppingCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJPAShoppingCartRepositoryAdapter implements ShoppingCartRepository {

	private SpringDataJPAShoppingCartRepository repository;
	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPAShoppingCartRepositoryAdapter(SpringDataJPAShoppingCartRepository repository) {
		this.repository = repository;
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

		return findById(shoppingCartEntity.getId());
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
