package csd.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import csd.modelo.entidades.Equipos;
import csd.modelo.repositorios.EquiposRepositorio;

@Component
public class EquipoPropertyEditor extends PropertyEditorSupport {

    @Autowired private EquiposRepositorio equipoRepositorio;
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println (text);
        long idEquipo = Long.parseLong(text);
        Equipos equipo = equipoRepositorio.findOne(idEquipo);
        setValue(equipo);
    }
    
}