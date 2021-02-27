package es.urjc.code.ejem1.domain;

import java.util.ArrayList;
import java.util.List;

public class ExpeditedCart {

	private Long cartId;
	private double expenditure;

	public ExpeditedCart() {
		super();
	}

	public ExpeditedCart(Long cartId, double expenditure) {
		this.cartId = cartId;
		this.expenditure = expenditure;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}

}
