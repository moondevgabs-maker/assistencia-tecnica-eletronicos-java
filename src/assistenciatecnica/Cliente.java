package assistenciatecnica;

import java.util.ArrayList;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
	public Cliente() {
	}

	public Cliente(int id, String nome, String cpf, String telefone, String email) {
	    this.id = id;
	    this.nome = nome;
	    this.cpf = cpf;
	    this.telefone = telefone;
	    this.email = email;
	}
	public void atualizarDados(String nome, String telefone, String email) {
	    this.nome = nome;
	    this.telefone = telefone;
	    this.email = email;
	}
	public void adicionarEquipamento(Equipamento equipamento) {
	    equipamentos.add(equipamento);
	}
}
