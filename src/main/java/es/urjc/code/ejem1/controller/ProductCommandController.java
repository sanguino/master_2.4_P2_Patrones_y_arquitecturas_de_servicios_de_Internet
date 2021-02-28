package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.application.ProductCommandService;
import es.urjc.code.ejem1.controller.dto.ProductRequestDTO;
import es.urjc.code.ejem1.controller.dto.ProductResponseDTO;
import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

	private ProductCommandService productCommandService;
	private ModelMapper mapper = new ModelMapper();

	public ProductCommandController(ProductCommandService productCommandService) {
		this.productCommandService = productCommandService;
	}

	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		ProductDTO productDTO = mapper.map(productRequestDTO, ProductDTO.class);
		FullProductDTO fullProductDTO = productCommandService.createProduct(productDTO);

		URI location = fromCurrentRequest().path("/{id}")
		        .buildAndExpand(fullProductDTO.getId()).toUri();

		return ResponseEntity.created(location).body(
		        mapper.map(fullProductDTO, ProductResponseDTO.class));
	}

	@DeleteMapping("/{id}")
	public ProductResponseDTO deleteProduct(@PathVariable String id) {
		return mapper.map(productCommandService.deleteProduct(id), ProductResponseDTO.class);
	}

}
