package com.example.cursoalgaworksfullstack.resource;

import com.example.cursoalgaworksfullstack.model.Categoria;
import com.example.cursoalgaworksfullstack.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria c, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(c);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(categoriaSalva);
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo){
        Optional<Categoria> categoriaRetornada = categoriaRepository.findById(codigo);
        return categoriaRetornada.isPresent() ? ResponseEntity.ok(categoriaRetornada) : ResponseEntity.notFound().build();
    }

}
