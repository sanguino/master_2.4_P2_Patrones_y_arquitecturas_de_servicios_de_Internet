package es.urjc.code.ejem1.sink;

import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.event.CreateProductEvent;
import es.urjc.code.ejem1.event.DeleteProductEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdater {

	private ProductRepository repository;

	public ProductUpdater(ProductRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void saveProduct(CreateProductEvent event) {
		repository.save(event.getFullProductDTO());
	}

	@EventListener
	public void deleteProduct(DeleteProductEvent event) {
		repository.deleteById(event.getFullProductDTO().getId());
	}
}
