package com.barbearia.backend.service;

import com.barbearia.backend.model.Agendamento;
import com.barbearia.backend.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public Agendamento  salvar(Agendamento agendamento) {
        return repository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Agendamento atualizar(Long id, Agendamento agendamentoAtualizado) {

        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        agendamento.setData(agendamentoAtualizado.getData());
        agendamento.setHorario(agendamentoAtualizado.getHorario());
        agendamento.setCliente(agendamentoAtualizado.getCliente());
        agendamento.setServico(agendamentoAtualizado.getServico());

        return repository.save(agendamento);
    }

    public void deletar(Long id) {

        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        repository.delete(agendamento);
    }
}