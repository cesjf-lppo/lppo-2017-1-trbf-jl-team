package br.cesjf.lppo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarefa implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo, descricao;
    private Date dataConcluir, dataConclusao;

    public Tarefa() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataConcluir() {
        return dataConcluir;
    }

    public void setDataConcluir(Date dataConcluir) {
        this.dataConcluir = dataConcluir;
    }

  public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    
}
