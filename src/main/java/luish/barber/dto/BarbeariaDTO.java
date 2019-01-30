/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.dto;

import java.io.Serializable;
import java.util.ArrayList;
import luish.barber.entidades.Barbearia;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author luis
 */
public class BarbeariaDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String rua;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String numero;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String estado;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cidade;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 11, max = 11, message = "Telefone inválido")
    private String telefone1;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 11, max = 11, message = "Telefone inválido")
    private String telefone2;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 11, max = 11, message = "Telefone inválido")
    private String telefone3;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 11, max = 11, message = "Telefone inválido")
    private String telefone4;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String horaSegunda;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String horaTerca;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String horaQuarta;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String horaQuinta;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String horaSexta;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String horaSabado;

    private ArrayList<String> tel = new ArrayList<>();

    public BarbeariaDTO() {
    }

    public BarbeariaDTO(Barbearia obj) {
        this.id = obj.getId();
        this.rua = obj.getRua();
        this.numero = obj.getNumero();
        this.estado = obj.getEstado();
        this.cidade = obj.getCidade();
        this.cidade = obj.getCidade();

        tel.addAll(obj.getTelefones());
        for (int i = 0; i < tel.size(); i++) {
            
            this.telefone1 = tel.get(0);
            this.telefone2 = tel.get(1);
            this.telefone3 = tel.get(2);
            this.telefone4 = tel.get(3);
           
        }

        this.horaSegunda = obj.getHoraSegunda();

        this.horaTerca = obj.getHoraTerca();

        this.horaQuarta = obj.getHoraQuarta();

        this.horaQuinta = obj.getHoraQuinta();

        this.horaSexta = obj.getHoraSexta();

        this.horaSabado = obj.getHoraSabado();
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }
    
     public String getTelefone4() {
        return telefone4;
    }

    public void setTelefone4(String telefone4) {
        this.telefone4 = telefone4;
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

}
