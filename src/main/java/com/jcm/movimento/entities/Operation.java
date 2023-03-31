package com.jcm.movimento.entities;

public enum Operation {
	CRÉDITO("credito"),
	DÉBITO("debito");
	
	private String description;
	
	Operation(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
