package es.urjc.code.ejem1.application;

import es.urjc.code.ejem1.domain.dto.FullCompletedCartDTO;
import es.urjc.code.ejem1.domain.repository.CompletedCartRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompletedCartQueryService {

  private CompletedCartRepository completedCartRepository;

  public CompletedCartQueryService(CompletedCartRepository completedCartRepository) {
    this.completedCartRepository = completedCartRepository;
  }

  public Collection<FullCompletedCartDTO> findAll() {
    return completedCartRepository.findAll();
  }
}


