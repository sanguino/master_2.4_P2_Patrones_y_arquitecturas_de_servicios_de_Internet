package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.*;
import es.urjc.code.ejem1.infrastructure.SpringDataJPAExpeditedCartRepositoryAdapter;
import org.springframework.context.annotation.Bean;

import es.urjc.code.ejem1.infrastructure.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.ejem1.infrastructure.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.ejem1.service.ValidationServiceImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
			SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
			SpringDataJPAProductRepositoryAdapter productRepositoryAdapter) {
		return new ShoppingCartServiceImpl(
				shoppingCartRepositoryAdapter,
				productRepositoryAdapter,
				new ValidationServiceImpl());
	}

	@Bean
	public ExpeditedCartService expeditedCartService(
			SpringDataJPAExpeditedCartRepositoryAdapter expeditedCartRepositoryAdapter) {
		return new ExpeditedCartServiceImpl(
				expeditedCartRepositoryAdapter);
	}

	@Bean
	public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductServiceImpl(repositoryAdapter);
	}

}
