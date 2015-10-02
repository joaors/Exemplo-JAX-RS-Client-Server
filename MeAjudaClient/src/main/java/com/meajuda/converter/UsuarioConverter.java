package com.meajuda.converter;

import com.meajuda.model.Usuario;
import com.meajuda.service.UsuarioService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UsuarioConverter implements Converter {

    @Inject
    private UsuarioService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Usuario usuario = service.get(Integer.parseInt(value));
        return usuario;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Usuario usuario = (Usuario) value;
        if (usuario == null) {
            return "";
        }
        return String.valueOf(usuario.getId());
    }

}
