package com.jcm.movimento.entities;

public enum Status {
	ABERTO("aberto"),
	FECHADO("fechado"),
	CANCELADO("cancelado");
	
	private String description;
	
	Status(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
