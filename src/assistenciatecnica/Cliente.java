package assistenciatecnica;

import java.util.ArrayList;

public class Cliente {
	private static int proxId = 1;
	
    private int id = proxId++;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
 
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }
    
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, String email) {
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
