package es.urjc.code.ejem1.domain.model;

import java.util.UUID;

public class CompletedCart {

	private UUID cartId;
	private double expenditure;

	public CompletedCart() {
		super();
	}

	public CompletedCart(UUID cartId, double expenditure) {
		this.cartId = cartId;
		this.expenditure = expenditure;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}

}
