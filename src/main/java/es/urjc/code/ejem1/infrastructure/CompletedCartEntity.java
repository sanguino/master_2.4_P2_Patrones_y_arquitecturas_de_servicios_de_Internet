package es.urjc.code.ejem1.infrastructure;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompletedCartEntity {
  @Id
  private Long cartId;

  private double expenditure;

  public CompletedCartEntity() {
    super();
  }

  public CompletedCartEntity(Long cartId, double expenditure) {
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
