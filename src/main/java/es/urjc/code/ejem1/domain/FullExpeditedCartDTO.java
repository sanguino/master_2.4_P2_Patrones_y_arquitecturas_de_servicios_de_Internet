package es.urjc.code.ejem1.domain;

public class FullExpeditedCartDTO {

	private Long cartId;
	private double expenditure;

	public FullExpeditedCartDTO() {
		super();
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
