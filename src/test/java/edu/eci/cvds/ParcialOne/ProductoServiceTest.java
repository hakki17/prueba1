package edu.eci.cvds.ParcialOne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.cvds.ParcialOne.model.Producto;
import edu.eci.cvds.ParcialOne.observadores.Advertencia;
import edu.eci.cvds.ParcialOne.observadores.Log;
import main.java.edu.eci.cvds.ParcialOne.principalclass.ProductoService;

class ProductoServiceTest {

	private ProductoService productoService;
	private Log log;
	private Advertencia advertencia;

	@BeforeEach
	public void setup(){
		log =new Log();
		advertencia=new Advertencia();
		productoService=new ProductoService(log, advertencia);
	}

	@Test
	public void shouldCreateProduct() {
		Producto producto = new Producto("vaca",100,10);
		productoService.agregarProducto(producto);
		assertEquals(producto, productoService.buscarProducto("vaca"));
	}

	@Test
    public void deberiaActualizarStock() {
        // Given
        Producto producto = new Producto("vaca", 100, 10);
        productoService.agregarProducto(producto);
        
        // When
        productoService.actualizarCant("vaca", 7);
        
        // Then
        assertEquals(7, productoService.buscarProducto("vaca").getCant());
    }

}
