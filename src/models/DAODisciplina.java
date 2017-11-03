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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus
 */
public class DAODisciplina {
    
    DAOCurso daocurso = new DAOCurso();
    
    //classe DAODisciplina para realizar ás operações referentes ao meu banco de dados
    public List<Disciplina> getLista(){
        
        String sql = "select * from disciplina";
        List<Disciplina> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    Disciplina dis = new Disciplina();
                    
                    dis.setId(rs.getInt("id"));
                    dis.setNomeDisciplina(rs.getString("nomeDisciplina"));
                    dis.setCargaHoraria(rs.getString("cargaHoraria"));
                    dis.setNumerodeVagas(rs.getInt("numeroVagas"));
                    dis.setCurso(daocurso.localizar(rs.getInt("curso")));
                    lista.add(dis);
                }
        }catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "Erro de SQL" + ex.getMessage());
        }
        return lista;
    }
    
   //Método que salva o objeto na abela caso seja escolhido a opção de incluir um novo objeto
    public boolean Salvar(Disciplina dis){
        if(dis.getId() == null){
            return incluir(dis);
        }else {
            return alterar(dis); 
        }
    }
        //Método que inclui um novo objeto na tabela atraves de um comando de insert
    public boolean incluir(Disciplina dis){
        String sql = "insert into disciplina (nomeDisciplina, cargaHoraria, numeroVagas, cursos) values (?, ?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            
            pst.setString(1, dis.getNomeDisciplina());
            pst.setString(2, dis.getCargaHoraria());
            pst.setInt(3, dis.getNumerodeVagas());
            pst.setInt(4, dis.getCurso().getId());
            
            if(pst.executeUpdate() > 0){
                   JOptionPane.showMessageDialog(null, "Disciplina incluida com sucesso");
                   return true;
            }else{
                JOptionPane.showMessageDialog(null, "disciplia não incluida");
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
    public boolean alterar(Disciplina dis){
        String sql = "update disciplina set nomeDisciplina = ?, cargaHoraria = ?, numerodeVagas = ?, curso = ? where id = ?";
        
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            
            pst.setString(1, dis.getNomeDisciplina());
            pst.setString(2, dis.getCargaHoraria());
            pst.setInt(3, dis.getNumerodeVagas());
            pst.setInt(4, dis.getCurso().getId());
            pst.setInt(5, dis.getId());
            
            
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "disciplina alterada com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "disciplina não alterada");
                return false;
            }            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro de sql: " + e.getMessage());
                return false;
        }
        
    }
     //Método que exclui um objeto da tabela atraves de um delete.
  public boolean remover (Disciplina dis){
      String sql = "delete from disciplina where id = ?";
      
      try {
          PreparedStatement pst = Conexao.getPreparedStatement(sql);
          pst.setInt(1, dis.getId());
          
          if(pst.executeUpdate() > 0){
              JOptionPane.showMessageDialog(null, "Disciplina excluida om sucesso");
              return true;
          }else{
              JOptionPane.showMessageDialog(null, "Disciplina não excluida");
              return false;
          }
          
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "erro de SQL: " + e.getMessage());
          return false;          
          
      }

  }    
    
}
