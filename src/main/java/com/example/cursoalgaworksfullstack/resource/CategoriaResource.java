package com.example.cursoalgaworksfullstack.resource;

import com.example.cursoalgaworksfullstack.event.RecursoCriarEvent;
import com.example.cursoalgaworksfullstack.model.Categoria;
import com.example.cursoalgaworksfullstack.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria c, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(c);

        publisher.publishEvent(new RecursoCriarEvent(this, response, categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo){
        Optional<Categoria> categoriaRetornada = categoriaRepository.findById(codigo);
        return categoriaRetornada.isPresent() ? ResponseEntity.ok(categoriaRetornada) : ResponseEntity.notFound().build();
    }

}
