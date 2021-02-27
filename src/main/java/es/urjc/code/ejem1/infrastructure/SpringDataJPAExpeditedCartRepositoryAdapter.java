package es.urjc.code.ejem1.infrastructure;

import es.urjc.code.ejem1.domain.ExpeditedCartDTO;
import es.urjc.code.ejem1.domain.ExpeditedCartRepository;
import es.urjc.code.ejem1.domain.FullExpeditedCartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class SpringDataJPAExpeditedCartRepositoryAdapter implements ExpeditedCartRepository {

  private SpringDataJPAExpeditedCartRepository repository;
  private ModelMapper mapper = new ModelMapper();

  public SpringDataJPAExpeditedCartRepositoryAdapter(SpringDataJPAExpeditedCartRepository repository) {
    this.repository = repository;
  }

  @Override
  public Collection<FullExpeditedCartDTO> findAll() {
		return Arrays.asList(mapper.map(repository.findAll(), FullExpeditedCartDTO[].class));
	}

	@Override
	public FullExpeditedCartDTO save(ExpeditedCartDTO cart) {
		ExpeditedCartEntity expeditedCartEntity = mapper.map(cart, ExpeditedCartEntity.class);
		repository.save(expeditedCartEntity);

		return mapper.map(expeditedCartEntity, FullExpeditedCartDTO.class);
	}
}
