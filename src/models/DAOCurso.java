//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M3LPBD

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Mateus S. Moreira

//*****************************************************
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus
 */
//classe DAOCurso para realizar ás operações referentes ao meu banco de dados
public class DAOCurso {

    //Método no qual realiza 
    public List<Curso> getLista(){
        
        String sql = "select * from cursos";
        List<Curso> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    Curso cur = new Curso();
                    cur.setId(rs.getInt("id"));
                    cur.setNomeCurso(rs.getString("nomeCurso"));
                    cur.setPeriodo(rs.getString("periodo"));
                       lista.add(cur);                                                                            
                }
        }catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "Erro de SQL" + ex.getMessage());
        }
        return lista;
    }
    //Método que salva o objeto na abela caso seja escolhido a opção de incluir um novo objeto
    public boolean Salvar(Curso cur){
        if(cur.getId() == null){
            return incluir(cur);
        }else {
            return alterar(cur); 
        }
    }
    //Método que inclui um novo objeto na tabela atraves de um comando de insert
    public boolean incluir(Curso cur){
        String sql = "insert into cursos (nomeCurso, periodo) values (?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            
            pst.setString(1, cur.getNomeCurso());
            pst.setString(2, cur.getPeriodo());
            
            if(pst.executeUpdate() > 0){
                   JOptionPane.showMessageDialog(null, "Curso incluido com sucesso");
                   return true;
            }else{
                JOptionPane.showMessageDialog(null, "Curso não incluido");
                return false;
            }
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro de SQL" + e.getMessage());
             return false;
        }
    }
    /*
    Método que altera um objeto na tabela através de um update que não utilizamos nesse projeto
    pois não fo solicitado no enunciado
    */
    public boolean alterar(Curso cur){
        String sql = "update cursos set nomeCurso = ?, periodo = ? where id = ?";
        
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            
            pst.setString(1, cur.getNomeCurso());
            pst.setString(2, cur.getPeriodo());
            
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "curso alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "curso não alterado");
                return false;
            }            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro de sql: " + e.getMessage());
                return false;
        }
        
    }
    //Método que exclui um objeto da tabela atraves de um delete.
  public boolean remover (Curso cur){
      String sql = "delete from cursos where id = ?";
      
      try {
          PreparedStatement pst = Conexao.getPreparedStatement(sql);
          pst.setInt(1, cur.getId());
          
          if(pst.executeUpdate() > 0){
              JOptionPane.showMessageDialog(null, "Curso excluido om sucesso");
              return true;
          }else{
              JOptionPane.showMessageDialog(null, "Curso não excluido");
              return false;
          }
          
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "erro de SQL: " + e.getMessage());
          return false;          
          
      }

  }    
  //Método que localiza um curso especifico atraves do id.
  public Curso localizar(Integer id){
      String sql = "select * from cursos where id = ?";
      Curso cur = new Curso();
      
      try {
          PreparedStatement pst = Conexao.getPreparedStatement(sql);
          pst.setInt(1, id);
          ResultSet rs = pst.executeQuery();
          while(rs.next()){
              cur.setId(rs.getInt("id"));
              cur.setNomeCurso(rs.getString("nomeCurso"));
              cur.setPeriodo(rs.getString("periodo"));
              return cur;
          }
      } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "erro de SQL: " + e.getMessage());
      }
        return null;
      
  } 
    
}
