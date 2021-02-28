package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;

import java.util.Collection;
import java.util.UUID;

public interface ProductService {
	public Collection<FullProductDTO> getProducts();
	public FullProductDTO getProduct(UUID id);
	public FullProductDTO createProduct(ProductDTO productDTO);
	public FullProductDTO deleteProduct(UUID id);
}
