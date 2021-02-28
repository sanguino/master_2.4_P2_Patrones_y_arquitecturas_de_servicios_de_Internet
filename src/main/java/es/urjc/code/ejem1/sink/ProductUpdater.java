package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.dto.DeletedProductDTO;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdater {

	private ProductRepository repository;

	public ProductUpdater(ProductRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void saveProduct(FullProductDTO createdProduct) {
		repository.save(createdProduct);
	}

	@EventListener
	public void deleteProduct(DeletedProductDTO deletedProduct) {
		repository.deleteById(deletedProduct.getId());
	}
}
