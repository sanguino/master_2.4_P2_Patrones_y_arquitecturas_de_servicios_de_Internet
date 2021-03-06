package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.application.ShoppingCartCommandService;
import es.urjc.code.ejem1.controller.dto.ShoppingCartRequestDTO;
import es.urjc.code.ejem1.controller.dto.ShoppingCartResponseDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartCommandController {

	private ShoppingCartCommandService shoppingCartCommandService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartCommandController(ShoppingCartCommandService shoppingCartCommandService) {
		this.shoppingCartCommandService = shoppingCartCommandService;
	}

	@PostMapping("/{idShoppingCart}/product/{idProduct}/quantity/{quantity}")
	public ShoppingCartResponseDTO addProductInShoppingCart(
	        @PathVariable String idShoppingCart,
	        @PathVariable String idProduct,
	        @PathVariable int quantity) {

		return mapper.map(shoppingCartCommandService.addProduct(idShoppingCart, idProduct, quantity),
		        ShoppingCartResponseDTO.class);
	}

	@DeleteMapping("/{idShoppingCart}/product/{idProduct}")
	public ShoppingCartResponseDTO deleteProductInShoppingCart(
	        @PathVariable String idShoppingCart,
	        @PathVariable String idProduct) {
		return mapper.map(shoppingCartCommandService.deleteProduct(idShoppingCart, idProduct), ShoppingCartResponseDTO.class);
	}

	@PostMapping
	public ResponseEntity<ShoppingCartResponseDTO> createShoppingCart() {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartCommandService.createShoppingCart();

		URI location = fromCurrentRequest().path("/{id}")
		        .buildAndExpand(fullShoppingCartDTO.getId()).toUri();

		return ResponseEntity.created(location).body(
		        mapper.map(fullShoppingCartDTO, ShoppingCartResponseDTO.class));
	}

	@PatchMapping("/{id}")
	public ShoppingCartResponseDTO updateShoppingCart(
	        @PathVariable String id,
	        @Validated @RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartCommandService.updateShoppingCart(id,
		        mapper.map(shoppingCartRequestDTO, ShoppingCartDTO.class));

		return mapper.map(fullShoppingCartDTO, ShoppingCartResponseDTO.class);
	}

	@DeleteMapping("/{id}")
	public ShoppingCartResponseDTO deleteShoppingCart(@PathVariable String id) {
		return mapper.map(shoppingCartCommandService.deleteShoppingCart(id), ShoppingCartResponseDTO.class);
	}
}
