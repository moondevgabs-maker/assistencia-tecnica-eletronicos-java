package assistenciatecnica;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        ArrayList<OrdemServico> ordensServico = new ArrayList<>();

        Tecnico tecnico1 = new Tecnico(
                "Carlos",
                "Manutenção de eletrônicos"
        );

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== ASSISTÊNCIA TÉCNICA =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar equipamento");
            System.out.println("3 - Abrir ordem de serviço");
            System.out.println("4 - Registrar diagnóstico e orçamento");
            System.out.println("5 - Registrar reparo");
            System.out.println("6 - Consultar ordem de serviço");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {

                System.out.println("\n--- CADASTRO DO CLIENTE ---");

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("CPF: ");
                String cpf = scanner.nextLine();

                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();

                System.out.print("E-mail: ");
                String email = scanner.nextLine();

                Cliente cliente = new Cliente(
                        nome,
                        cpf,
                        telefone,
                        email
                );

                clientes.add(cliente);

                System.out.println("\nCliente cadastrado com sucesso!");
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("E-mail: " + cliente.getEmail());
            }

            else if (opcao == 2) {

                if (clientes.isEmpty()) {
                    System.out.println("\nNenhum cliente cadastrado.");
                    System.out.println("Cadastre um cliente antes de cadastrar um equipamento.");
                } else {

                    System.out.println("\n--- CLIENTES CADASTRADOS ---");

                    for (Cliente cliente : clientes) {
                        System.out.println(
                                "ID: " + cliente.getId()
                                + " | Nome: " + cliente.getNome()
                                + " | CPF: " + cliente.getCpf()
                        );
                    }

                    System.out.print("\nDigite o ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente clienteSelecionado = null;

                    for (Cliente cliente : clientes) {
                        if (cliente.getId() == idCliente) {
                            clienteSelecionado = cliente;
                        }
                    }

                    if (clienteSelecionado == null) {
                        System.out.println("\nCliente não encontrado.");
                    } else {

                        System.out.println("\n--- CADASTRO DO EQUIPAMENTO ---");

                        System.out.print("Tipo: ");
                        String tipo = scanner.nextLine();

                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();

                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();

                        System.out.print("Problema relatado: ");
                        String problemaRelatado = scanner.nextLine();

                        Equipamento equipamento = new Equipamento(
                                tipo,
                                marca,
                                modelo,
                                problemaRelatado,
                                clienteSelecionado
                        );

                        equipamentos.add(equipamento);
                        clienteSelecionado.adicionarEquipamento(equipamento);

                        System.out.println("\nEquipamento cadastrado com sucesso!");
                        System.out.println("ID: " + equipamento.getId());
                        System.out.println("Tipo: " + equipamento.getTipo());
                        System.out.println("Marca: " + equipamento.getMarca());
                        System.out.println("Modelo: " + equipamento.getModelo());
                        System.out.println("Problema relatado: "
                                + equipamento.getProblemaRelatado());
                        System.out.println("Cliente: "
                                + equipamento.getCliente().getNome());
                    }
                }
            }

            else if (opcao == 3) {

                if (equipamentos.isEmpty()) {
                    System.out.println("\nNenhum equipamento cadastrado.");
                    System.out.println("Cadastre um equipamento antes de abrir uma OS.");
                } else {

                    System.out.println("\n--- EQUIPAMENTOS CADASTRADOS ---");

                    for (Equipamento equipamento : equipamentos) {
                        System.out.println(
                                "ID: " + equipamento.getId()
                                + " | " + equipamento.getTipo()
                                + " | " + equipamento.getMarca()
                                + " | " + equipamento.getModelo()
                                + " | Cliente: "
                                + equipamento.getCliente().getNome()
                        );
                    }

                    System.out.print("\nDigite o ID do equipamento: ");
                    int idEquipamento = scanner.nextInt();
                    scanner.nextLine();

                    Equipamento equipamentoSelecionado = null;

                    for (Equipamento equipamento : equipamentos) {
                        if (equipamento.getId() == idEquipamento) {
                            equipamentoSelecionado = equipamento;
                        }
                    }

                    if (equipamentoSelecionado == null) {
                        System.out.println("\nEquipamento não encontrado.");
                    } else {

                        OrdemServico ordem = new OrdemServico(
                                LocalDate.now(),
                                "Aguardando diagnóstico",
                                0.0,
                                equipamentoSelecionado
                        );

                        ordensServico.add(ordem);
                        equipamentoSelecionado.adicionarOrdemServico(ordem);

                        System.out.println("\nOrdem de Serviço criada com sucesso!");
                        System.out.println("ID da OS: " + ordem.getId());
                        System.out.println("Data de abertura: "
                                + ordem.getDataAbertura());
                        System.out.println("Status: " + ordem.getStatus());
                        System.out.println("Equipamento: "
                                + equipamentoSelecionado.getTipo() + " "
                                + equipamentoSelecionado.getMarca() + " "
                                + equipamentoSelecionado.getModelo());
                        System.out.println("Cliente: "
                                + equipamentoSelecionado.getCliente().getNome());
                    }
                }
            }

            else if (opcao == 4) {

                if (ordensServico.isEmpty()) {
                    System.out.println("\nNenhuma ordem de serviço cadastrada.");
                } else {

                    System.out.println("\n--- ORDENS DE SERVIÇO ---");

                    for (OrdemServico ordem : ordensServico) {
                        System.out.println(
                                "OS: " + ordem.getId()
                                + " | Cliente: "
                                + ordem.getEquipamento().getCliente().getNome()
                                + " | Equipamento: "
                                + ordem.getEquipamento().getTipo()
                                + " " + ordem.getEquipamento().getModelo()
                                + " | Status: " + ordem.getStatus()
                        );
                    }

                    System.out.print("\nDigite o ID da OS: ");
                    int idOS = scanner.nextInt();
                    scanner.nextLine();

                    OrdemServico ordemSelecionada = null;

                    for (OrdemServico ordem : ordensServico) {
                        if (ordem.getId() == idOS) {
                            ordemSelecionada = ordem;
                        }
                    }

                    if (ordemSelecionada == null) {
                        System.out.println("\nOrdem de serviço não encontrada.");
                    } else {

                        System.out.println("\n--- REGISTRO DO DIAGNÓSTICO ---");

                        System.out.print("Descrição do diagnóstico: ");
                        String descricaoDiagnostico = scanner.nextLine();

                        System.out.print("Observações do diagnóstico: ");
                        String observacoesDiagnostico = scanner.nextLine();

                        Diagnostico diagnostico = new Diagnostico(
                                descricaoDiagnostico,
                                observacoesDiagnostico
                        );

                        tecnico1.realizarDiagnostico(
                                ordemSelecionada,
                                diagnostico
                        );

                        System.out.println("\n--- DEFINIÇÃO DO SERVIÇO E ORÇAMENTO ---");

                        System.out.print("Serviço necessário: ");
                        String descricaoServico = scanner.nextLine();

                        System.out.print("Valor do orçamento: R$ ");
                        double valorOrcamento = scanner.nextDouble();

                        while (valorOrcamento < 0) {

                            System.out.println(
                                    "Valor inválido. O orçamento não pode ser negativo."
                            );

                            System.out.print("Valor do orçamento: R$ ");
                            valorOrcamento = scanner.nextDouble();
                        }

                        scanner.nextLine();

                        Servico servico = new Servico(
                                descricaoServico,
                                valorOrcamento
                        );

                        tecnico1.definirServicosEOrcamento(
                                ordemSelecionada,
                                servico,
                                valorOrcamento
                        );

                        ordemSelecionada.atualizarStatus(
                                "Aguardando aprovação"
                        );

                        System.out.print(
                                "Cliente aprovou o orçamento? (S/N): "
                        );

                        String respostaOrcamento = scanner.nextLine();

                        while (!respostaOrcamento.equalsIgnoreCase("S")
                                && !respostaOrcamento.equalsIgnoreCase("N")) {

                            System.out.println(
                                    "Opção inválida. Digite apenas S ou N."
                            );

                            System.out.print(
                                    "Cliente aprovou o orçamento? (S/N): "
                            );

                            respostaOrcamento = scanner.nextLine();
                        }

                        ordemSelecionada.informarClienteOrcamento();

                        if (respostaOrcamento.equalsIgnoreCase("S")) {

                            ordemSelecionada.atualizarStatus("Em reparo");

                            System.out.println(
                                    "\nOrçamento aprovado."
                            );

                            System.out.println(
                                    "Status da OS: "
                                    + ordemSelecionada.getStatus()
                            );

                        } else {

                            System.out.println(
                                    "\nOrçamento não aprovado."
                            );

                            System.out.println(
                                    "Status da OS: "
                                    + ordemSelecionada.getStatus()
                            );
                        }
                    }
                }
            }

            else if (opcao == 5) {

                if (ordensServico.isEmpty()) {
                    System.out.println("\nNenhuma ordem de serviço cadastrada.");
                } else {

                    System.out.println("\n--- ORDENS DE SERVIÇO ---");

                    for (OrdemServico ordem : ordensServico) {
                        System.out.println(
                                "OS: " + ordem.getId()
                                + " | Cliente: "
                                + ordem.getEquipamento().getCliente().getNome()
                                + " | Status: " + ordem.getStatus()
                        );
                    }

                    System.out.print("\nDigite o ID da OS: ");
                    int idOS = scanner.nextInt();
                    scanner.nextLine();

                    OrdemServico ordemSelecionada = null;

                    for (OrdemServico ordem : ordensServico) {
                        if (ordem.getId() == idOS) {
                            ordemSelecionada = ordem;
                        }
                    }

                    if (ordemSelecionada == null) {

                        System.out.println("\nOrdem de serviço não encontrada.");

                    } else if (!ordemSelecionada.getStatus()
                            .equalsIgnoreCase("Em reparo")) {

                        System.out.println(
                                "\nEsta ordem de serviço não está em reparo."
                        );

                    } else if (ordemSelecionada.getServicos().isEmpty()) {

                        System.out.println(
                                "\nNenhum serviço foi definido para esta OS."
                        );

                    } else {

                        Servico servico = ordemSelecionada
                                .getServicos()
                                .get(0);

                        tecnico1.registrarReparo(
                                ordemSelecionada,
                                servico
                        );

                        ordemSelecionada.atualizarStatus("Encerrada");

                        System.out.println("\nReparo registrado com sucesso!");
                        System.out.println(
                                "Status da OS: "
                                + ordemSelecionada.getStatus()
                        );
                    }
                }
            }

            else if (opcao == 6) {

                if (ordensServico.isEmpty()) {

                    System.out.println(
                            "\nNenhuma ordem de serviço cadastrada."
                    );

                } else {

                    System.out.println("\n--- ORDENS DE SERVIÇO ---");

                    for (OrdemServico ordem : ordensServico) {
                        System.out.println(
                                "OS: " + ordem.getId()
                                + " | Cliente: "
                                + ordem.getEquipamento().getCliente().getNome()
                                + " | Equipamento: "
                                + ordem.getEquipamento().getTipo()
                                + " " + ordem.getEquipamento().getModelo()
                                + " | Status: " + ordem.getStatus()
                        );
                    }

                    System.out.print("\nDigite o ID da OS: ");
                    int idOS = scanner.nextInt();
                    scanner.nextLine();

                    OrdemServico ordemSelecionada = null;

                    for (OrdemServico ordem : ordensServico) {
                        if (ordem.getId() == idOS) {
                            ordemSelecionada = ordem;
                        }
                    }

                    if (ordemSelecionada == null) {

                        System.out.println(
                                "\nOrdem de serviço não encontrada."
                        );

                    } else {

                        System.out.println(
                                "\n--- HISTÓRICO DA ORDEM DE SERVIÇO ---"
                        );

                        System.out.println(
                                "OS: " + ordemSelecionada.getId()
                        );

                        System.out.println(
                                "Cliente: "
                                + ordemSelecionada
                                        .getEquipamento()
                                        .getCliente()
                                        .getNome()
                        );

                        System.out.println(
                                "Equipamento: "
                                + ordemSelecionada
                                        .getEquipamento()
                                        .getTipo()
                                + " "
                                + ordemSelecionada
                                        .getEquipamento()
                                        .getMarca()
                                + " "
                                + ordemSelecionada
                                        .getEquipamento()
                                        .getModelo()
                        );

                        System.out.println(
                                ordemSelecionada.consultarHistorico()
                        );

                        if (ordemSelecionada.getDataConclusao() != null) {
                            System.out.println(
                                    "Data de conclusão: "
                                    + ordemSelecionada.getDataConclusao()
                            );
                        }
                    }
                }
            }

            else if (opcao == 0) {

                System.out.println("\nSistema encerrado.");

            }

            else {

                System.out.println("\nOpção inválida.");
            }
        }

        scanner.close();
    }
}