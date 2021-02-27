package es.urjc.code.ejem1.domain;

import java.util.Collection;

public interface CompletedCartRepository {
	Collection<FullCompletedCartDTO> findAll();

	FullCompletedCartDTO save(CompletedCartDTO cart);
}
