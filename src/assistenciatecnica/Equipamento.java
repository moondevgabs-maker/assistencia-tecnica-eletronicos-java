package assistenciatecnica;

import java.util.ArrayList;
public class Equipamento {
	private static int proxId = 1;
	
    private int id = proxId++;
    private String tipo;
    private String marca;
    private String modelo;
    private String problemaRelatado;
    private Cliente cliente;
    
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getProblemaRelatado() {
        return problemaRelatado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<OrdemServico> getOrdensServico() {
        return ordensServico;
    }

    private ArrayList<OrdemServico> ordensServico = new ArrayList<>();

    public Equipamento() {
    }

    public Equipamento(String tipo, String marca, String modelo,
            String problemaRelatado, Cliente cliente) {

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