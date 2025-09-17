package com.upc.data.jpa.api.Controller;


import com.upc.data.jpa.api.Model.Producto;
import com.upc.data.jpa.api.Model.ProductoDTO;
import com.upc.data.jpa.api.Model.productoInsertaDTO;
import com.upc.data.jpa.api.Service.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api")
@Slf4j
public class ProductoController {
    private final ProductoServicio productoServicio;

    public ProductoController(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO productoDTO) {
        return new ResponseEntity(productoServicio.insertar(productoDTO), HttpStatus.CREATED);
    }

    @PostMapping("/inserta")
    public ResponseEntity<Producto> createProducto(@RequestBody  Producto producto) {
        return new ResponseEntity(productoServicio.guardarProducto(producto), HttpStatus.CREATED);
    }
    @PostMapping("/inserta-cat")
    public ResponseEntity<Producto> createProducto(@RequestBody productoInsertaDTO producto) {
        return new ResponseEntity(productoServicio.guardarProductoCat(producto), HttpStatus.CREATED);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<ProductoDTO>> buscarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(productoServicio.buscarNombre(nombre), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return new ResponseEntity<>(productoServicio.obtenerProductos(), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.warn("Solicitud DELETE para eliminar producto con ID: {}", id);
        return new ResponseEntity<>(productoServicio.eliminarProducto(id), HttpStatus.OK);
    }
}
