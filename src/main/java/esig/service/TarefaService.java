package esig.service;

import java.io.Serializable;

import javax.inject.Inject;

import esig.model.Tarefa;
import esig.repository.Tarefas;
import esig.util.Transacional;

public class TarefaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Tarefas _tarefa;

    @Transacional
    public void save(Tarefa tarefa) {
        _tarefa.save(tarefa);
    }

    @Transacional
    public void excluir(Tarefa tarefa) {
        _tarefa.remove(tarefa);
    }

}