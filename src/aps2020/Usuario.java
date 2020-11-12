package aps2020;

public class Usuario {
    private final String nome;
    private final int nivel;
    private final String digital;
    
    Usuario(String nome, int nivel, String digital){
        this.nome=nome;
        this.nivel=nivel;
        this.digital=digital;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getNivel(){
        return this.nivel;
    }
    
    public String getDigital(){
        return this.digital;
    }
}
