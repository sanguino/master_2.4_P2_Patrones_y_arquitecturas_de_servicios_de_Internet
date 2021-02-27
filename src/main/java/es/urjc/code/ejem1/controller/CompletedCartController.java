package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.domain.CompletedCartDTO;
import es.urjc.code.ejem1.domain.CompletedCartService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/api/cartexpenditure")
public class CompletedCartController {

	private CompletedCartService completedCartService;
	private ModelMapper mapper = new ModelMapper();

	public CompletedCartController(CompletedCartService completedCartService) {
		this.completedCartService = completedCartService;
	}

	@GetMapping
	public Collection<CompletedCartResponseDTO> getShoppingCart() {
		return Arrays.asList(mapper.map(completedCartService.getCompletedCarts(), CompletedCartResponseDTO[].class));
	}
}
