/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author luis
 */
@Entity
public class Agendamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "idBarbeiro")
    private Barbeiro barbeiro;
    
    
    @ManyToOne
    @JoinColumn(name = "idServico")
    private Servico servico;

    public Agendamento() {
    }

    public Agendamento(Integer id, Date data, Cliente cliente, Barbeiro barbeiro, Servico servico) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servico = servico;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    
}
