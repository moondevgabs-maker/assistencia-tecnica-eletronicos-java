package assistenciatecnica;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdemServico {

    private int id;
    private LocalDate dataAbertura;
    private String status;
    private Equipamento equipamento;
    private Diagnostico diagnostico;
    private String servicosNecessarios;
    private String servicosRealizados;
    private double orcamento;
    private boolean clienteInformadoOrcamento;
    private LocalDate dataConclusao;
    private String observacoes;

    private ArrayList<Servico> servicos = new ArrayList<>();

    public OrdemServico() {
    }

    public OrdemServico(int id, LocalDate dataAbertura, String status,
            double orcamento, Equipamento equipamento) {

        this.id = id;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.orcamento = orcamento;
        this.equipamento = equipamento;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public void registrarDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void definirServicosEOrcamento(String servicosNecessarios, double orcamento) {
        this.servicosNecessarios = servicosNecessarios;
        this.orcamento = orcamento;
    }

    public void informarClienteOrcamento() {
        this.clienteInformadoOrcamento = true;
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public void registrarReparo(String servicosRealizados) {
        this.servicosRealizados = servicosRealizados;
        this.dataConclusao = LocalDate.now();
    }

    public String consultarHistorico() {

        String historico = "Diagnostico: " + diagnostico.getDescricao()
                + " | Servicos necessarios: " + servicosNecessarios
                + " | Servicos realizados: " + servicosRealizados
                + " | Orcamento: R$ " + orcamento
                + " | Cliente informado sobre orcamento: "
                + (clienteInformadoOrcamento ? "Sim" : "Nao")
                + " | Status: " + status;

        for (Servico servico : servicos) {
            historico += " | Servico: " + servico.getDescricao();
        }

        return historico;
    }
}