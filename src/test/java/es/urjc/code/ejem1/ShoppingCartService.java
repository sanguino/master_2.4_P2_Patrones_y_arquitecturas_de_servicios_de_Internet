package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.dto.DeletedShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartItemDTO;
import es.urjc.code.ejem1.domain.model.Product;
import es.urjc.code.ejem1.domain.service.ShoppingCartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

@TestMethodOrder(OrderAnnotation.class)
public class ShoppingCartService {

	@InjectMocks
	private ShoppingCartServiceImpl shoppingCartService;

	@Mock
	private ApplicationEventPublisher applicationEventPublisher;

	@Captor
	ArgumentCaptor<DeletedShoppingCartDTO> argumentDeletedShoppingCartDTO;

	private ModelMapper mapper = new ModelMapper();
	
	private static FullShoppingCartDTO createdShoppingCart;
	
	@BeforeEach
	void setUp() {
		openMocks(this);
	}
	
	@Test
	@Order(1)
	void shoppingCartCanBeAdded() {
		createdShoppingCart = shoppingCartService.createShoppingCart();
		verify(applicationEventPublisher).publishEvent(createdShoppingCart);
	}
	
	@Test
	@Order(2)
	void productCanBeAddedToShoppingCart() {
		Product product = new Product(
		        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
		        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
		        49.99);
		product.setId(UUID.randomUUID());
		FullProductDTO fullProductDTO = mapper.map(product, FullProductDTO.class);

		//when(this.productQueryService.findById(any(String.class))).thenReturn(fullProductDTO);

		int items = Math.abs(new Random().nextInt());

		createdShoppingCart = shoppingCartService.addProduct(createdShoppingCart, fullProductDTO, items);
		verify(applicationEventPublisher).publishEvent(any(FullShoppingCartDTO.class));
		FullShoppingCartItemDTO fullShoppingCartItemDTO = createdShoppingCart.getItems().get(0);
		assertEquals(fullShoppingCartItemDTO.getQuantity(), items);
		assertEquals(fullShoppingCartItemDTO.getTotalPrice(), items * fullProductDTO.getPrice());
	}
	
	@Test
	@Order(3)
	void shoppingCartCanBeDeleted() {
		shoppingCartService.deleteShoppingCart(createdShoppingCart);
		verify(applicationEventPublisher).publishEvent(this.argumentDeletedShoppingCartDTO.capture());
		DeletedShoppingCartDTO deletedShoppingCartDTO = this.argumentDeletedShoppingCartDTO.getValue();
		assertEquals(deletedShoppingCartDTO.getId(), createdShoppingCart.getId());
	}
}
