package com.github.youssfbr.gradecurricular.controller;

import com.github.youssfbr.gradecurricular.entity.MateriaEntity;
import com.github.youssfbr.gradecurricular.repository.IMateriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    private IMateriaRepository materiaRepository;

    public MateriaController(IMateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> listarMaterias() {
        return ResponseEntity.ok(materiaRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<MateriaEntity> consultarMateria(@PathVariable Long id) {
        return ResponseEntity.ok(materiaRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Boolean> cadastrarMateria(@RequestBody MateriaEntity materia) {
        try {
            materiaRepository.save(materia);
            return ResponseEntity.ok(true);
        }
        catch (Exception ex) {
            return ResponseEntity.ok(false);
        }
    }

    @PutMapping()
    public ResponseEntity<Boolean> atualizarMateria(@RequestBody MateriaEntity materia) {
        try {
            MateriaEntity materiaEntityAtualizada = materiaRepository.findById(materia.getId()).get();

            materiaEntityAtualizada.setNome(materia.getNome());
            materiaEntityAtualizada.setCodigo(materia.getCodigo());
            materiaEntityAtualizada.setHoras(materia.getHoras());
            materiaEntityAtualizada.setNome(materia.getNome());
            materiaEntityAtualizada.setFrequencia(materia.getFrequencia());

            materiaRepository.save(materiaEntityAtualizada);

            return ResponseEntity.ok(true);
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().body(false);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletarMateria(@PathVariable Long id) {
        try {
            materiaRepository.deleteById(id);
            return ResponseEntity.ok(true);
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().body(false);
        }
    }


}
