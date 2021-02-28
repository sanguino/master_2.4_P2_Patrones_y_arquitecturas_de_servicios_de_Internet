package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;

import java.util.Collection;
import java.util.UUID;

public interface ProductService {
	FullProductDTO createProduct(ProductDTO productDTO);
	FullProductDTO deleteProduct(UUID id);
}
