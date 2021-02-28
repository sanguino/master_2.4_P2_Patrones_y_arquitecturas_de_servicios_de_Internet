package es.urjc.code.ejem1.domain.dto;

import es.urjc.code.ejem1.domain.model.Product;

import java.util.UUID;

public class ShoppingCartItemDTO {

	private UUID id;
	private UUID cartId;
	private Product product;
	private int quantity;
	private double totalPrice;

	public ShoppingCartItemDTO() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
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
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
