package es.urjc.code.ejem1.controller.dto;

import es.urjc.code.ejem1.domain.model.ShoppingCartStatus;

import java.util.List;
import java.util.UUID;

public class ShoppingCartResponseDTO {

	private String id;
	private ShoppingCartStatus status;
	private List<ShoppingCartItemResponseDTO> items;
	private double price;

	public ShoppingCartResponseDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id.toString();
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public List<ShoppingCartItemResponseDTO> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItemResponseDTO> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
