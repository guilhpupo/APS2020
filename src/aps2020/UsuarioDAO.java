package aps2020;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
   
    private final Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    /**
     *
     * @return
     */
    public Connection getCon() {
        return this.con;
    }

    /**
     *
     * @param digital
     * @return
     */
    public Usuario getUsuario(String digital) {
        try {
            String sql = "SELECT nome, nivel FROM usuario WHERE digital = ? ";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, digital);
            ResultSet rs;            
            rs = ps.executeQuery(); //EXECUTA A LINHA DO SQL E PEGA OS RESULTADOS

            //PEGA OS DADOS QUE FORAM RETORNADOS PELA TABELA
            if (rs.next()) {
                return new Usuario(rs.getString("nome"),rs.getInt("nivel"),digital);
            }
        } catch (SQLException e) {
            return null;
            
        }
        
        return null;
    }
}