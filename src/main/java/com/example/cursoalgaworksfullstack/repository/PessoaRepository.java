package com.example.cursoalgaworksfullstack.repository;

import com.example.cursoalgaworksfullstack.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
