package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;

/*
 * Classe Usuário
 * @version v1.0 Agosto/2013
 * @author Larissa Mezari
 *
 *
 */
// USUARIO codigo login senha nome cpf email telefone endereco dataNascimento

@Entity
public class Usuario extends PessoaFisica {

	private String login;
	private String senha;
	private String nomeFuncionario;
	private String email;


	//Construtor padrão
	public Usuario() {
	}

	//getters e settres
	public String getLogin() {
    	return login;
	}

	public void setLogin(String login) {
    	this.login = login;
	}

	public String getSenha() {
    	return senha;
	}

	public void setSenha(String senha) {
    	this.senha = senha;
	}

	public String getNome() {
    	return nomeFuncionario;
	}

	public void setNome(String nome) {
    	this.nomeFuncionario = nome;
	}

	public String getEmail() {
    	return email;
	}

	public void setEmail(String email) {
    	this.email = email;
	}

	

	//toString
	public String toString() {
    	return nomeFuncionario;
            	
	}

	@Override
	public int hashCode() {
    	int hash = 7;
    	return hash;
	}

	//equals
	public boolean equals(Object obj) {
    	if (obj == null) {
        	return false;
    	}
    	if (getClass() != obj.getClass()) {
        	return false;
    	}
    	final Usuario other = (Usuario) obj;


    	if (!Objects.equals(this.login, other.login)) {
        	return false;
    	}
    	if (!Objects.equals(this.senha, other.senha)) {
        	return false;
    	}
    	if (!Objects.equals(this.nomeFuncionario, other.nomeFuncionario)) {
        	return false;
    	}
    	
    	if (!Objects.equals(this.email, other.email)) {
        	return false;
    	}
    	
    	return true;
	}
}


