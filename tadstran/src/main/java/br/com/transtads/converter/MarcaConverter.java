package br.com.transtads.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.transtads.persistence.Marca;

@FacesConverter(forClass = Marca.class)
public class MarcaConverter implements Converter{
	
	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Marca) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Marca) {
	        	Marca entity = (Marca) value;
	            if (entity != null && entity instanceof Marca && entity.getId() > 0) {
	                uiComponent.getAttributes().put( String.valueOf(entity.getId()), entity);
	                return String.valueOf(entity.getId());
	            }
	        }
	        return "";
	    }
}
