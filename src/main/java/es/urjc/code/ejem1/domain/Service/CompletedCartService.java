package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullCompletedCartDTO;

import java.util.Collection;

public interface CompletedCartService {
	Collection<FullCompletedCartDTO> getCompletedCarts();
}
