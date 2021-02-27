package es.urjc.code.ejem1.infrastructure.adapter;

import es.urjc.code.ejem1.domain.dto.CompletedCartDTO;
import es.urjc.code.ejem1.domain.dto.FullCompletedCartDTO;
import es.urjc.code.ejem1.domain.repository.CompletedCartRepository;
import es.urjc.code.ejem1.infrastructure.entity.CompletedCartEntity;
import es.urjc.code.ejem1.infrastructure.repository.SpringDataJPACompletedCartRepository;
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
