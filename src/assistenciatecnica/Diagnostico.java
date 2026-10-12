package assistenciatecnica;

import java.time.LocalDate;

public class Diagnostico {
	private static int proxId = 1;
	
    private int id = proxId++;
    private String descricao;
    private LocalDate data;
    private String observacoes;

    public Diagnostico() {
    }
    public Diagnostico(String descricao, String observacoes) {
        this.descricao = descricao;
        this.data = LocalDate.now();
        this.observacoes = observacoes;
    }

    public String getDescricao() {
        return descricao;
    }
    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getObservacoes() {
        return observacoes;
    }
}