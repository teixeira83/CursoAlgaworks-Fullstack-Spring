package com.example.cursoalgaworksfullstack.resource;

import com.example.cursoalgaworksfullstack.event.RecursoCriarEvent;
import com.example.cursoalgaworksfullstack.model.Pessoa;
import com.example.cursoalgaworksfullstack.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
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
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> inserirPessoa(@Valid @RequestBody Pessoa p, HttpServletResponse response){
        Pessoa pessoaSalva = pessoaRepository.save(p);
        publisher.publishEvent(new RecursoCriarEvent(this, response, pessoaSalva.getcodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPeloId(@PathVariable Long id){
        Optional<Pessoa> pessoaRetornada = pessoaRepository.findById(id);
        return pessoaRetornada.isPresent() ? ResponseEntity.ok(pessoaRetornada) : ResponseEntity.noContent().build();
    }
}
