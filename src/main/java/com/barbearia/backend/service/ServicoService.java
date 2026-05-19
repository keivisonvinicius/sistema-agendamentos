package com.barbearia.backend.service;


import com.barbearia.backend.model.Servico;
import com.barbearia.backend.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public List<Servico> findAll(){
        return repository.findAll();
    }

    public Servico findById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Serviço nao encontrado com ID" + id));
    }

    public Servico insert (Servico obj){
        return repository.save(obj);
    }
    public void  delete( Long id ){
        repository.deleteById(id);
    }

    public Servico update(Servico obj , Long id){

        Servico servico = repository.findById(id).orElseThrow(()->new RuntimeException("Serviço nao encontrado"));
        servico.setName(obj.getName());
        servico.setPreco(obj.getPreco());
        servico.setDescricao(obj.getDescricao());
        return repository.save(servico);

    }
}
