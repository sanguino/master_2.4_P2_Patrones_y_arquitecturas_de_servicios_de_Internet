package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.dto.DeletedShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ValidationService validationService;
	private ApplicationEventPublisher applicationEventPublisher;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartServiceImpl(ValidationService validationService,
	        ApplicationEventPublisher applicationEventPublisher) {
		this.validationService = validationService;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public FullShoppingCartDTO createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		FullShoppingCartDTO createdFullShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		applicationEventPublisher.publishEvent(createdFullShoppingCartDTO);
		return createdFullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO updateShoppingCart(FullShoppingCartDTO currentShoppingCartDTO, ShoppingCartDTO updateShoppingCartDTO) {
		ShoppingCart currentShoppingCart = mapper.map(currentShoppingCartDTO, ShoppingCart.class);
		ShoppingCart updateShoppingCart = mapper.map(updateShoppingCartDTO, ShoppingCart.class);

		if (updateShoppingCart.getStatus() != null &&
				updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED &&
				currentShoppingCart.getStatus() != ShoppingCartStatus.COMPLETED) {
			currentShoppingCart.setValidationService(validationService);
			CompletedCart event =currentShoppingCart.validate();
			applicationEventPublisher.publishEvent(event);
		}

		FullShoppingCartDTO updatedFullCartDTO = mapper.map(currentShoppingCart, FullShoppingCartDTO.class);
		applicationEventPublisher.publishEvent(updatedFullCartDTO);
		return updatedFullCartDTO;
	}

	@Override
	public FullShoppingCartDTO deleteShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
		applicationEventPublisher.publishEvent(new DeletedShoppingCartDTO(fullShoppingCartDTO.getId()));
		return fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO addProduct(FullShoppingCartDTO fullShoppingCartDTO, FullProductDTO fullProductDTO, int quantity) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
		        mapper.map(fullProductDTO, Product.class),
		        quantity);
		shoppingCart.addItem(shoppingCartItem);

		FullShoppingCartDTO updatedFullCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		applicationEventPublisher.publishEvent(updatedFullCartDTO);

		return updatedFullCartDTO;
	}

	@Override
	public FullShoppingCartDTO deleteProduct(FullShoppingCartDTO fullShoppingCartDTO, FullProductDTO fullProductDTO) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());
		FullShoppingCartDTO updatedFullCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		applicationEventPublisher.publishEvent(updatedFullCartDTO);
		return updatedFullCartDTO;
	}
}
