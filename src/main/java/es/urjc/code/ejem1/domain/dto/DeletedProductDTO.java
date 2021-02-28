package es.urjc.code.ejem1.domain.dto;

import java.util.UUID;

public class DeletedProductDTO {

	private UUID id;

	public DeletedProductDTO() {
		super();
	}

	public DeletedProductDTO(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
