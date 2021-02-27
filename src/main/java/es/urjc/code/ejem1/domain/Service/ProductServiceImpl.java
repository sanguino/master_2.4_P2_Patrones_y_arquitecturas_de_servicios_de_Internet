package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import org.modelmapper.ModelMapper;

import java.util.Collection;

public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;
	ModelMapper mapper = new ModelMapper();

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<FullProductDTO> getProducts() {
		return repository.finAll();
	}

	@Override
	public FullProductDTO getProduct(Long id) {
		return repository.findById(id);
	}

	@Override
	public FullProductDTO createProduct(ProductDTO productDTO) {
		FullProductDTO fullProductDTO = mapper.map(productDTO, FullProductDTO.class);
		FullProductDTO saveFullProductDTO = repository.save(fullProductDTO);

		return (saveFullProductDTO != null) ? saveFullProductDTO : fullProductDTO;
	}

	@Override
	public FullProductDTO deleteProduct(Long id) {
		FullProductDTO product = repository.findById(id);
		repository.deleteById(id);

		return product;
	}

}
