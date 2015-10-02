package com.meajuda.converter;

import com.meajuda.model.Cliente;
import com.meajuda.service.ClienteService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ClienteConverter implements Converter {

    @Inject
    private ClienteService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cliente cliente = service.get(Integer.parseInt(value));
        return cliente;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Cliente cliente = (Cliente) value;
        if (cliente == null) {
            return "";
        }
        return String.valueOf(cliente.getId());
    }

}
