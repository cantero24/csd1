package csd.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import csd.modelo.entidades.Federacion;
import csd.modelo.repositorios.FederacionRepositorio;

@Component
public class FederacionPropertyEditor extends PropertyEditorSupport {

    @Autowired private FederacionRepositorio federacionRepositorio;
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println (text);
        long idFederacion = Long.parseLong(text);
        Federacion federacion = federacionRepositorio.findOne(idFederacion);
        setValue(federacion);
    }
    
}