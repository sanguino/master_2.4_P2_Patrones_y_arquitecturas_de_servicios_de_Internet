package es.urjc.code.ejem1.controller.dto;

import java.util.UUID;

public class ProductResponseDTO {

	private String id;
	private String name;
	private String description;
	private double price;

	public ProductResponseDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
