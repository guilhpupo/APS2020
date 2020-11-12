package aps2020;


public class Informacao {
    private int nivel;
    private String informacao;
    
    Informacao(int nivel, String informacao){
        this.nivel=nivel;
        this.informacao=informacao;
    }
    
    public int getNivel(){
        return this.nivel;
    }
    
    public String getInformacao(){
        return this.informacao;
    }
}
