package com.upc.data.jpa.api.Repository;

import com.upc.data.jpa.api.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

