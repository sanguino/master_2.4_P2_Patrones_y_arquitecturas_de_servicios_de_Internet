package es.urjc.code.ejem1.domain.dto;

import java.util.UUID;

public class DeletedShoppingCartDTO {

	private UUID id;

	public DeletedShoppingCartDTO() {
		super();
	}

	public DeletedShoppingCartDTO(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
