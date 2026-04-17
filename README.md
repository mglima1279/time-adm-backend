id	INT / BIGINT	PRIMARY KEY, AUTO_INCREMENT	Identificador único do registro.  
nome	VARCHAR(255)	NOT NULL	Nome completo do item ou produto.  
caracteristicas	TEXT	NULL	Descrição detalhada ou especificações técnicas do item.  
valor_und	DECIMAL(10,2)	NOT NULL	Valor unitário do item.  
und	VARCHAR(10)	NOT NULL	Unidade de medida (ex: UN, KG, CX, LT).  
tipo	VARCHAR(50)	NOT NULL	Categoria ou tipo do item (ex: Produto, Serviço).  
qtd	DECIMAL(10,3) ou INT	NOT NULL	Quantidade do item. (Nota: usar DECIMAL se permitir valores fracionados, como KG).  
valor_total	DECIMAL(12,2)	NOT NULL	Valor total sem impostos (Geralmente: valor_und × qtd).  
valor_imposto	DECIMAL(12,2)	NOT NULL, DEFAULT 0.00	Valor monetário referente aos impostos aplicados.  
valor_final	DECIMAL(12,2)	NOT NULL	Valor final com impostos (Geralmente: valor_total + valor_imposto).  
