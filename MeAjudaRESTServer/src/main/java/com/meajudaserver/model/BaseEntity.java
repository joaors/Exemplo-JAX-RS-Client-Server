/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meajudaserver.model;

import java.io.Serializable;


/**
 *
 * @author joaorodrigo
 */
public abstract class BaseEntity implements Serializable {
	
    public abstract void setId(Integer id);
	
    public abstract Integer getId();    
}
