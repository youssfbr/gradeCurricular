package com.github.youssfbr.gradecurricular.controller;

import com.github.youssfbr.gradecurricular.entity.MateriaEntity;
import com.github.youssfbr.gradecurricular.repository.IMateriaRepository;
import com.github.youssfbr.gradecurricular.service.IMateriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    private IMateriaService materiaService;

    public MateriaController(IMateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> listarMaterias() {
        return ResponseEntity.ok(materiaService.listar());
    }

    @GetMapping("{id}")
    public ResponseEntity<MateriaEntity> consultarMateria(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.consultar(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> cadastrarMateria(@RequestBody MateriaEntity materia) {
        return ResponseEntity.ok(materiaService.cadastrar(materia));
    }

    @PutMapping()
    public ResponseEntity<Boolean> atualizarMateria(@RequestBody MateriaEntity materia) {
            return ResponseEntity.ok(materiaService.atualizar(materia));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletarMateria(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.excluir(id));
    }


}
