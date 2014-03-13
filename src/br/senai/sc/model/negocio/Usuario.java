package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;

/*
 * Classe Usuário
 * @version v1.0 Agosto/2013
 * @author Larissa Mezari
 *
 *
 */
// USUARIO codigo login senha nome cpf email telefone endereco dataNascimento
public class Usuario extends PessoaFisica {

	private String login;
	private String senha;
	private String nome;
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
    	return nome;
	}

	public void setNome(String nome) {
    	this.nome = nome;
	}

	public String getEmail() {
    	return email;
	}

	public void setEmail(String email) {
    	this.email = email;
	}

	

	//toString
	public String toString() {
    	return nome;
            	
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
    	if (!Objects.equals(this.nome, other.nome)) {
        	return false;
    	}
    	
    	if (!Objects.equals(this.email, other.email)) {
        	return false;
    	}
    	
    	return true;
	}
}


