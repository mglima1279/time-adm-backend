Projeto: Cálculo de Imposto de Produtos

Este projeto consiste numa aplicação web interativa desenvolvida para facilitar o cadastro de produtos e a simulação de cálculos tributários em tempo real. O sistema permite o registo de itens, a alteração de quantidades na listagem e o cálculo automático de impostos com base na tipificação do produto.

Este projeto faz parte da Unidade Curricular de Codificação Front-End do curso de Desenvolvimento de Sistemas para Internet (SENAI).
🚀 Tecnologias Utilizadas

    HTML5: Estruturação semântica dos dados.

    CSS3: Estilização responsiva e diferenciação visual de itens.

    JavaScript (Vanilla): Manipulação do DOM, cálculos matemáticos e lógica de negócio (sem frameworks).

📋 Requisitos Funcionais (RF)

    RF01 – Cadastro de Produto: O sistema permite informar Produto, Características, Valor Unitário, Unidade e Tipo.

    RF02 – Listagem Dinâmica: Exibição dos produtos abaixo do formulário com campos de quantidade editáveis.

    RF03 – Limpeza Automática: O formulário é resetado após cada inserção com sucesso.

    RF04 – Remoção de Itens: Possibilidade de excluir um produto da lista (através de clique ou botão de exclusão).

⚖️ Regras de Negócio

A aplicação aplica taxas de imposto baseadas no Tipo de Produto:
Tipo	Tributação	Descrição
Tipo 1	Isento	Sem incidência de imposto (0%)
Tipo 2	8%	Incide sobre o valor total do item
Tipo 3	10%	Incide sobre o valor total do item
Tipo 4	12%	Incide sobre o valor total do item
Tipo 5	17%	Incide sobre o valor total do item

Cálculos efetuados:

    Valor Total do Item = Quantidade × Valor Unitário

    Valor do Imposto = Valor Total × % Correspondente

    Valor Final = Valor Total + Valor do Imposto

🗂️ Estrutura de Ficheiros
Plaintext

projeto_produtos/
├── css/
│   └── style.css
├── js/
│   └── script.js
└── index.html

🗄️ Modelação de Dados (Fábrica de Software)

Embora a versão atual seja client-side, a estrutura abaixo foi definida para uma futura persistência em base de dados SQL:
Tabela: TB_PRODUTO
Coluna	Tipo	Descrição
id_produto	INT (PK)	Identificador único
no_produto	VARCHAR(100)	Nome do produto
ds_caracteristica	TEXT	Descrição detalhada
vl_unitario	DECIMAL(10,2)	Preço unitário base
sg_unidade	VARCHAR(5)	Unidade (UN, KG, etc)
cd_tipo_produto	INT	Código do imposto (1-5)
SQL

CREATE TABLE TB_PRODUTO (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    no_produto VARCHAR(100) NOT NULL,
    ds_caracteristica TEXT,
    vl_unitario DECIMAL(10, 2) NOT NULL,
    sg_unidade VARCHAR(5) NOT NULL,
    cd_tipo_produto INT NOT NULL,
    dt_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

🌳 Fluxo de Trabalho (Git Flow)

Para garantir a organização do desenvolvimento, as seguintes ramificações (branches) devem ser utilizadas:

    main: Versão estável em produção.

    develop: Integração de novas funcionalidades.

    feature/: Desenvolvimento de requisitos específicos (ex: feature/cadastro-produto).

Padrão de Commits:

    feat: Nova funcionalidade.

    fix: Correção de bugs.

    style: Alterações de estilização e layout.
