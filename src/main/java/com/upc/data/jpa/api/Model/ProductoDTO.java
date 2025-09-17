package com.upc.data.jpa.api.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private long id;
    private String nombre;
    private double precio;
}
