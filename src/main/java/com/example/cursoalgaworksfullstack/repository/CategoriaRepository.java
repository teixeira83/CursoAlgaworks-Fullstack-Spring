package com.example.cursoalgaworksfullstack.repository;

import com.example.cursoalgaworksfullstack.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Categoria findByCodigo(Long codigo);
}
