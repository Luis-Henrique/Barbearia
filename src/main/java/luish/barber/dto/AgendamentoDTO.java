/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import luish.barber.entidades.Agendamento;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author luis
 */
public class AgendamentoDTO implements Serializable{
    
    private Date data;
    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer id_cliente;
    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer id_barbeiro;
    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer id_servico;
    
   
    public AgendamentoDTO() {
        
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_barbeiro() {
        return id_barbeiro;
    }

    public void setId_barbeiro(Integer id_barbeiro) {
        this.id_barbeiro = id_barbeiro;
    }

    public Integer getId_servico() {
        return id_servico;
    }

    public void setId_servico(Integer id_servico) {
        this.id_servico = id_servico;
    }
    
    
    
}
