package assistenciatecnica;

import java.time.LocalDate;

public class Servico {

    private int id;
    private String descricao;
    private double valor;
    private boolean realizado;
    private LocalDate dataRealizacao;

    public Servico() {
    }

    public Servico(int id, String descricao, double valor, boolean realizado, LocalDate dataRealizacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.realizado = realizado;
        this.dataRealizacao = dataRealizacao;
    }

    public boolean isRealizado() {
        return realizado;
    }
    public String getDescricao() {
        return descricao;
    }
    public void realizarServico() {
        this.realizado = true;
        this.dataRealizacao = LocalDate.now();
    }
}