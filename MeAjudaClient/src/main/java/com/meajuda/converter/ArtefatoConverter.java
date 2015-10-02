package com.meajuda.converter;

import com.meajuda.model.Artefato;
import com.meajuda.service.ArtefatoService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ArtefatoConverter implements Converter {

    @Inject
    private ArtefatoService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Artefato artefato = service.get(Integer.parseInt(value));
        return artefato;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Artefato artefato = (Artefato) value;
        if (artefato == null) {
            return "";
        }
        return String.valueOf(artefato.getId());
    }

}
