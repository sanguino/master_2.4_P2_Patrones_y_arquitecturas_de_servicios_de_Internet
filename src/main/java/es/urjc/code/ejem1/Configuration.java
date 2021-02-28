package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.service.ProductService;
import es.urjc.code.ejem1.domain.service.ProductServiceImpl;
import es.urjc.code.ejem1.domain.service.ShoppingCartService;
import es.urjc.code.ejem1.domain.service.ShoppingCartServiceImpl;
import es.urjc.code.ejem1.service.ValidationServiceImpl;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(ApplicationEventPublisher applicationEventPublisher) {
		return new ShoppingCartServiceImpl(
				new ValidationServiceImpl(),
				applicationEventPublisher);
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}

}
