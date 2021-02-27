package es.urjc.code.ejem1.domain;

import java.util.Collection;

public interface ExpeditedCartRepository {
	Collection<FullExpeditedCartDTO> findAll();

	FullExpeditedCartDTO save(FullExpeditedCartDTO cart);
}
