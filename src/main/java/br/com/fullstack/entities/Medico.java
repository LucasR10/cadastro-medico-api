package br.com.fullstack.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @author Lucas.carvalho
	 * @since 01/2018
	 * 
	 * */
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonInclude(Include.NON_NULL)
	private Long codigo;
	private String primeiroNome;
	private String ultimoNome;
	private String email;
	private boolean ativo;
	private boolean ocupado;
	
	public Medico(String primeironome, String ultimoNome, String email, boolean ativo, boolean ocupado) {
		this.primeiroNome = primeironome;
		this.ultimoNome = ultimoNome;
		this.email = email;
		this.ativo = ativo;
		this.ocupado = ocupado;
	}

	public Medico(Long codigo, String primeironome, String ultimoNome, String email, boolean ativo, boolean ocupado) {
		this.codigo = codigo;
		this.primeiroNome = primeironome;
		this.ultimoNome = ultimoNome;
		this.email = email;
		this.ativo = ativo;
		this.ocupado = ocupado;
	}
	
	public Medico() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
  
	
	

}
