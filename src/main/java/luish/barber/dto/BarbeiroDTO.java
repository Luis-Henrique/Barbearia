/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import luish.barber.entidades.Barbeiro;
import luish.barber.entidades.Servico;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author luis
 */
public class BarbeiroDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;
    
    private List<Servico> servicos = new ArrayList<>();
    
    
     public BarbeiroDTO() {
    }

    public BarbeiroDTO(Barbeiro obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.servicos = obj.getServicos();

    }
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

}
