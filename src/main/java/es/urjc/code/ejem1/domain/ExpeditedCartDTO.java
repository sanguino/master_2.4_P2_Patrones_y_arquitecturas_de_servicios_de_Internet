package es.urjc.code.ejem1.domain;

public class ExpeditedCartDTO {

	private Long cartId;
	private double expenditure;

	public ExpeditedCartDTO() {
		super();
	}

	public ExpeditedCartDTO(Long cartId, double expenditure) {
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
