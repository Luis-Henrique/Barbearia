/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author luis
 */
@Entity
public class Barbearia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rua;
    private String numero;
    private String estado;
    private String cidade;

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    private String horaSegunda;
    private String horaTerca;
    private String horaQuarta;
    private String horaQuinta;
    private String horaSexta;
    private String horaSabado;

    public Barbearia() {
    }

    public Barbearia(Integer id, String rua, String numero, String estado, String cidade, String horaSegunda,
            String horaTerca, String horaQuarta, String horaQuinta, String horaSexta, String horaSabado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.estado = estado;
        this.cidade = cidade;
        this.horaSegunda = horaSegunda;
        this.horaTerca = horaTerca;
        this.horaQuarta = horaQuarta;
        this.horaQuinta = horaQuinta;
        this.horaSexta = horaSexta;
        this.horaSabado = horaSabado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public String getHoraSegunda() {
        return horaSegunda;
    }

    public void setHoraSegunda(String horaSegunda) {
        this.horaSegunda = horaSegunda;
    }

    public String getHoraTerca() {
        return horaTerca;
    }

    public void setHoraTerca(String horaTerca) {
        this.horaTerca = horaTerca;
    }

    public String getHoraQuarta() {
        return horaQuarta;
    }

    public void setHoraQuarta(String horaQuarta) {
        this.horaQuarta = horaQuarta;
    }

    public String getHoraQuinta() {
        return horaQuinta;
    }

    public void setHoraQuinta(String horaQuinta) {
        this.horaQuinta = horaQuinta;
    }

    public String getHoraSexta() {
        return horaSexta;
    }

    public void setHoraSexta(String horaSexta) {
        this.horaSexta = horaSexta;
    }

    public String getHoraSabado() {
        return horaSabado;
    }

    public void setHoraSabado(String horaSabado) {
        this.horaSabado = horaSabado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Barbearia other = (Barbearia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
