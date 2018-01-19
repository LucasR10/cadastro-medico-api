package br.com.fullstack.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstack.entities.Medico;
	
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoResources {
	
	public MedicoResources() {
	}
	
	
	@RequestMapping(name="adicionar", method=RequestMethod.POST , consumes= {"aplication/json"})
	public Medico adicionar ( @RequestBody Medico medico ){
		return medico;
	}
	
	@RequestMapping(name="excluir", method=RequestMethod.DELETE)
	public String delete() {
		return "excluir";
	}
	
	@RequestMapping(name="atualizar", method=RequestMethod.PUT)
	public String atualizar(String medico) {
		return medico;
	}
	
	@RequestMapping(name="listar", method=RequestMethod.GET)
	public ResponseEntity<List<Medico>>  medico() {
		return ResponseEntity.status(HttpStatus.OK).body( listar() );
	}


	private List<Medico> listar() {
		
		List<Medico> medico = new ArrayList<>();
	  	medico.add( new Medico("Mark", "Otto", "exemplo@mdo.com", false, true) );
	  	medico.add( new Medico("Jacob", "Thornton", "exemplo@mdo.com", false, true) );
	  	medico.add( new Medico("Larry", "the Bird", "exemplo@mdo.com", false, true) );
		return medico;
	}
	
//	@RequestMapping(name="buscar", method=RequestMethod.GET)
//	public String listar() {
//		return "buscar";
//	}

	
}
