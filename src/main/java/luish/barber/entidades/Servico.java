/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import luish.barber.entidades.enuns.TipoServico;

/**
 *
 * @author luis
 */
@Entity
public class Servico implements Serializable {
    
    @JsonIgnore
    @ManyToMany(mappedBy = "servicos")
    private List<Barbeiro> barbeiros = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    private Integer tipo;
    private Double valor;
    private Double valorCartao;

    public Servico(Integer id, TipoServico tipo, Double valor) {
        this.id = id;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.valor = valor;
        this.valorCartao = valor + 2;
    }

    public Servico() {
    }

    public List<Barbeiro> getBarbeiros() {
        return barbeiros;
    }

    public void setBarbeiros(List<Barbeiro> barbeiros) {
        this.barbeiros = barbeiros;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoServico getTipo() {
        return TipoServico.toEnum(tipo);
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo.getCod();
    }
   

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Double getValorCartao() {
        return valorCartao;
    }

    public void setValorCartao(Double valorCartao) {
        this.valorCartao = valorCartao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    

    
}
