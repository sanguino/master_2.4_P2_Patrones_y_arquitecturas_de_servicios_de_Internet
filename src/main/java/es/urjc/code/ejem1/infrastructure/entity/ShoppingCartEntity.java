package es.urjc.code.ejem1.infrastructure.entity;

import es.urjc.code.ejem1.domain.model.ShoppingCartStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private ShoppingCartStatus status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ShoppingCartItemEntity> items;

	double price;

	public ShoppingCartEntity() {
		super();
	}

	public ShoppingCartEntity(Long id, List<ShoppingCartItemEntity> items, double price) {
		super();
		this.id = id;
		this.items = items;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
