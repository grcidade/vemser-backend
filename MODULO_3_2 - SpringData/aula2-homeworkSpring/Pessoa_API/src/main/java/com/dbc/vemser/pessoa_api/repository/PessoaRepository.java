package com.dbc.vemser.pessoa_api.repository;

import com.dbc.vemser.pessoa_api.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    List<PessoaEntity> findByCpfContains(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataNascimentoInicial, LocalDate dataNascimentoFinal);
}
