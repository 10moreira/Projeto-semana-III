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
//Classe de modelo Disciplina
public class Disciplina implements Serializable{
    
    private Integer id;
    private String nomeDisciplina;
    private String cargaHoraria;
    private Integer numerodeVagas;
    private Curso curso;

    public Disciplina() {
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
     * @return the nomeDisciplina
     */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    /**
     * @param nomeDisciplina the nomeDisciplina to set
     */
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * @return the cargaHoraria
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the numerodeVagas
     */
    public Integer getNumerodeVagas() {
        return numerodeVagas;
    }

    /**
     * @param numerodeVagas the numerodeVagas to set
     */
    public void setNumerodeVagas(Integer numerodeVagas) {
        this.numerodeVagas = numerodeVagas;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
