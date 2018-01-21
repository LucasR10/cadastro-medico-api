package br.com.fullstack.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstack.entities.Medico;
import br.com.fullstack.repository.MedicoRepository;
	
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoResources {
	
	@Autowired
	private MedicoRepository repository;
	
	public MedicoResources() {}
	
	@RequestMapping(value="/adicionar", method=RequestMethod.POST)
	public void adicionar ( @RequestBody Medico medico ){
		this.repository.save(medico);
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.DELETE)
	public void  delete( @PathVariable("id") Long id ) {
	 System.out.println( id );
		this.repository.delete(id);
	}
	
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Medico>>  listar() {
		return ResponseEntity.status(HttpStatus.OK).body( repository.findAll() );
	}

	@RequestMapping(value="/listar/{id}", method=RequestMethod.GET)
	public Medico buscar( @PathVariable("id") Long id) {
		return this.repository.findOne(id);
	}

	
}
