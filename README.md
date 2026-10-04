\# Assistência Técnica de Eletrônicos



Projeto desenvolvido em Java durante meus estudos em Desenvolvimento de Sistemas, com o objetivo de colocar em prática conceitos de Programação Orientada a Objetos (POO).



O sistema simula o fluxo básico de uma assistência técnica de eletrônicos, desde o cadastro do cliente e do equipamento até o diagnóstico, orçamento, reparo e encerramento da ordem de serviço.



\## Sobre o projeto



A proposta foi desenvolver um sistema capaz de representar o atendimento realizado por uma assistência técnica.



Durante o desenvolvimento, foram criadas classes responsáveis pelas principais entidades do sistema e pelos relacionamentos entre elas.



O fluxo implementado permite:



\- cadastrar clientes e seus equipamentos;

\- registrar uma ordem de serviço;

\- realizar e registrar um diagnóstico;

\- definir os serviços necessários e o orçamento;

\- registrar o reparo realizado;

\- atualizar o status da ordem de serviço;

\- encerrar o atendimento.



\## Estrutura do projeto



O sistema foi dividido nas seguintes classes:



\### Cliente

Armazena os dados do cliente e seus equipamentos.



\### Equipamento

Representa o equipamento recebido pela assistência técnica, incluindo informações como tipo, marca, modelo e problema relatado.



\### Diagnostico

Registra o diagnóstico realizado no equipamento.



\### Servico

Representa os serviços necessários e realizados durante o reparo.



\### OrdemServico

Centraliza o fluxo do atendimento, relacionando cliente, equipamento, diagnóstico, serviços, orçamento e status da ordem.



\### Tecnico

Representa o profissional responsável pelo diagnóstico e pelo registro dos serviços realizados.



\### Main

Responsável pela execução e demonstração do funcionamento do sistema.



\## Conceitos praticados



Durante o desenvolvimento deste projeto, trabalhei principalmente com:



\- Programação Orientada a Objetos;

\- classes e objetos;

\- atributos e métodos;

\- construtores;

\- encapsulamento;

\- relacionamentos entre classes;

\- ArrayList;

\- organização e separação de responsabilidades.



\## Tecnologias utilizadas



\- Java

\- Eclipse IDE

\- Git

\- GitHub



\## Estrutura de pastas



```text

LojaEletronicos/

├── src/

│   ├── assistenciatecnica/

│   │   ├── Cliente.java

│   │   ├── Diagnostico.java

│   │   ├── Equipamento.java

│   │   ├── Main.java

│   │   ├── OrdemServico.java

│   │   ├── Servico.java

│   │   └── Tecnico.java

│   └── module-info.java

└── .gitignore

```



\## Contexto



Este projeto faz parte da minha formação em Desenvolvimento de Sistemas e representa uma das minhas primeiras experiências desenvolvendo um sistema em Java utilizando Programação Orientada a Objetos.



Além da implementação, o projeto também foi utilizado para praticar modelagem de classes, organização do código e versionamento com Git e GitHub.



\---



Desenvolvido por \*\*Gabriela Oliveira\*\* durante meus estudos em Desenvolvimento de Sistemas.

