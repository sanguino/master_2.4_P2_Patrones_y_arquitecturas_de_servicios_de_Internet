package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.model.Product;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;
	ModelMapper mapper = new ModelMapper();

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public FullProductDTO createProduct(ProductDTO productDTO) {
		Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
		FullProductDTO fullProductDTO = mapper.map(product, FullProductDTO.class);
		FullProductDTO saveFullProductDTO = repository.save(fullProductDTO);

		return (saveFullProductDTO != null) ? saveFullProductDTO : fullProductDTO;
	}

	@Override
	public FullProductDTO deleteProduct(UUID id) {
		FullProductDTO product = repository.findById(id);
		repository.deleteById(id);

		return product;
	}

}
