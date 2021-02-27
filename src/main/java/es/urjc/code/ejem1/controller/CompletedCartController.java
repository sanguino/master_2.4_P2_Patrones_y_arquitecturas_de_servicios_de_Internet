package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.controller.dto.CompletedCartResponseDTO;
import es.urjc.code.ejem1.domain.Service.CompletedCartService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
