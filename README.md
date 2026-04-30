# 📦 API de Produtos

**URL Base:** `http://localhost:8081/produtos`

---

## 🔄 Observações Importantes

* A API suporta operações completas: **CRUD + PATCH (atualização parcial)**
* O campo `tipo` é armazenado e retornado, porém **não há cálculo de impostos no response**
* O retorno contém apenas os dados básicos do produto
* Tratamento de erros simples via `ResponseEntity`

---

## 📌 Estrutura do Produto

### 🔸 Request (`ProdutoRequest`)

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

### 🔸 Response (`ProdutoResponse`)

```json
{
  "id": 1,
  "nome": "Parafuso Sextavado",
  "caracteristicas": "Aço inoxidável, 8mm x 50mm",
  "valorUnd": 2.50,
  "und": "unidade",
  "qtd": 150,
  "tipo": "2"
}
```

---

# 🚀 Endpoints

---

## 1. ➕ Criar Produto

Cria um novo produto.

* **Método:** `POST`
* **Rota:** `/`
* **Headers:** `Content-Type: application/json`

### ✅ Response

* `200 OK` → Produto criado com sucesso
* `400 Bad Request` → Erro na requisição

---

## 2. 📄 Listar Todos os Produtos

Retorna todos os produtos cadastrados.

* **Método:** `GET`
* **Rota:** `/`

### ✅ Response

```json
[
  {
    "id": 1,
    "nome": "Produto A",
    "caracteristicas": "Descrição",
    "valorUnd": 10.00,
    "und": "unidade",
    "qtd": 50,
    "tipo": "1"
  }
]
```

* `200 OK`

---

## 3. 🔍 Buscar Produto por ID

Retorna um produto específico.

* **Método:** `GET`
* **Rota:** `/{id}`

### ✅ Response

* `200 OK` → Produto encontrado
* `404 Not Found` → Produto não encontrado

---

## 4. ✏️ Atualização Parcial (PATCH)

Atualiza apenas os campos enviados.

* **Método:** `PATCH`
* **Rota:** `/{id}`

### 📥 Body (exemplo)

```json
{
  "qtd": 200
}
```

### ✅ Response

* `200 OK` → Produto atualizado
* `404 Not Found` → Produto não encontrado

---

## 5. 🔁 Atualização Completa (PUT)

Atualiza todos os dados do produto.

* **Método:** `PUT`
* **Rota:** `/{id}`

### 📥 Body

Mesmo formato do `ProdutoRequest`

### ✅ Response

* `200 OK` → Produto atualizado
* `404 Not Found` → Produto não encontrado

---

## 6. ❌ Deletar Produto

Remove um produto do banco.

* **Método:** `DELETE`
* **Rota:** `/{id}`

### ✅ Response

* `204 No Content` → Deletado com sucesso

---

# ⚠️ Tratamento de Erros

| Situação               | Status    |
| ---------------------- | --------- |
| Requisição inválida    | 400       |
| Produto não encontrado | 404       |
| Sucesso                | 200 / 204 |

---

# 🌐 CORS

A API permite requisições de qualquer origem:

```java
@CrossOrigin(origins = "*", allowedHeaders = "*")
```

---

# 🧠 Notas Técnicas

* Controller: `ProdutoController`
* Service: `ProdutoService`
* DTOs:

  * `ProdutoRequest` → Entrada de dados
  * `ProdutoResponse` → Saída de dados
* Conversão feita via método:

```java
ProdutoResponse.fromEntity(produto)
```

---

# 📌 Melhorias Futuras (Sugestões)

* Adicionar cálculo de impostos no response
* Padronizar erros com `@ControllerAdvice`
* Implementar documentação automática com Swagger/OpenAPI
* Validações com `@Valid` e Bean Validation

---

# 👨‍💻 Autor

Projeto desenvolvido para fins de estudo e prática com **Spring Boot**.
