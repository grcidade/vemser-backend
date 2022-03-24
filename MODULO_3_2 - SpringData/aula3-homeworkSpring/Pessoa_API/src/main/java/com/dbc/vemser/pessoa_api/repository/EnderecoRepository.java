package com.dbc.vemser.pessoa_api.repository;

import com.dbc.vemser.pessoa_api.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("SELECT e FROM ENDERECO_PESSOA e WHERE LOWER (e.pais) = LOWER (:pais)")
    List<EnderecoEntity> findEnderecoByPais(String pais);

    @Query("SELECT e FROM ENDERECO_PESSOA e JOIN FETCH e.pessoas p WHERE p.idPessoa = :id")
    List<EnderecoEntity> findByIdPessoa(Integer id);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA e WHERE LOWER (e.CIDADE) = LOWER (:cidade) OR LOWER (e.PAIS) = LOWER (:pais)", nativeQuery = true)
    List<EnderecoEntity> findEnderecosPorCidadeOuPais(String cidade, String pais);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA e WHERE e.COMPLEMENTO IS NULL", nativeQuery = true)
    List<EnderecoEntity> findWithNoComplement();

}
