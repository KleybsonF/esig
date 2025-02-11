package esig.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import esig.model.Tarefa;
import esig.repository.Tarefas;

@Named
@ViewScoped
public class TarefaBean implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    @Inject
    private Tarefas tarefas;
	
    private Tarefa tarefa = new Tarefa(); // Criando a nova tarefa
	
    private List<Tarefa> listaTarefas;
    
    @PostConstruct
    public void init() {
    	tarefa = new Tarefa();
    	System.out.println("init");
    }
	
    public List<Tarefa> getListaTarefas() {
        if (listaTarefas == null || listaTarefas.isEmpty()) {
            listaTarefas = tarefas.getSituacao("Em andamento");
        }
        return listaTarefas;
    }

    public void todasTarefas() {
        listaTarefas = tarefas.getSituacao("Em andamento");
        if (listaTarefas != null && !listaTarefas.isEmpty()) {
            System.out.println("Tarefas carregadas: " + listaTarefas.size());
            for (Tarefa t : listaTarefas) {
                System.out.println("Tarefa: " + t.getTitulo());
            }
        } else {
            System.out.println("Nenhuma tarefa encontrada.");
        }
    }

	
    public void procurar(String titulo) {
        listaTarefas = tarefas.getSituacao(titulo);
    }
	
    public String salvar() { 
        System.out.println("Entrando no método salvar");

        // Verificar se os valores estão sendo capturados
        System.out.println("Título: " + tarefa.getTitulo());
        System.out.println("Descrição: " + tarefa.getDescricao());
        System.out.println("Responsável: " + tarefa.getResponsavel());
        System.out.println("Prioridade: " + tarefa.getPrioridade());
        System.out.println("Deadline: " + tarefa.getDeadline());

        // Persistir no banco
        tarefas.salvar(tarefa);

        // Resetando o objeto para um novo cadastro
        tarefa = new Tarefa();
        
        return "index?faces-redirect=true"; // Redireciona para a página principal
    }

    // Getter e Setter para novaTarefa
    public Tarefa getTarefa() {
    	System.out.println("Entrando no método getNovaTarefa");
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
    	System.out.println("Entrando no método setNovaTarefa");
        this.tarefa = tarefa;
    }
    
    public String adicionarForm() {
        tarefa = new Tarefa();

     return "cadastro?faces-redirect=true";
 }
}
