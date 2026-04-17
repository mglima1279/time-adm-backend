# Documentação da API  
  
**URL Base (Padrão):** `http://localhost:8081/produtos`  
  
## Regras de Negócio: Cálculo de Impostos  
Ao criar ou atualizar um produto, o sistema calcula os valores automaticamente com base no campo `tipo`:  
  
* **Tipo "1":** Isento (0% de imposto)  
* **Tipo "2":** 8% de imposto  
* **Tipo "3":** 10% de imposto  
* **Tipo "4":** 12% de imposto  
* **Tipo "5":** 17% de imposto  
  
---  
  
## 1. Criar Novo Produto  
Cria um novo produto e retorna os dados salvos com os cálculos de impostos e totais já aplicados.  
  
* **Método:** `POST`  
* **Rota:** `/` (ex: `http://localhost:8081/produtos`)  
* **Headers:** `Content-Type: application/json`  
  
**Body (Request):**  
```json  
{  
  "nome": "Parafuso Sextavado",  
  "caracteristicas": "Aço inoxidável, 8mm x 50mm",  
  "valorUnd": 2.50,  
  "und": "unidade",  
  "tipo": "2",  
  "qtd": 150  
}  
```  
  
**Response (Sucesso - 201 Created / 200 OK):**  
```json  
{  
  "id": 1,  
  "nome": "Parafuso Sextavado",  
  "caracteristicas": "Aço inoxidável, 8mm x 50mm",  
  "valorUnd": 2.50,  
  "und": "unidade",  
  "qtd": 150,  
  "valorTotal": 375.00,  
  "valorImposto": 30.00,  
  "valorFinal": 405.00  
}  
```  
  
---  
  
## 2. Buscar Produto por ID  
Retorna os detalhes de um produto específico cadastrado no banco de dados.  
  
* **Método:** `GET`  
* **Rota:** `/{id}` (ex: `http://localhost:8081/produtos/1`)  
  
**Response (Sucesso - 200 OK):**  
```json  
{  
  "id": 1,  
  "nome": "Parafuso Sextavado",  
  "caracteristicas": "Aço inoxidável, 8mm x 50mm",  
  "valorUnd": 2.50,  
  "und": "unidade",  
  "qtd": 150,  
  "valorTotal": 375.00,  
  "valorImposto": 30.00,  
  "valorFinal": 405.00  
}  
```  
**Response (Erro - 404 Not Found / 500 Internal Server Error):**  
Lança uma `RuntimeException` informando "Produto não encontrado".  
  
---  
  
## 3. Atualizar Produto (Estoque)  
Atualiza os dados de um produto existente.  
> **Atenção:** De acordo com a lógica atual da API (no `ProdutoService`), este endpoint **atualiza apenas a quantidade (`qtd`)** do produto. Os cálculos de valores e impostos são refeitos automaticamente para a nova quantidade com base no valor unitário e tipo já cadastrados.  
  
* **Método:** `PUT`  
* **Rota:** `/{id}` (ex: `http://localhost:8081/produtos/1`)  
* **Headers:** `Content-Type: application/json`  
  
**Body (Request):**  
```json  
{  
  "qtd": 200  
}  
```  
*(Nota: Você pode enviar o JSON completo do `ProdutoRequest`, mas a API irá considerar apenas o campo `qtd` para a atualização no banco).*  
  
**Response (Sucesso - 200 OK):**  
```json  
{  
  "id": 1,  
  "nome": "Parafuso Sextavado",  
  "caracteristicas": "Aço inoxidável, 8mm x 50mm",  
  "valorUnd": 2.50,  
  "und": "unidade",  
  "qtd": 200,  
  "valorTotal": 500.00,  
  "valorImposto": 40.00,  
  "valorFinal": 540.00  
}  
```  
  
---  
  
## 4. Deletar Produto  
Remove permanentemente um produto do banco de dados pelo seu ID.  
  
* **Método:** `DELETE`  
* **Rota:** `/{id}` (ex: `http://localhost:8081/produtos/1`)  
  
**Response (Sucesso - 204 No Content / 200 OK):**  
Sem corpo de resposta (vazio).  
