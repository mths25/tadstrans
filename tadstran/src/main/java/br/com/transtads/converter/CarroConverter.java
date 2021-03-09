package br.com.transtads.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import br.com.transtads.persistence.Carro;

@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Carro) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Carro) {
        	Carro entity = (Carro) value;
            if (entity != null && entity instanceof Carro && entity.getId() > 0) {
                uiComponent.getAttributes().put( String.valueOf(entity.getId()), entity);
                return String.valueOf(entity.getId());
            }
        }
        return "";
    }
}
