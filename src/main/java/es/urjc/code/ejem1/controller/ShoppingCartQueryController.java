package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.application.ShoppingCartQueryService;
import es.urjc.code.ejem1.controller.dto.ShoppingCartResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartQueryController {

	private ShoppingCartQueryService shoppingCartQueryService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartQueryController(ShoppingCartQueryService shoppingCartQueryService) {
		this.shoppingCartQueryService = shoppingCartQueryService;
	}

	@GetMapping("/{id}")
	public ShoppingCartResponseDTO getShoppingCart(@PathVariable String id) {
		return mapper.map(shoppingCartQueryService.findById(id), ShoppingCartResponseDTO.class);
	}

}
