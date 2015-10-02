package com.meajuda.model;

import java.util.Date;
import java.util.Objects;

public class Atendimento implements BaseModel{
    
    private Integer id;
    
    private Usuario atendenteOrigem;
    
    private Usuario atendenteDestino;
    
    private String descricao;
    
    private Date dataCriacao;
    
    private Chamado chamado;
    
    public Atendimento() {}
    
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }    
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }    

    public Atendimento(Chamado selected) {
        this.dataCriacao = new Date();
        this.atendenteDestino = selected.getAtendenteDestino();
        this.atendenteOrigem = selected.getAtendenteOrigem();
        this.descricao = selected.getDescricao();
    }
    
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

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.descricao);
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
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
