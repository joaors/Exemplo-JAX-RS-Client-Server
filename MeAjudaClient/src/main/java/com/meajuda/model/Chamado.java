package com.meajuda.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Chamado implements BaseModel{
 
    private Integer id;
    
    private String descricao;
    
    private Artefato artefato;
    
    private Cliente cliente;
    
    private Date dataCriacao;    
    
    private Usuario atendenteOrigem;
    
    private Usuario atendenteDestino;    
    
    private List<Atendimento> atendimentos = new ArrayList<>();    

    public Usuario getAtendenteOrigem() {
        return atendenteOrigem;
    }

    public void setAtendenteOrigem(Usuario atendenteOrigem) {
        this.atendenteOrigem = atendenteOrigem;
    }

    public Usuario getAtendenteDestino() {
        return atendenteDestino;
    }

    public void setAtendenteDestino(Usuario atendenteDestino) {
        this.atendenteDestino = atendenteDestino;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Artefato getArtefato() {
        return artefato;
    }

    public void setArtefato(Artefato artefato) {
        this.artefato = artefato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chamado other = (Chamado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void addAtendimento(Atendimento atendimento) {
        if (atendimentos == null) {
            atendimentos = new ArrayList<>();
        }
        this.atendimentos.add(atendimento);
    }
    
    
}
