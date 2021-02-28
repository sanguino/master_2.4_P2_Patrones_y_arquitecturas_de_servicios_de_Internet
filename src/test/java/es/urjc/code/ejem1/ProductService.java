package es.urjc.code.ejem1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.modelmapper.ModelMapper;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.model.Product;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.service.ProductServiceImpl;
import org.springframework.context.ApplicationEventPublisher;

@TestMethodOrder(OrderAnnotation.class)
public class ProductService {

	private ProductServiceImpl productService;

	private ModelMapper mapper = new ModelMapper();

	private static FullProductDTO createdProduct;

	private ApplicationEventPublisher applicationEventPublisher;

	@BeforeEach
	void setUp() {
		productService = new ProductServiceImpl(applicationEventPublisher);
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
	}
/*
	@Test
	@Order(2)
	void productCanBeDeleted() {
		productService.deleteProduct(createdProduct.getId());
		verify(productRepository).deleteById(createdProduct.getId());
	}*/
}
