package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.model.Product;
import org.modelmapper.ModelMapper;

public class ProductServiceImpl implements ProductService {

	ModelMapper mapper = new ModelMapper();

	@Override
	public FullProductDTO createProduct(ProductDTO productDTO) {
		Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
		return mapper.map(product, FullProductDTO.class);
	}

}
