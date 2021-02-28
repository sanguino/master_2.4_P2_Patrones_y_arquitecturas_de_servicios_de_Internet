package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.Service.ProductService;
import es.urjc.code.ejem1.domain.Service.ProductServiceImpl;
import es.urjc.code.ejem1.domain.Service.ShoppingCartService;
import es.urjc.code.ejem1.domain.Service.ShoppingCartServiceImpl;
import es.urjc.code.ejem1.infrastructure.adapter.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.ejem1.infrastructure.adapter.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.ejem1.service.ValidationServiceImpl;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
			SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
			SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
			ApplicationEventPublisher applicationEventPublisher) {
		return new ShoppingCartServiceImpl(
				shoppingCartRepositoryAdapter,
				productRepositoryAdapter,
				new ValidationServiceImpl(),
				applicationEventPublisher);
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}

}
