package com.barbearia.backend.controller;

import com.barbearia.backend.model.Servico;
import com.barbearia.backend.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService service;


    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        List<Servico> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Servico> insert(@RequestBody Servico obj) {
        Servico novoServico = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> update(@RequestBody Servico obj, @PathVariable Long id ){
        Servico update = service.update(obj,id);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id ){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico>findById(@PathVariable Long id){
        Servico servico = service.findById(id);
        return  ResponseEntity.ok().body(servico);
    }
}
