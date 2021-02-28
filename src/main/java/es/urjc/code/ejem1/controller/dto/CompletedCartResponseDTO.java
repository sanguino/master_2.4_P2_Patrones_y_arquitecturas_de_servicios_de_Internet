package es.urjc.code.ejem1.controller.dto;

import java.util.UUID;

public class CompletedCartResponseDTO {

  private String cartId;
  private double expenditure;

  public CompletedCartResponseDTO() {
    super();
  }

  public String getCartId() {
    return cartId;
  }

  public void setCartId(UUID cartId) {
    this.cartId = cartId.toString();
  }

  public double getExpenditure() {
    return expenditure;
  }

  public void setExpenditure(double expenditure) {
    this.expenditure = expenditure;
  }

}
