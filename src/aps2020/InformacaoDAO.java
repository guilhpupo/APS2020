
package aps2020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InformacaoDAO {
    private final Connection con;

    /**
     *
     * @param con
     */
    public InformacaoDAO(Connection con) {
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
     * @param nivel
     * @return
     */
    public ArrayList<Informacao> getInformacao(int nivel) {
        ArrayList<Informacao> informacoes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM informacao";
            PreparedStatement ps = this.getCon().prepareStatement(sql);            
            ResultSet rs;            
            rs = ps.executeQuery(); //EXECUTA A LINHA DO SQL E PEGA OS RESULTADOS

            //PEGA OS DADOS QUE FORAM RETORNADOS PELA TABELA
            while(rs.isAfterLast() == false)
            if (rs.next()) {
                if(rs.getInt("nivel")<=nivel){
                    informacoes.add(new Informacao(rs.getInt("nivel"),rs.getString("informacao")));
                }
            }
            
            
        } catch (SQLException e) {
            return null;
        }
        return informacoes;
    }
}
