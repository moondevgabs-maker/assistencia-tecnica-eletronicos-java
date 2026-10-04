package assistenciatecnica;

import java.time.LocalDate;

public class Diagnostico {

    private int id;
    private String descricao;
    private LocalDate data;
    private String observacoes;

    public Diagnostico() {
    }

    public Diagnostico(int id, String descricao, LocalDate data, String observacoes) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.observacoes = observacoes;
    }

    public String getDescricao() {
        return descricao;
    }
}