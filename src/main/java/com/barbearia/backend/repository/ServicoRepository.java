package com.barbearia.backend.repository;



import com.barbearia.backend.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Long> {
}
