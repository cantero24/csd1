package csd.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import csd.modelo.entidades.Federacion;
import csd.modelo.repositorios.FederacionRepositorio;


@Controller
@RequestMapping("/federacion")
public class FederacionController {
	@Autowired
	private FederacionRepositorio federacionRepo;


	@RequestMapping(method = RequestMethod.GET)
	public String listar (Model model) {

		Iterable<Federacion> lista = federacionRepo.findAll();
		model.addAttribute("titulo", "Listado de Federaciones");
		model.addAttribute("federaciones", lista);
		return "Federacion/listado";
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute Federacion federacion, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes ) {

		
		try {
			federacionRepo.save(federacion);
			redirectAttributes.addFlashAttribute ("mensajeInfo", "Se ha insertado la federacion");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute ("mensajeError", "Ha avido un error al insertar la federacion");
			e.printStackTrace();
		}		
		
		Iterable<Federacion> lista = federacionRepo.findAll();
		model.addAttribute("titulo", "Listado de Federaciones");
		model.addAttribute("federaciones", lista);
		
		return "Federacion/listado";
	}
	
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrar (@PathVariable Long id){
		try {
			federacionRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
	@ResponseBody
	public Federacion buscarFederacion(@PathVariable Long id){
		Federacion federacion = federacionRepo.findOne(id);
		return federacion;
	}

}
