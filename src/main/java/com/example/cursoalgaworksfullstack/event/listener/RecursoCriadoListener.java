package com.example.cursoalgaworksfullstack.event.listener;

import com.example.cursoalgaworksfullstack.event.RecursoCriarEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class RecursoCriadoListener implements ApplicationListener<RecursoCriarEvent> {

    @Override
    public void onApplicationEvent(RecursoCriarEvent recursoCriarEvent){
        HttpServletResponse response = recursoCriarEvent.getResponse();
        Long codigo = recursoCriarEvent.getCodigo();

        adicionarHeaderLocation(response, codigo);
    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
