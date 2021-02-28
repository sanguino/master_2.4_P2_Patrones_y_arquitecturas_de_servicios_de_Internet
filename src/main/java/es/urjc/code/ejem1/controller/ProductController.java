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
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;
	private ModelMapper mapper = new ModelMapper();

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public Collection<ProductResponseDTO> getProducts() {
		return Arrays.asList(mapper.map(productService.getProducts(), ProductResponseDTO[].class));
	}

	@GetMapping("/{id}")
	public ProductResponseDTO getProduct(@PathVariable String id) {
		return mapper.map(productService.getProduct(UUID.fromString(id)), ProductResponseDTO.class);
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
