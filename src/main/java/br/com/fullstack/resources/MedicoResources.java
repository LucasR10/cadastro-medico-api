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

	public MedicoResources() {
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionar(@RequestBody Medico medico) {
		try {
			this.repository.save(medico);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			this.repository.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Medico>> listar() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Medico> buscar(@PathVariable("id") Long id) {
		try {
			if (repository.findOne(id) == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(this.repository.findOne(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
