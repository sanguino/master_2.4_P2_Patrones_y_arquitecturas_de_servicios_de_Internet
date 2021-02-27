package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.domain.ExpeditedCartService;
import es.urjc.code.ejem1.domain.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/cartexpenditure")
public class ExpeditedCartController {

	private ExpeditedCartService expeditedCartService;
	private ModelMapper mapper = new ModelMapper();

	public ExpeditedCartController(ExpeditedCartService expeditedCartService) {
		this.expeditedCartService = expeditedCartService;
	}

	@GetMapping("/")
	public ShoppingCartResponseDTO getShoppingCart() {
		return mapper.map(expeditedCartService.getExpeditedCarts(), ShoppingCartResponseDTO.class);
	}
}
