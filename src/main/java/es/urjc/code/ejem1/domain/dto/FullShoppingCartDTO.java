package es.urjc.code.ejem1.domain.dto;

import es.urjc.code.ejem1.domain.model.ShoppingCartStatus;

import java.util.List;
import java.util.UUID;

public class FullShoppingCartDTO {

	private UUID id;
	private ShoppingCartStatus status;
	private List<FullShoppingCartItemDTO> items;
	private double price;

	public FullShoppingCartDTO() {
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

	public List<FullShoppingCartItemDTO> getItems() {
		return items;
	}

	public void setItems(List<FullShoppingCartItemDTO> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
