package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.controller.dto.ShoppingCartResponseDTO;
import es.urjc.code.ejem1.domain.Service.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartQueryController {

	private ShoppingCartService shoppingService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartQueryController(ShoppingCartService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@GetMapping("/{id}")
	public ShoppingCartResponseDTO getShoppingCart(@PathVariable String id) {
		return mapper.map(shoppingService.getShoppingCart(UUID.fromString(id)), ShoppingCartResponseDTO.class);
	}

}
