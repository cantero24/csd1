package csd.controladores;

import java.beans.PropertyEditor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import csd.modelo.entidades.Equipos;
import csd.modelo.entidades.Federacion;
import csd.modelo.repositorios.EquiposRepositorio;
import csd.modelo.repositorios.FederacionRepositorio;



@Controller
@RequestMapping("/equipos")
public class EquipoController {

	@Autowired
	private EquiposRepositorio equipoRepo;
	
	@Autowired
	private FederacionRepositorio federacionRepo;
	
	@Autowired
	private PropertyEditor federacionPropertyEditor;

	@RequestMapping(method = RequestMethod.GET)
	public String listar (Model model) {

		Iterable<Equipos> lista = equipoRepo.findAll();
		Iterable<Federacion> listafed = federacionRepo.findAll();
		model.addAttribute("titulo", "Listado de Equipos");
		model.addAttribute("equipos", lista);
		model.addAttribute("federaciones", listafed);
		
		return "Equipos/listado";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute Equipos equipo, BindingResult bindingResult, Model model) {

		equipoRepo.save(equipo);
		
		Iterable<Equipos> lista = equipoRepo.findAll();
		Iterable<Federacion> listafed = federacionRepo.findAll();
		model.addAttribute("titulo", "Listado de Equipos");
		model.addAttribute("equipos", lista);
		model.addAttribute("federaciones", listafed);
		return "Equipos/listado";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrar (@PathVariable Long id){
		try {
			equipoRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
	@ResponseBody
	public Equipos buscarEquipo(@PathVariable Long id){
		Equipos equipo = equipoRepo.findOne(id);
		return equipo;
	}
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Federacion.class, federacionPropertyEditor);
    }
}
