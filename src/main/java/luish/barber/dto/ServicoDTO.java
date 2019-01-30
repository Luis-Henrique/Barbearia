/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.dto;

import luish.barber.entidades.Servico;

/**
 *
 * @author luis
 */
public class ServicoDTO {
    
    private Integer id;
    private String tipo;
    private double valor;
    private double valorCartao;
    
      public ServicoDTO() {
    }

    public ServicoDTO(Servico obj) {
        this.id = obj.getId();
        this.tipo = obj.getTipo().getDescricao();
        this.valor = obj.getValor();
        this.valorCartao = obj.getValorCartao();
    }   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
     public double getValorCartao() {
        return valorCartao;
    }

    public void setValorCartao(double valorCartao) {
        this.valorCartao = valorCartao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
