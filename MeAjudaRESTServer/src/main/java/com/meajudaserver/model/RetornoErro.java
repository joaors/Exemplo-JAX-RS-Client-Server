/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class RetornoErro implements Serializable {
    
    private String mensagem;
    
    private List<Erro> erros = new ArrayList<>();

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }
    
}
