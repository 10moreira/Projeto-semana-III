//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M3LPBD

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Mateus S. Moreira

//*****************************************************
package models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mateus
 */
//Classe de modelo Curso
public class Curso implements Serializable{
    
    private Integer id;
    private String nomeCurso;
    private String periodo;

   
      public Curso() {
    }
     
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nomeCurso
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * @param nomeCurso the nomeCurso to set
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

  
    @Override
    public String toString() {
        return nomeCurso;
    }

}
