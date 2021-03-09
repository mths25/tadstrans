package br.com.transtads.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.transtads.persistence.Transferencia;


@FacesConverter(forClass = Transferencia.class)
public class TransferenciaConverter implements Converter{
	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Transferencia) uiComponent.getAttributes().get(value);
        }
        return null;
    }

	
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Transferencia) {
        	Transferencia entity = (Transferencia) value;
            if (entity != null && entity instanceof Transferencia && entity.getId() > 0) {
                uiComponent.getAttributes().put( String.valueOf(entity.getId()), entity);
                return String.valueOf(entity.getId());
            }
        }
        return "";
    }
}
