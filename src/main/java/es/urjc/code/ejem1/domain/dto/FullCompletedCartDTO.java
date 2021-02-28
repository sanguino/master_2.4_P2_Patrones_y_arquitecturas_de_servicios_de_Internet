package es.urjc.code.ejem1.domain.dto;

import java.util.UUID;

public class FullCompletedCartDTO {

	private UUID cartId;
	private double expenditure;

	public FullCompletedCartDTO() {
		super();
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
