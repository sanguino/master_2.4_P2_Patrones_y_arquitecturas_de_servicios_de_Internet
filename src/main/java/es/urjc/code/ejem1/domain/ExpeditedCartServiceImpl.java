package es.urjc.code.ejem1.domain;

import org.modelmapper.ModelMapper;

public class ExpeditedCartServiceImpl implements ExpeditedCartService {

	private ExpeditedCartRepository expeditedCartRepository;

	private ModelMapper mapper = new ModelMapper();

	public ExpeditedCartServiceImpl(ExpeditedCartRepository expeditedCartRepository) {
		this.expeditedCartRepository = expeditedCartRepository;
	}

	@Override
	public FullShoppingCartDTO getExpeditedCarts() {
		return mapper.map(expeditedCartRepository.findAll(), FullShoppingCartDTO.class);
	}
}
