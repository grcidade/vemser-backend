package com.dbc.vemser.pessoa_api.repository;

import com.dbc.vemser.pessoa_api.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GrupoEntity, Integer> {
}
