package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.model.*;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartRepository shoppingCartRepository;
	private ProductRepository productRepository;
	private ValidationService validationService;
	private ApplicationEventPublisher applicationEventPublisher;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
	        ProductRepository productRepository,
	        ValidationService validationService,
	        ApplicationEventPublisher applicationEventPublisher) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.validationService = validationService;
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	private FullShoppingCartDTO saveShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
		FullShoppingCartDTO saveFullShoppingCartDTO = shoppingCartRepository.save(fullShoppingCartDTO);

		return (saveFullShoppingCartDTO != null) ? saveFullShoppingCartDTO : fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO getShoppingCart(Long id) {
		return mapper.map(shoppingCartRepository.findById(id), FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		FullShoppingCartDTO fullShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		
		return saveShoppingCart(fullShoppingCartDTO);
	}

	@Override
	public FullShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		ShoppingCart updateShoppingCart = mapper.map(shoppingCartDTO, ShoppingCart.class);

		if (updateShoppingCart.getStatus() != null &&
		        updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED) {
			shoppingCart.setValidationService(validationService);
			CompletedCart event = shoppingCart.validate();
			applicationEventPublisher.publishEvent(event);
		}

		FullShoppingCartDTO newShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		
		return saveShoppingCart(newShoppingCartDTO);
	}

	@Override
	public FullShoppingCartDTO deleteShoppingCart(Long id) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);
		shoppingCartRepository.deleteById(id);

		return fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO addProduct(Long idShoppingCart, Long idProduct, int quantity) {
		FullProductDTO fullProductDTO = productRepository.findById(idProduct);
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		return addProduct(fullProductDTO, fullShoppingCartDTO, quantity);
	}

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
		        mapper.map(fullProductDTO, Product.class),
		        quantity);
		shoppingCart.addItem(shoppingCartItem);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}

	@Override
	public FullShoppingCartDTO deleteProduct(Long idShoppingCart, Long idProduct) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(idProduct);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}
}
