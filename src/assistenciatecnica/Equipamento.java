package assistenciatecnica;

import java.util.ArrayList;

public class Equipamento {

    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private String problemaRelatado;
    private Cliente cliente;

    private ArrayList<OrdemServico> ordensServico = new ArrayList<>();

    public Equipamento() {
    }

    public Equipamento(int id, String tipo, String marca, String modelo,
            String problemaRelatado, Cliente cliente) {

        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.problemaRelatado = problemaRelatado;
        this.cliente = cliente;
    }

    public void atualizarDados(String tipo, String marca, String modelo,
            String problemaRelatado) {

        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.problemaRelatado = problemaRelatado;
    }

    public void adicionarOrdemServico(OrdemServico ordemServico) {
        ordensServico.add(ordemServico);
    }
}