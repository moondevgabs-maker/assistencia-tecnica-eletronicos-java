package assistenciatecnica;

public class Tecnico {
	private static int proxId = 1;
	
    private int id = proxId++;
    private String nome;
    private String especialidade;

    public Tecnico() {
    }

    public Tecnico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
    public void realizarDiagnostico(OrdemServico os, Diagnostico diagnostico) {
        os.registrarDiagnostico(diagnostico);
    }

    public void definirServicosEOrcamento(OrdemServico os, Servico servico, double orcamento) {
        os.definirServicosEOrcamento(servico, orcamento);
    }

    public void registrarReparo(OrdemServico os, Servico servico) {
        os.registrarReparo(servico);
    }
}