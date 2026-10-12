package assistenciatecnica;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdemServico {
	private static int proxId = 1;
	
    private int id = proxId++;
    private LocalDate dataAbertura;
    private String status;
    private Equipamento equipamento;
    private Diagnostico diagnostico;
    private double orcamento;
    private boolean clienteInformadoOrcamento;
    private LocalDate dataConclusao;

    private ArrayList<Servico> servicos = new ArrayList<>();

    public OrdemServico() {
    }

    public OrdemServico(LocalDate dataAbertura, String status,
            double orcamento, Equipamento equipamento) {
 
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.orcamento = orcamento;
        this.equipamento = equipamento;
    }
    
    public int getId() {
        return id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public boolean isClienteInformadoOrcamento() {
        return clienteInformadoOrcamento;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void atualizarStatus(String status) {
        this.status = status;

        if (status.equalsIgnoreCase("Encerrada")) {
            this.dataConclusao = LocalDate.now();
        }
    }

    public void registrarDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void definirServicosEOrcamento(Servico servico, double orcamento) {
        servicos.add(servico);
        this.orcamento = orcamento;
    }

    public void informarClienteOrcamento() {
        this.clienteInformadoOrcamento = true;
    }

    public void registrarReparo(Servico servico) {
        servico.realizarServico();
    }
    
    public String consultarHistorico() {
        String historico;

        if (diagnostico == null) {
            historico = "Diagnostico: Ainda não registrado"
                    + "\nObservacoes do diagnostico: Ainda não registradas";
        } else {
            historico = "Diagnostico: " + diagnostico.getDescricao()
                    + "\nObservacoes do diagnostico: " + diagnostico.getObservacoes();
        }

        historico += "\nOrcamento: R$ " + orcamento
                + "\nCliente informado sobre orcamento: "
                + (clienteInformadoOrcamento ? "Sim" : "Nao")
                + "\nStatus: " + status;

        if (servicos.isEmpty()) {
            historico += "\nServicos: Ainda não registrados";
        } else {
            for (Servico servico : servicos) {
                historico += "\nServico: " + servico.getDescricao()
                        + "\nRealizado: "
                        + (servico.isRealizado() ? "Sim" : "Nao");
            }
        }

        return historico;
    }
}