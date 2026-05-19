package com.barbearia.backend.service;

import com.barbearia.backend.model.Cliente;
import com.barbearia.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Cliente nao encontrado com ID" + id));
    }

    public Cliente insert (Cliente obj){
        return repository.save(obj);
    }
    public void  delete( Long id ){
        repository.deleteById(id);
    }

    public Cliente update(Cliente obj , Long id){

        Cliente cliente = repository.findById(id).orElseThrow(()->new RuntimeException("Cliente nao encontrado"));
        cliente.setName(obj.getName());
        cliente.setEmail(obj.getEmail());
        cliente.setTelefone(obj.getTelefone());
        return repository.save(cliente);

    }
}

