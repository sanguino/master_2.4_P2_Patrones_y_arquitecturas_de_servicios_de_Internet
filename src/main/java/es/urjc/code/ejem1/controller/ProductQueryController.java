package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.application.ProductQueryService;
import es.urjc.code.ejem1.controller.dto.ProductResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/api/products")
public class ProductQueryController {

	private ProductQueryService productQueryService;
	private ModelMapper mapper = new ModelMapper();

	public ProductQueryController(ProductQueryService productQueryService) {
		this.productQueryService = productQueryService;
	}

	@GetMapping
	public Collection<ProductResponseDTO> getProducts() {
		return Arrays.asList(mapper.map(productQueryService.findAll(), ProductResponseDTO[].class));
	}

	@GetMapping("/{id}")
	public ProductResponseDTO getProduct(@PathVariable String id) {
		return mapper.map(productQueryService.findById(id), ProductResponseDTO.class);
	}

}
