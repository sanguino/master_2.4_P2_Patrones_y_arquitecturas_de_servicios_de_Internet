package es.urjc.code.ejem1.domain.model;

import es.urjc.code.ejem1.domain.exception.ShoppingCartDontStockException;
import es.urjc.code.ejem1.domain.service.ValidationService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {

	private UUID id;
	private ShoppingCartStatus status;
	private List<ShoppingCartItem> items;
	private double price;

	private ValidationService validationService;

	public ShoppingCart() {
		super();
		this.id = UUID.randomUUID();
		this.status = ShoppingCartStatus.PENDING;
		this.items = new ArrayList<>();
		this.price = 0;
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

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ValidationService getValidationService() {
		return validationService;
	}

	public void setValidationService(ValidationService validationService) {
		this.validationService = validationService;
	}

	public void addItem(ShoppingCartItem shoppingCartItem) {
		this.items.add(shoppingCartItem);
		this.price = this.calculatePrice();
	}

	public void removeItem(UUID idProduct) {
		this.items.removeIf(item -> item.getProduct().getId().equals(idProduct));
		this.price = this.calculatePrice();
	}

	public double calculatePrice() {
		double price = 0;

		if (this.items != null) {
			for (ShoppingCartItem item : this.items) {
				price += item.getTotalPrice();
			}
		}

		return Math.round(price * 100.0) / 100.0;
	}

	public CompletedCart validate() {
		if (!validationService.validate(this.items)) {
				throw new ShoppingCartDontStockException("Not enough stock");
		}

		this.status = ShoppingCartStatus.COMPLETED;
		return new CompletedCart(this.id, this.price);
	}

}
