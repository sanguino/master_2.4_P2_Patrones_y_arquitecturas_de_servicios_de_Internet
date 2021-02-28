package es.urjc.code.ejem1.infrastructure.entity;

import es.urjc.code.ejem1.domain.model.ShoppingCartStatus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class ShoppingCartEntity {

	@Id
	private UUID id;
	private ShoppingCartStatus status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ShoppingCartItemEntity> items;

	double price;

	public ShoppingCartEntity() {
		super();
	}

	public ShoppingCartEntity(UUID id, List<ShoppingCartItemEntity> items, double price) {
		super();
		this.id = id;
		this.items = items;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public List<ShoppingCartItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItemEntity> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
