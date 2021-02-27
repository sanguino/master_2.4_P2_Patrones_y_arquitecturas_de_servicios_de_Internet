package es.urjc.code.ejem1.domain;

import org.modelmapper.ModelMapper;

import java.util.Collection;

public class CompletedCartServiceImpl implements CompletedCartService {

	private CompletedCartRepository completedCartRepository;

	private ModelMapper mapper = new ModelMapper();

	public CompletedCartServiceImpl(CompletedCartRepository completedCartRepository) {
		this.completedCartRepository = completedCartRepository;
	}

	@Override
	public Collection<FullCompletedCartDTO> getCompletedCarts() {
		return completedCartRepository.findAll();
	}
}
