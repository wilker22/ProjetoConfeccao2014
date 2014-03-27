package br.senai.sc.model.negocio;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Curriculo {

    @Id
    @GeneratedValue
    private int codigo;
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String ctps;
    private String cargo;
    private String rg;
    private String salario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAdmissao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRecisao;
    private String status;
    private String experienciaprofissional;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataRecisao() {
        return dataRecisao;
    }

    public void setDataRecisao(Date dataRecisao) {
        this.dataRecisao = dataRecisao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExperienciaprofissional() {
        return experienciaprofissional;
    }

    public void setExperienciaprofissional(String experienciaprofissional) {
        this.experienciaprofissional = experienciaprofissional;
    }

    @Override
    public String toString() {
        return "Curriculo{" + '}';
    }
}
