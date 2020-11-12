/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps2020;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    // -- MUDAR AQUI SE NECESSARIO
    public static final String IP = "localhost";
    public static  String login = "root";
    public static  String senha = "root";
    
    public static Connection abrirConexao() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Connection con = null;
        
        try{
            System.out.println("Conectando ao banco ...");
            Class.forName("com.mysql.jdbc.Driver").newInstance();         
            String url ="";
            url+="jdbc:mysql://";
            url+=IP;
            url+="/aps2020?";
            url+="allowPublicKeyRetrieval=true&";
            url+="useSSL=false&";
            url+="user=";
            url+=login;
            url+="&password=";
            url+=senha;
            
            con = DriverManager.getConnection(url);
            
            System.out.println("Conexão aberta para " + login);       
            
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
            System.out.println("Falhou!");
            System.out.println(e.getMessage());
        }
        
        return con;
    }
    
    public static void fecharConexao(Connection con){
        try{
            con.close();
            System.out.println("Conexão fechada para "+ login);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    
}