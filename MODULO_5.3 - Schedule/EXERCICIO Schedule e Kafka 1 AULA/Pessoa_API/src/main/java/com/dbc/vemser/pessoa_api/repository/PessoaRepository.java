package com.dbc.vemser.pessoa_api.repository;

import com.dbc.vemser.pessoa_api.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    List<PessoaEntity> findByCpfContains(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataNascimentoInicial, LocalDate dataNascimentoFinal);

    @Query("SELECT p FROM PESSOA p WHERE p.dataNascimento BETWEEN :valor1 AND :valor2")
    List<PessoaEntity> findByDateBetween(LocalDate valor1, LocalDate valor2);

    @Query("SELECT p FROM PESSOA p join fetch p.enderecos e")
    List<PessoaEntity> findIfHasAddress();

    @Query(value = "SELECT * FROM PESSOA p FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON p.ID_PESSOA = pxpe.ID_PESSOA WHERE ID_ENDERECO IS NULL", nativeQuery = true)
    List<PessoaEntity> getPessoasSemEndereco();

}
