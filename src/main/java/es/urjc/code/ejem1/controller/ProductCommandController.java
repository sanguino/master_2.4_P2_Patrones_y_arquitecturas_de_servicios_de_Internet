package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.controller.dto.ProductRequestDTO;
import es.urjc.code.ejem1.controller.dto.ProductResponseDTO;
import es.urjc.code.ejem1.domain.Service.ProductService;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

	private ProductService productService;
	private ModelMapper mapper = new ModelMapper();

	public ProductCommandController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		ProductDTO productDTO = mapper.map(productRequestDTO, ProductDTO.class);
		FullProductDTO fullProductDTO = productService.createProduct(productDTO);

		URI location = fromCurrentRequest().path("/{id}")
		        .buildAndExpand(fullProductDTO.getId()).toUri();

		return ResponseEntity.created(location).body(
		        mapper.map(fullProductDTO, ProductResponseDTO.class));
	}

	@DeleteMapping("/{id}")
	public ProductResponseDTO deleteProduct(@PathVariable String id) {
		return mapper.map(productService.deleteProduct(UUID.fromString(id)), ProductResponseDTO.class);
	}

}
