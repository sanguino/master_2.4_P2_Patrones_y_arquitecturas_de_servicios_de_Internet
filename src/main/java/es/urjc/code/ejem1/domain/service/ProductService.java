package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;

public interface ProductService {
	FullProductDTO createProduct(ProductDTO productDTO);
	FullProductDTO deleteProduct(FullProductDTO fullProductDTO);
}
