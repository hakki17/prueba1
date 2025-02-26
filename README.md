# pruebita1

# Esto es una prueba





Cobertura mínima del 80% con JaCoCo: Tu reporte de JaCoCo muestra una cobertura total del 87%, superando el requisito mínimo del 80%.
Spring Boot: Tu proyecto utiliza Spring Boot, como se ve en el POM (spring-boot-starter-parent, spring-boot-starter-web) y en la anotación @SpringBootApplication.
Patrón de diseño implementado: Has implementado el patrón Observador, con los agentes Log y Advertencia como observadores que son notificados cuando cambia el stock de productos.
Inyección de dependencias: Estás usando @Autowired y @Service para la inyección de dependencias en ProductoService.
Agentes implementados:

Agente Log: Notifica todos los cambios de stock
Agente Advertencia: Alerta cuando hay menos de 5 unidades


Requisitos funcionales:

Has implementado la adición de productos (método agregarProducto)
Has implementado la modificación de stock (método actualizarCant)
La notificación a agentes funciona (método notificarObservadores)


Pruebas unitarias: Tienes tests que verifican la funcionalidad de crear productos y actualizar stock.

El código que has compartido muestra que cumples con los principios SOLID:

S (Responsabilidad Única): Cada clase tiene una responsabilidad específica
O (Abierto/Cerrado): La estructura de observadores permite extender la funcionalidad
D (Inversión de Dependencias): Utilizas inyección de dependencias con Spring


@Test
    public void deberiaActualizarStockYNotificar() {
        // Given
        Producto producto = new Producto("Test", 100, 10, "Test");
        productoService.agregarProducto(producto);
        
        // When
        productoService.actualizarStock("Test", 7);
        
        // Then
        assertEquals(7, productoService.buscarProducto("Test").getCantidadStock());
        verify(logObserver).notificarCambioStock(producto);
        verify(advertenciaObserver).notificarCambioStock(producto);
    }
    
    @Test
    public void deberiaNotificarAdvertenciaConStockBajo() {
        // Given
        Producto producto = new Producto("Test", 100, 10, "Test");
        productoService.agregarProducto(producto);
        
        // When
        productoService.actualizarStock("Test", 3);
        
        // Then
        verify(logObserver).notificarCambioStock(producto);
        verify(advertenciaObserver).notificarCambioStock(producto);
    }