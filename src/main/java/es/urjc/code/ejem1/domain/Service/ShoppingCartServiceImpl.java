package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartItemDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.model.*;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import es.urjc.code.ejem1.event.CompletedCartEvent;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;

import java.util.UUID;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartRepository shoppingCartRepository;
	private ValidationService validationService;
	private ApplicationEventPublisher applicationEventPublisher;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
	        ValidationService validationService,
	        ApplicationEventPublisher applicationEventPublisher) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.validationService = validationService;
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	private FullShoppingCartDTO saveShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
		FullShoppingCartDTO saveFullShoppingCartDTO = shoppingCartRepository.save(fullShoppingCartDTO);

		return (saveFullShoppingCartDTO != null) ? saveFullShoppingCartDTO : fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		return mapper.map(shoppingCart, FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO updateShoppingCart(FullShoppingCartDTO currentShoppingCartDTO, ShoppingCartDTO updateShoppingCartDTO) {
		ShoppingCart currentShoppingCart = mapper.map(currentShoppingCartDTO, ShoppingCart.class);
		ShoppingCart updateShoppingCart = mapper.map(updateShoppingCartDTO, ShoppingCart.class);

		if (updateShoppingCart.getStatus() != null &&
				updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED &&
				currentShoppingCart.getStatus() != ShoppingCartStatus.COMPLETED) {
			currentShoppingCart.setValidationService(validationService);
			CompletedCartEvent event = new CompletedCartEvent(this, currentShoppingCart.validate());
			applicationEventPublisher.publishEvent(event);
		}

		return mapper.map(currentShoppingCart, FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO addProduct(FullShoppingCartDTO fullShoppingCartDTO, FullProductDTO fullProductDTO, int quantity) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
		        mapper.map(fullProductDTO, Product.class),
		        quantity);
		shoppingCart.addItem(shoppingCartItem);

		return mapper.map(shoppingCart, FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO deleteProduct(FullShoppingCartDTO fullShoppingCartDTO, FullProductDTO fullProductDTO) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());
		return mapper.map(shoppingCart, FullShoppingCartDTO.class);
	}
}
