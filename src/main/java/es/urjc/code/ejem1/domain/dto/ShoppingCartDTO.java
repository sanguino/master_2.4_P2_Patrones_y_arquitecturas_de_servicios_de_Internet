package es.urjc.code.ejem1.domain.dto;

import es.urjc.code.ejem1.domain.model.ShoppingCartStatus;

import java.util.List;
import java.util.UUID;

public class ShoppingCartDTO {

	private UUID id;
	private ShoppingCartStatus status;
	private List<ShoppingCartItemDTO> items;
	private double price;

	public ShoppingCartDTO() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public List<ShoppingCartItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItemDTO> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
