/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.entidades.enuns;

/**
 *
 * @author luis
 */
public enum TipoServico {

    CORTE_TESOURA_DEGRADE(1, "Corte de tesoura e degrade"),
    CORTE_TESOURA_BARBA(2, "Corte de tesoura e barba"),
    CORTE_MAQUINA(3, "Corte de máquina"),
    CORTE_MAQUINA_DEGRADE(4, "Corte de máquina e degrade"),
    CORTE_BARBA_MAQUINA(5, "Corte barba de máquina"),
    CORTE_BARBA_NAVALHA(6, "Corte barba de navalha");

    private int cod;
    private String descricao;

    private TipoServico(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoServico toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TipoServico x : TipoServico.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo inválido" + cod);
    }

}
