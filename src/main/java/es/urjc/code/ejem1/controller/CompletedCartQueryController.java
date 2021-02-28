package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.application.CompletedCartQueryService;
import es.urjc.code.ejem1.controller.dto.CompletedCartResponseDTO;
import es.urjc.code.ejem1.domain.repository.CompletedCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/api/cartexpenditure")
public class CompletedCartQueryController {

	private CompletedCartQueryService completedCartQueryService;
	private ModelMapper mapper = new ModelMapper();

	public CompletedCartQueryController(CompletedCartQueryService completedCartQueryService) {
		this.completedCartQueryService = completedCartQueryService;
	}

	@GetMapping
	public Collection<CompletedCartResponseDTO> getShoppingCart() {
		return Arrays.asList(mapper.map(completedCartQueryService.findAll(), CompletedCartResponseDTO[].class));
	}
}
