package com.upc.data.jpa.api.Service;

import com.upc.data.jpa.api.Model.Producto;
import com.upc.data.jpa.api.Model.Categoria;
import com.upc.data.jpa.api.Model.productoInsertaDTO;
import com.upc.data.jpa.api.Model.ProductoDTO;
import com.upc.data.jpa.api.Repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductoServicio {

    private final ProductoRepository productoRepository;
    public ProductoServicio(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> buscarNombre(String nombre){
        log.info("Buscar producto por nombre "+ nombre);
        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(nombre);
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        ProductoDTO productoDTO;
        for (Producto producto : productos) {
            productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setPrecio(producto.getPrecio());
            productoDTOs.add(productoDTO);
        }
        return productoDTOs;
    }

    public Producto insertar(ProductoDTO productoDTO) {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        return  productoRepository.save(producto);
    }

    public List<Producto> obtenerProductos() {
        log.info("Obteniendo lista de productos");
        return productoRepository.findAll();
    }
    public Producto guardarProducto(Producto producto) {
        log.info("Guardando producto: {}", producto.getNombre());
        return productoRepository.save(producto);
    }
    public Producto guardarProductoCat(productoInsertaDTO producto) {
        log.info("Guardando producto: {}", producto.getNombre());
        Producto productoInsertado = new Producto();
        productoInsertado.setNombre(producto.getNombre());
        productoInsertado.setPrecio(producto.getPrecio());
        Categoria categoria = new Categoria();
        categoria.setId(producto.getCategoria_id());

        productoInsertado.setCategoria(categoria);
        return productoRepository.save(productoInsertado);
    }
    public String eliminarProducto(Long id) {
        log.warn("Eliminando producto con ID: {}", id);
        productoRepository.deleteById(id);
        return "Registro eliminado";
    }
}


