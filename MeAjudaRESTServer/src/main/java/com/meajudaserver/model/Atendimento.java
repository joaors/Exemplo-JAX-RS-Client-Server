package com.meajudaserver.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atendimento extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDUSUARIOORIGEM")    
    private Usuario atendenteOrigem;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDUSUARIODESTINO")    
    private Usuario atendenteDestino;
    
    private String descricao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDCHAMADO")
    private Chamado chamado;    

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
