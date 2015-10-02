package com.meajuda.model;

import java.util.Objects;

public class Cliente implements BaseModel {
    
    private Integer id;
    
    private String descricao;

    private Boolean inativo;
    
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
    
    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }    
    
}
