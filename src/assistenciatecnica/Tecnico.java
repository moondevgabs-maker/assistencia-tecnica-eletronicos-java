package assistenciatecnica;

public class Tecnico {

    private int id;
    private String nome;
    private String especialidade;

    public Tecnico() {
    }

    public Tecnico(int id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void realizarDiagnostico(OrdemServico os, Diagnostico diagnostico) {
        os.registrarDiagnostico(diagnostico);
    }

    public void definirServicosEOrcamento(OrdemServico os, String servicosNecessarios, double orcamento) {
        os.definirServicosEOrcamento(servicosNecessarios, orcamento);
    }

    public void registrarReparo(OrdemServico os, String servicosRealizados) {
        os.registrarReparo(servicosRealizados);
    }
}