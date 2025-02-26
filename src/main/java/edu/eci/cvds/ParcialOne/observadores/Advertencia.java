package edu.eci.cvds.ParcialOne.observadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


import edu.eci.cvds.ParcialOne.model.*;

@Component
public class Advertencia {

	public void notificar(Producto product) {
		if (product.getCant() < 5){
			System.out.println("Alerta!, el stock del producto"+product.getCant());
		}
	}
		


}
