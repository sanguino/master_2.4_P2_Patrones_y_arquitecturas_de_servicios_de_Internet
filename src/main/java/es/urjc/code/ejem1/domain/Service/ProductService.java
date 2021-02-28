package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;

public interface ProductService {
	FullProductDTO createProduct(ProductDTO productDTO);

}
