package es.urjc.code.ejem1.domain.repository;

import es.urjc.code.ejem1.domain.dto.CompletedCartDTO;
import es.urjc.code.ejem1.domain.dto.FullCompletedCartDTO;

import java.util.Collection;

public interface CompletedCartRepository {
	Collection<FullCompletedCartDTO> findAll();

	FullCompletedCartDTO save(CompletedCartDTO cart);
}
