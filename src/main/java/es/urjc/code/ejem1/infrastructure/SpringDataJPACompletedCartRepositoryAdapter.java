package es.urjc.code.ejem1.infrastructure;

import es.urjc.code.ejem1.domain.CompletedCartDTO;
import es.urjc.code.ejem1.domain.CompletedCartRepository;
import es.urjc.code.ejem1.domain.FullCompletedCartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class SpringDataJPACompletedCartRepositoryAdapter implements CompletedCartRepository {

  private SpringDataJPACompletedCartRepository repository;
  private ModelMapper mapper = new ModelMapper();

  public SpringDataJPACompletedCartRepositoryAdapter(SpringDataJPACompletedCartRepository repository) {
    this.repository = repository;
  }

  @Override
  public Collection<FullCompletedCartDTO> findAll() {
		return Arrays.asList(mapper.map(repository.findAll(), FullCompletedCartDTO[].class));
	}

	@Override
	public FullCompletedCartDTO save(CompletedCartDTO cart) {
		CompletedCartEntity completedCartEntity = mapper.map(cart, CompletedCartEntity.class);
		repository.save(completedCartEntity);

		return mapper.map(completedCartEntity, FullCompletedCartDTO.class);
	}
}
