package main.java.edu.eci.cvds.ParcialOne.principalclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.ParcialOne.model.Producto;
import edu.eci.cvds.ParcialOne.observadores.Advertencia;
import edu.eci.cvds.ParcialOne.observadores.Log;

import java.util.*;

@Service
public class ProductoService {

    private final Map<String, Producto> productos = new HashMap<>();
    private final Log logobservador;
    private final Advertencia advertenciaobservador;

    @Autowired
	public ProductoService (Log logobservador, Advertencia advertenciaobservador) {
		this.logobservador=logobservador;
        this.advertenciaobservador=advertenciaobservador;
	}

    public void agregarProducto(Producto producto){
        productos.put(producto.getName(),producto);
    }

    public void actualizarCant(String name, int newCant){
        Producto producto = productos.get(name);
        if (producto!=null){
            producto.setCant(newCant);
            notificarObservadores(producto);
        }
    }

    public Producto buscarProducto(String nombre) {
        return productos.get(nombre);
    }

    public void notificarObservadores(Producto producto){
        logobservador.notificar(producto);
        advertenciaobservador.notificar(producto);
    }

}
