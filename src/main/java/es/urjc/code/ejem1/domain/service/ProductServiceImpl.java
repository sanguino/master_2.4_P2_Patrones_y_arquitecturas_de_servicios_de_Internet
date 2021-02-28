package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.dto.DeletedProductDTO;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;

public class ProductServiceImpl implements ProductService {

	ModelMapper mapper = new ModelMapper();
	private ApplicationEventPublisher applicationEventPublisher;

	public ProductServiceImpl(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public FullProductDTO createProduct(ProductDTO productDTO) {
		Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
		FullProductDTO createdFullProductDTO = mapper.map(product, FullProductDTO.class);
		applicationEventPublisher.publishEvent(createdFullProductDTO);
		return createdFullProductDTO;
	}

	@Override
	public FullProductDTO deleteProduct(FullProductDTO fullProductDTO) {
		applicationEventPublisher.publishEvent(new DeletedProductDTO(fullProductDTO.getId()));
		return fullProductDTO;
	}

}
