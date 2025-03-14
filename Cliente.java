
package com.mycompany.testecrud6;
import java.sql.Date;

public class Cliente {
   
    private int cliId;
    private String cliNome;
    private String cliEmail;
    private String cliSenha;
    private String cliGenero;
    private String cliDataNascimento;
    private String cpf;
    private String cliTelefoneTipo;
    private String cliTelefoneDdd;
    private String cliTelefoneNumero;
    private String cliStatus;
    private int cliRanking;

    public Cliente() {}

    public Cliente(int cliId, String cliNome, String cliEmail, String cliSenha, String cliGenero, String cliDataNascimento, String cpf, String cliTelefoneTipo, String cliTelefoneDdd, String cliTelefoneNumero, String cliStatus, int cliRanking) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliEmail = cliEmail;
        this.cliSenha = cliSenha;
        this.cliGenero = cliGenero;
        this.cliDataNascimento = cliDataNascimento;
        this.cpf = cpf;
        this.cliTelefoneTipo = cliTelefoneTipo;
        this.cliTelefoneDdd = cliTelefoneDdd;
        this.cliTelefoneNumero = cliTelefoneNumero;
        this.cliStatus = cliStatus;
        this.cliRanking = cliRanking;
    }

    public int getCliId() {
        return cliId;
    }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliSenha() {
        return cliSenha;
    }

    public void setCliSenha(String cliSenha) {
        this.cliSenha = cliSenha;
    }

    public String getCliGenero() {
        return cliGenero;
    }

    public void setCliGenero(String cliGenero) {
        this.cliGenero = cliGenero;
    }

    public String getCliDataNascimento() {
        return cliDataNascimento;
    }

    public void setCliDataNascimento(String cliDataNascimento) {
        this.cliDataNascimento = cliDataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCliTelefoneTipo() {
        return cliTelefoneTipo;
    }

    public void setCliTelefoneTipo(String cliTelefoneTipo) {
        this.cliTelefoneTipo = cliTelefoneTipo;
    }

    public String getCliTelefoneDdd() {
        return cliTelefoneDdd;
    }

    public void setCliTelefoneDdd(String cliTelefoneDdd) {
        this.cliTelefoneDdd = cliTelefoneDdd;
    }

    public String getCliTelefoneNumero() {
        return cliTelefoneNumero;
    }

    public void setCliTelefoneNumero(String cliTelefoneNumero) {
        this.cliTelefoneNumero = cliTelefoneNumero;
    }

    public String getCliStatus() {
        return cliStatus;
    }

    public void setCliStatus(String cliStatus) {
        this.cliStatus = cliStatus;
    }

    public int getCliRanking() {
        return cliRanking;
    }

    public void setCliRanking(int cliRanking) {
        this.cliRanking = cliRanking;
    }
}
