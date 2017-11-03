//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M3LPBD

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Mateus S. Moreira

//*****************************************************

package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mateus
 */
//Classe para a conexão com o meu banco de dados e a minha base de dados
public class Conexao {
    
    private static final String banco = "jdbc:postgresql://localhost:5433/basemateusmoreira";
    private static final String driver = "org.postgresql.Driver";
    private static final String usuario = "postgres";
    private static final String senha = "postgres";
    private static Connection con = null;
    
    public Conexao(){
        
    }
    //Método que realiza a conexão
    public static Connection getConexao(){
        if (con == null){
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(banco, usuario, senha);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver: " + ex.getMessage());
            } catch (SQLException ex){
                System.out.println("Erro na conexão: " + ex.getMessage());
            }
        }
   
        return con;
    
}
    
public static PreparedStatement getPreparedStatement(String sql){
    if(con == null){
        con = getConexao();
    }
    try {
        return con.prepareStatement(sql);
    } catch (SQLException ex) {
        System.out.println("Erro no SQL" + ex.getMessage());
    }
    return null;
}
   
    
}





