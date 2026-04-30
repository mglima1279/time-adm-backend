# 📦 API de Produtos

**URL Base:** `http://localhost:8081/produtos`

---

## 🔄 Observações Importantes

* API com suporte a **CRUD completo + PATCH**
* **Não há cálculo de impostos no response**
* Retorno contém apenas dados básicos do produto
* Tratamento de erros simples com `ResponseEntity`

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

* **Método:** `POST`
* **Rota:** `/`

### 📥 Request

```http
POST /produtos
Content-Type: application/json
```

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

### 📤 Response (200 OK)

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

### ❌ Response (400 Bad Request)

Sem corpo

---

## 2. 📄 Listar Todos os Produtos

* **Método:** `GET`
* **Rota:** `/`

### 📥 Request

```http
GET /produtos
```

### 📤 Response (200 OK)

```json
[
  {
    "id": 1,
    "nome": "Produto A",
    "caracteristicas": "Descrição A",
    "valorUnd": 10.00,
    "und": "unidade",
    "qtd": 50,
    "tipo": "1"
  },
  {
    "id": 2,
    "nome": "Produto B",
    "caracteristicas": "Descrição B",
    "valorUnd": 20.00,
    "und": "caixa",
    "qtd": 30,
    "tipo": "3"
  }
]
```

---

## 3. 🔍 Buscar Produto por ID

* **Método:** `GET`
* **Rota:** `/{id}`

### 📥 Request

```http
GET /produtos/1
```

### 📤 Response (200 OK)

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

### ❌ Response (404 Not Found)

Sem corpo

---

## 4. ✏️ Atualização Parcial (PATCH)

* **Método:** `PATCH`
* **Rota:** `/{id}`

### 📥 Request

```http
PATCH /produtos/1
Content-Type: application/json
```

```json
{
  "qtd": 200
}
```

### 📤 Response (200 OK)

```json
{
  "id": 1,
  "nome": "Parafuso Sextavado",
  "caracteristicas": "Aço inoxidável, 8mm x 50mm",
  "valorUnd": 2.50,
  "und": "unidade",
  "qtd": 200,
  "tipo": "2"
}
```

### ❌ Response (404 Not Found)

Sem corpo

---

## 5. 🔁 Atualização Completa (PUT)

* **Método:** `PUT`
* **Rota:** `/{id}`

### 📥 Request

```http
PUT /produtos/1
Content-Type: application/json
```

```json
{
  "nome": "Parafuso Atualizado",
  "caracteristicas": "Aço carbono, 10mm",
  "valorUnd": 3.00,
  "und": "unidade",
  "tipo": "3",
  "qtd": 300
}
```

### 📤 Response (200 OK)

```json
{
  "id": 1,
  "nome": "Parafuso Atualizado",
  "caracteristicas": "Aço carbono, 10mm",
  "valorUnd": 3.00,
  "und": "unidade",
  "qtd": 300,
  "tipo": "3"
}
```

### ❌ Response (404 Not Found)

Sem corpo

---

## 6. ❌ Deletar Produto

* **Método:** `DELETE`
* **Rota:** `/{id}`

### 📥 Request

```http
DELETE /produtos/1
```

### 📤 Response (204 No Content)

Sem corpo

---

# ⚠️ Tratamento de Erros

| Situação               | Status    |
| ---------------------- | --------- |
| Requisição inválida    | 400       |
| Produto não encontrado | 404       |
| Sucesso                | 200 / 204 |
