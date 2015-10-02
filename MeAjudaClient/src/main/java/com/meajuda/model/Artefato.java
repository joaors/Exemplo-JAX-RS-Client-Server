/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajuda.model;

import java.util.Objects;

/**
 *
 * @author joao
 */
public class Artefato implements BaseModel {

    private int id;
    
    private String nome;

    private Boolean inativo;
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
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
        final Artefato other = (Artefato) obj;
        return Objects.equals(this.id, other.id);
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
    public String toString() {
        return this.nome;
    }
    
    
}
