package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.Service.*;
import es.urjc.code.ejem1.infrastructure.adapter.SpringDataJPACompletedCartRepositoryAdapter;
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
	public CompletedCartService completedCartService(
			SpringDataJPACompletedCartRepositoryAdapter completedCartRepositoryAdapter) {
		return new CompletedCartServiceImpl(
				completedCartRepositoryAdapter);
	}

	@Bean
	public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductServiceImpl(repositoryAdapter);
	}

}
