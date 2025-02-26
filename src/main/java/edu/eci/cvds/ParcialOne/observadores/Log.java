package edu.eci.cvds.ParcialOne.observadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import edu.eci.cvds.ParcialOne.model.*;

@Component
public class Log {


	public void notificar(Producto product){
		System.out.println("Producto"+product.getName()+"tiene"+product.getCant()+"unidades"); 
	}

}
