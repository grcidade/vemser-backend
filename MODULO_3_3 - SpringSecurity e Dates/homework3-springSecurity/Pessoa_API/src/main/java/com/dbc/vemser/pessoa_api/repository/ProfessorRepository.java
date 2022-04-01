package com.dbc.vemser.pessoa_api.repository;

import com.dbc.vemser.pessoa_api.entity.PK.ProfessorPK;
import com.dbc.vemser.pessoa_api.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {
}
