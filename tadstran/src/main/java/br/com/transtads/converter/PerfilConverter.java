package br.com.transtads.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.transtads.persistence.Perfil;


@FacesConverter(forClass = Perfil.class)
public class PerfilConverter implements Converter{
	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Perfil) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Perfil) {
        	Perfil entity = (Perfil) value;
            if (entity != null && entity instanceof Perfil && entity.getId() > 0) {
                uiComponent.getAttributes().put( String.valueOf(entity.getId()), entity);
                return String.valueOf(entity.getId());
            }
        }
        return "";
    }
}
