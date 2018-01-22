package br.com.fullstack.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fullstack.entities.Medico;

public interface MedicoRepository 	extends JpaRepository<Medico, Long> {

}
