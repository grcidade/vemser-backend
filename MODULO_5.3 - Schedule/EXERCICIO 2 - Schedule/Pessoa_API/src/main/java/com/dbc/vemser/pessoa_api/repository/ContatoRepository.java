package com.dbc.vemser.pessoa_api.repository;

import com.dbc.vemser.pessoa_api.entity.ContatoEntity;
import com.dbc.vemser.pessoa_api.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query("SELECT c FROM CONTATO c WHERE c.tipoContato = :tipo")
    List<ContatoEntity> findByTipo(TipoContato tipo);

    @Query(value = "SELECT * FROM CONTATO c WHERE c.ID_PESSOA = :idPessoa", nativeQuery = true)
    List<ContatoEntity> findContatoByidPessoa(Integer idPessoa);

}
