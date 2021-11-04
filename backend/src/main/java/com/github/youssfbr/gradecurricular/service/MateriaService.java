package com.github.youssfbr.gradecurricular.service;

import com.github.youssfbr.gradecurricular.entity.MateriaEntity;
import com.github.youssfbr.gradecurricular.repository.IMateriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MateriaService implements IMateriaService {

    private IMateriaRepository materiaRepository;

    public MateriaService(IMateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MateriaEntity> listar() {
        return materiaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MateriaEntity consultar(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Boolean cadastrar(MateriaEntity materia) {
        try {
            materiaRepository.save(materia);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean atualizar(MateriaEntity materia) {
        try {
            MateriaEntity materiaEntityAtualizada = materiaRepository.findById(materia.getId()).get();

            materiaEntityAtualizada.setNome(materia.getNome());
            materiaEntityAtualizada.setCodigo(materia.getCodigo());
            materiaEntityAtualizada.setHoras(materia.getHoras());
            materiaEntityAtualizada.setNome(materia.getNome());
            materiaEntityAtualizada.setFrequencia(materia.getFrequencia());

            materiaRepository.save(materiaEntityAtualizada);

            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Boolean excluir(Long id) {
        try {
            materiaRepository.deleteById(id);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
