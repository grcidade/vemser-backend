package com.dbc.vemser.pessoa_api.repository;

import com.dbc.vemser.pessoa_api.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
}
