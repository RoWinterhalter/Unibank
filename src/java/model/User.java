package model;

public class User {
    // User Info
    private int user_id;
    private String nome_completo;
    private String cpf;
    private String email;

    // Account Info
    private int acc_id;
    private String login;
    private String senha;
    private float saldo;


    public int GetUserId(){
        return this.user_id;
    }

    public void setUserId(int user_id){
        this.user_id = user_id;
    }



    public String getNome_completo(){
        return this.nome_completo;
    }

    public void setNome_completo(String nome_completo){
        this.nome_completo = nome_completo;
    }


    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }


    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public int getAccId(){
        return this.acc_id;
    }

    public void setAccId(int accId){
        this.acc_id = accId;
    }


    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public float getSaldo(){
        return this.saldo;
    }

    public void setSaldo(){
        this.saldo = saldo;
    }
}
