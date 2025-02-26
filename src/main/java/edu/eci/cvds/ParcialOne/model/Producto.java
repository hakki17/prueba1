package edu.eci.cvds.ParcialOne.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Producto {

	private String name;
	private int price;
	private int cant;

	public Producto (String name, int price, int cant) {
		this.name=name;
		this.price=price;
		this.cant=cant;
	}

	public String getName(){
		return name;
	}

	public void setCant(int cant){
		this.cant=cant;
	}

	public int getCant(){
		return cant;
	}

}
