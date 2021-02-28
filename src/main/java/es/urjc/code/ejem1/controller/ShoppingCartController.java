package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.controller.dto.ShoppingCartRequestDTO;
import es.urjc.code.ejem1.controller.dto.ShoppingCartResponseDTO;
import es.urjc.code.ejem1.domain.Service.ShoppingCartService;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartController {

	private ShoppingCartService shoppingService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartController(ShoppingCartService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@GetMapping("/{id}")
	public ShoppingCartResponseDTO getShoppingCart(@PathVariable String id) {
		return mapper.map(shoppingService.getShoppingCart(UUID.fromString(id)), ShoppingCartResponseDTO.class);
	}

	@PostMapping("/{idShoppingCart}/product/{idProduct}/quantity/{quantity}")
	public ShoppingCartResponseDTO addProductInShoppingCart(
	        @PathVariable String idShoppingCart,
	        @PathVariable String idProduct,
	        @PathVariable int quantity) {

		return mapper.map(shoppingService.addProduct(UUID.fromString(idShoppingCart), UUID.fromString(idProduct), quantity),
		        ShoppingCartResponseDTO.class);
	}

	@DeleteMapping("/{idShoppingCart}/product/{idProduct}")
	public ShoppingCartResponseDTO deleteProductInShoppingCart(
	        @PathVariable String idShoppingCart,
	        @PathVariable String idProduct) {
		return mapper.map(shoppingService.deleteProduct(UUID.fromString(idShoppingCart), UUID.fromString(idProduct)), ShoppingCartResponseDTO.class);
	}

	@PostMapping
	public ResponseEntity<ShoppingCartResponseDTO> createShoppingCart() {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingService.createShoppingCart();

		URI location = fromCurrentRequest().path("/{id}")
		        .buildAndExpand(fullShoppingCartDTO.getId()).toUri();

		return ResponseEntity.created(location).body(
		        mapper.map(fullShoppingCartDTO, ShoppingCartResponseDTO.class));
	}

	@PatchMapping("/{id}")
	public ShoppingCartResponseDTO updateShoppingCart(
	        @PathVariable String id,
	        @Validated @RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingService.updateShoppingCart(UUID.fromString(id),
		        mapper.map(shoppingCartRequestDTO, ShoppingCartDTO.class));

		return mapper.map(fullShoppingCartDTO, ShoppingCartResponseDTO.class);
	}

	@DeleteMapping("/{id}")
	public ShoppingCartResponseDTO deleteShoppingCart(@PathVariable String id) {
		return mapper.map(shoppingService.deleteShoppingCart(UUID.fromString(id)), ShoppingCartResponseDTO.class);
	}
}
