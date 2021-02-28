package es.urjc.code.ejem1.infrastructure.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CompletedCartEntity {
  @Id
  private UUID cartId;

  private double expenditure;

  public CompletedCartEntity() {
    super();
  }

  public CompletedCartEntity(UUID cartId, double expenditure) {
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
