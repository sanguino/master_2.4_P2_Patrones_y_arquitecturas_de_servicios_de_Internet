package es.urjc.code.ejem1.domain.model;

import java.util.UUID;

public class ShoppingCartItem {

	private UUID id;
	private Product product;
	private int quantity;

	public ShoppingCartItem() {
		super();
	}

	public ShoppingCartItem(Product product, int quantity) {
		super();
		this.id = UUID.randomUUID();
		this.product = product;
		this.quantity = quantity;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return this.quantity * this.product.getPrice();
	}

}
