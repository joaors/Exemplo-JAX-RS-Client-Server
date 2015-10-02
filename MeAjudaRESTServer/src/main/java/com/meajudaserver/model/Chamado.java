/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Chamado extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDARTEFATO")
    private Artefato artefato;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDCLIENTE")
    private Cliente cliente;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDUSUARIOORIGEM")    
    private Usuario atendenteOrigem;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDUSUARIODESTINO")        
    private Usuario atendenteDestino;    

    @OneToMany(mappedBy="chamado", fetch=FetchType.LAZY, cascade={CascadeType.ALL}, orphanRemoval = true)    
    private List<Atendimento> atendimentos = new ArrayList<>();     
        
    @Column(name="DATACRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    

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
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
    
    @Override
    public int hashCode() {
        int hash = 4;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }
    
}