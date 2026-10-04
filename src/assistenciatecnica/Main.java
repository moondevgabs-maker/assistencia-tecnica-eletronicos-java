package assistenciatecnica;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(
            1,
            "Gabriela",
            "123.456.789-00",
            "31999999999",
            "gabriela@email.com"
        );

        Equipamento equipamento1 = new Equipamento(
            1,
            "Notebook",
            "Dell",
            "Inspiron",
            "Não liga",
            cliente1
        );

        cliente1.adicionarEquipamento(equipamento1);

        OrdemServico ordem1 = new OrdemServico(
            1,
            LocalDate.now(),
            "Aguardando diagnóstico",
            0.0,
            equipamento1
        );

        equipamento1.adicionarOrdemServico(ordem1);

        Tecnico tecnico1 = new Tecnico(
            1,
            "Carlos",
            "Manutenção de notebooks"
        );

        Diagnostico diagnostico1 = new Diagnostico(
            1,
            "Problema na fonte de alimentação",
            LocalDate.now(),
            "Fonte não fornece energia corretamente"
        );

        tecnico1.realizarDiagnostico(
            ordem1,
            diagnostico1
        );

        tecnico1.definirServicosEOrcamento(
            ordem1,
            "Troca da fonte de alimentação",
            250.00
        );

        ordem1.atualizarStatus("Aguardando aprovação");

        ordem1.informarClienteOrcamento();

        ordem1.atualizarStatus("Em reparo");

        Servico servico1 = new Servico(
            1,
            "Troca da fonte de alimentação",
            250.00,
            false,
            null
        );

        ordem1.adicionarServico(servico1);

        servico1.realizarServico();

        tecnico1.registrarReparo(
            ordem1,
            "Troca da fonte de alimentação"
        );

        ordem1.atualizarStatus("Encerrada");

        System.out.println(ordem1.consultarHistorico());
    }
}