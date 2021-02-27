package es.urjc.code.ejem1.domain.dto;

public class FullCompletedCartDTO {

	private Long cartId;
	private double expenditure;

	public FullCompletedCartDTO() {
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
