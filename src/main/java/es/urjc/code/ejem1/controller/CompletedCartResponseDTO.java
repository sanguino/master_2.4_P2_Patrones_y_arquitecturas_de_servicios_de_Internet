package es.urjc.code.ejem1.controller;

public class CompletedCartResponseDTO {

  private Long cartId;
  private double expenditure;

  public CompletedCartResponseDTO() {
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
