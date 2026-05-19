package com.barbearia.backend.controller;

import com.barbearia.backend.model.Cliente;
import com.barbearia.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente obj) {
        Cliente novoCliente = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente obj, @PathVariable Long id ){
        Cliente update = service.update(obj,id);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id ){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente>findById(@PathVariable Long id){
        Cliente cliente = service.findById(id);
        return  ResponseEntity.ok().body(cliente);
    }
}
