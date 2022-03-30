package com.dbc.vemser.pessoa_api.controller;

import com.dbc.vemser.pessoa_api.entity.ProfessorEntity;
import com.dbc.vemser.pessoa_api.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor") // localhost:8080/professor
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    @GetMapping
    public List<ProfessorEntity> listar()  {
        return professorRepository.findAll();
    }

    @PostMapping
    public ProfessorEntity create(@RequestBody ProfessorEntity professor) {
        return professorRepository.save(professor);
    }
}
