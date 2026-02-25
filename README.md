Proposta de Projeto Final de POO ( 3 0 Pontos)

Grupo de 8 alunos

**1. Desenvolvimento de um Sistema Orientado a Objetos (Escolha Livre)**

Os alunos deverão formar grupos e escolher um problema do mundo real para modelar
e desenvolver um sistema orientado a objetos.

**Critérios para um bom Estudo de Caso:**

- **Diversidade de Entidades:** O sistema deve conter pelo menos 3 a 5 tipos de
    "atores" ou entidades principais com papéis diferentes (ex: Administrador,
    Cliente, Funcionário; Pedido, Produto, ItemDePedido).
- **Relacionamentos Complexos:** As entidades devem se relacionar de maneiras
    variadas, permitindo o uso de Herança, Composição e Agregação.
- **Variedade de Comportamentos:** Deve haver a necessidade de
    comportamentos polimórficos (ex: diferentes tipos de produtos com métodos
    de cálculo de preço distintos; diferentes formas de pagamento).
- **Necessidade de Persistência:** Os dados gerados pelo sistema (cadastros,
    transações, etc.) devem precisar ser salvos e recuperados.
- **Interação com Usuário:** O sistema deve ser interativo, justificando a criação de
    uma interface gráfica utilizando a interface javax.swing.

**Sugestões de Temas para os Alunos:**

- **Sistema de Biblioteca:** Gerenciamento de acervo, usuários (leitores,
    bibliotecários), empréstimos e devoluções.
- **Sistema de Clínica Médica (HealthSys):** Gerenciamento de pacientes, corpo
    clínico (médicos, recepcionistas), agendamentos de consultas e prontuários
    eletrônicos.
- **E-commerce Simplificado:** Gestão de produtos (físicos, digitais), clientes,
    carrinho de compras e pedidos.
- **Sistema de Gerenciamento Hoteleiro:** Controle de quartos, hóspedes,
    reservas e serviços.
- **Aplicativo de Banco Digital:** Modelagem de contas (corrente, poupança),
    clientes, transações (depósito, saque, transferência).
- **Jogo de RPG Simples:** Criação de personagens (guerreiro, mago), monstros,
    sistema de batalha por turnos e inventário de itens.


**1.2. Implementação usando POO**

A implementação deve ser um reflexo claro da modelagem orientada a objetos e deve,
obrigatoriamente, aplicar de forma justificável os conceitos listados. A linguagem
recomendada é Java, devido à aderência aos conceitos e às bibliotecas exigidas.

**Exemplo genérico de aplicação:**

- **Herança:** Criar uma classe base Pessoa e especializações como Cliente e
    Funcionario.
- **Classe Abstrata e Polimorfismo:** Uma classe abstrata Transacao com um
    método executar(), e classes concretas como Deposito e Saque que
    implementam o método de formas diferentes.
- **Interface:** Uma interface visual de interação do usuário.
- **Composição:** Uma classe Pedido é composta por uma lista de objetos
    ItemDePedido. Se o Pedido for excluído, os itens dele também são.
- **Tratamento de Exceções:** Criar exceções customizadas como
    SaldoInsuficienteException ou ProdutoNaoEncontradoException.

**1.3. Documentação do Sistema (Relatório em PDF e com regras ABNT)**

estrutura sugerida:

- **Capa, Introdução** (contextualizando o problema escolhido).
- **Modelagem Conceitual** (com Diagrama de Classes UML específico do projeto).
- **Aplicação dos Conceitos de POO** (seção detalhada com exemplos de código
    do próprio projeto).
- **Uso de Bibliotecas**.
- **Manual do Usuário** (com screenshots do sistema desenvolvido e link do github
    com o projeto completo).
- **Conclusão**.
**2. Apresentação do Projeto (30 minutos)**

Cada grupo terá 30 minutos para apresentar o projeto final para a turma e o professor.
O Grupo que não apresentar o projeto terá a avaliação zerada.


