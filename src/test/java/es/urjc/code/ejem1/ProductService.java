package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.dto.DeletedProductDTO;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.model.Product;
import es.urjc.code.ejem1.domain.service.ProductServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;


@TestMethodOrder(OrderAnnotation.class)
public class ProductService {

	@Mock
	private ApplicationEventPublisher applicationEventPublisher;

	@InjectMocks
	private ProductServiceImpl productService;

	@Captor
	ArgumentCaptor<DeletedProductDTO> argumentDeletedProductDTO;

	private ModelMapper mapper = new ModelMapper();

	private static FullProductDTO createdProduct;

	@BeforeEach
	void setUp() {
		openMocks(this);
	}

	@Test
	@Order(1)
	void productCanBeAdded() {
		Product product = new Product(
				"PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
				"Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
				49.99);

		ProductDTO productDTO = mapper.map(product, ProductDTO.class);

		createdProduct = productService.createProduct(productDTO);
		verify(applicationEventPublisher).publishEvent(createdProduct);
	}

	@Test
	@Order(2)
	void productCanBeDeleted() {
		productService.deleteProduct(createdProduct);
		verify(applicationEventPublisher).publishEvent(argumentDeletedProductDTO.capture());
		DeletedProductDTO deletedProductDTO = this.argumentDeletedProductDTO.getValue();
		assertEquals(deletedProductDTO.getId(), createdProduct.getId());
	}
}
