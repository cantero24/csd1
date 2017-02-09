package csd.controladores;

import java.beans.PropertyEditor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
import csd.modelo.entidades.Jugador;
import csd.modelo.repositorios.EquiposRepositorio;
import csd.modelo.repositorios.JugadorRepositorio;



@Controller
@RequestMapping("/jugador")
public class JugadorController {


	@Autowired
	private JugadorRepositorio jugadorRepo;

	@Autowired
	private EquiposRepositorio equipoRepo;
	
	@Autowired
	private PropertyEditor equipoPropertyEditor;
	
	@Secured("ADMIN")
	@RequestMapping(method = RequestMethod.GET)
	public String listar (Model model) {
		
		

		Iterable<Jugador> lista = jugadorRepo.findAll();
		Iterable<Equipos> listaeq = equipoRepo.findAll();
		model.addAttribute("titulo", "Listado de Jugador");
		model.addAttribute("jugadores", lista);
		model.addAttribute("equipos", listaeq);
		return "Jugador/listado";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute Jugador jugador, BindingResult bindingResult, Model model) {
		
		
	
		jugadorRepo.save(jugador);	
		
		Iterable<Jugador> lista = jugadorRepo.findAll();
		Iterable<Equipos> listaeq = equipoRepo.findAll();
		model.addAttribute("titulo", "Listado de Jugador");
		model.addAttribute("jugadores", lista);
		model.addAttribute("equipos", listaeq);
		return "Jugador/listado";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrar (@PathVariable Long id){
		
		try {
			jugadorRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
	@ResponseBody
	public Jugador buscarJugador(@PathVariable Long id){
		Jugador jugador = jugadorRepo.findOne(id);
		return jugador;
	}
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Equipos.class, equipoPropertyEditor);
    }
}
