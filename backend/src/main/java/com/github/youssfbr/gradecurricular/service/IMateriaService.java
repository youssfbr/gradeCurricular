package com.github.youssfbr.gradecurricular.service;

import com.github.youssfbr.gradecurricular.entity.MateriaEntity;

import java.util.List;

public interface IMateriaService {

    List<MateriaEntity> listar();
    MateriaEntity consultar(final Long id);
    Boolean cadastrar(final MateriaEntity materia);
    Boolean atualizar(final MateriaEntity materia);
    Boolean excluir(final Long id);

}
