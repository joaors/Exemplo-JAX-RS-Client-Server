package com.meajuda.controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class JsfUtil {
 
    public static Throwable getRootCause(Throwable cause) {
        if (cause != null) {
            Throwable source = cause.getCause();
            if (source != null) {
                return getRootCause(source);
            } else {
                return cause;
            }
        }
        return null;
    }   
    
    public static void cleanSubmittedValues(UIComponent component) {
	if (component instanceof EditableValueHolder) {
		EditableValueHolder evh = (EditableValueHolder) component;
		evh.setSubmittedValue(null);
		evh.setValue(null);
		evh.setLocalValueSet(false);
		evh.setValid(true);
	}
	if (component.getChildCount() > 0) {
		for (UIComponent child : component.getChildren()) {
			cleanSubmittedValues(child);
		}
	}
    }        
    
    public static UIComponent findComponent(String componentName) {
	FacesContext ctx = FacesContext.getCurrentInstance();
	return ctx.getViewRoot().findComponent(componentName);
    }
        
    public static void cleanSubmittedValues(String componentName) {
	cleanSubmittedValues(findComponent(componentName));
	
    }        

    public static boolean isValidationFailed() {
        return FacesContext.getCurrentInstance().isValidationFailed();
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addMessage(message, FacesMessage.SEVERITY_ERROR);
        }
    }

    public static void addMessage(String msg, FacesMessage.Severity severity) {
        FacesMessage facesMsg = new FacesMessage(severity, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }


    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }

}
