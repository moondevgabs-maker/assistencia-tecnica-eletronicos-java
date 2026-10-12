package assistenciatecnica;

import java.time.LocalDate;

public class Servico {
	private static int proxId = 1;
	
    private int id = proxId++;
    private String descricao;
    private double valor;
    private boolean realizado;
    private LocalDate dataRealizacao;

    public Servico() {
    }

    public Servico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.realizado = false;
        this.dataRealizacao = null;
    }

    public boolean isRealizado() {
        return realizado;
    }
    public String getDescricao() {
        return descricao;
       
    }
    
    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }
    public void realizarServico() {
        this.realizado = true;
        this.dataRealizacao = LocalDate.now();
    }
}