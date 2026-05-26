# Documentação de Testes da API

## Projeto

Sistema de agendamentos para barbearia.

O objetivo dos testes foi validar o funcionamento das principais rotas da API, verificando as operações de cadastro, listagem, atualização e exclusão de dados.

## Ambiente de Teste

- Backend: Java com Spring Boot
- Banco de Dados: PostgreSQL
- Ferramenta de teste: Postman
- URL base da API: http://localhost:8080
- Banco utilizado: barbearia_db

## Collection do Postman

As requisições utilizadas nos testes foram organizadas em uma collection do Postman e exportadas para a pasta:

postman/sistema-agendamentos.postman_collection.json

---

# Testes Realizados

## 1. Testes de Cliente

### POST /clientes

Objetivo: cadastrar um novo cliente no sistema.

Exemplo de requisição:

{
  "name": "João Silva",
  "email": "joao@email.com",
  "telefone": "83999999999"
}

Resultado esperado: cliente cadastrado com sucesso.
Resultado obtido: cliente cadastrado com sucesso.
Status: 200 OK.

---

### GET /clientes

Objetivo: listar todos os clientes cadastrados.

Resultado esperado: retornar a lista de clientes.
Resultado obtido: lista retornada com sucesso.
Status: 200 OK.

---

### GET /clientes/{id}

Objetivo: buscar um cliente específico pelo ID.

Resultado esperado: retornar os dados do cliente informado.
Resultado obtido: cliente retornado com sucesso.
Status: 200 OK.

---

### PUT /clientes/{id}

Objetivo: atualizar os dados de um cliente existente.

Exemplo de requisição:

{
  "name": "João Atualizado",
  "email": "joao.atualizado@email.com",
  "telefone": "83988888888"
}

Resultado esperado: cliente atualizado com sucesso.
Resultado obtido: cliente atualizado com sucesso.
Status: 200 OK.

---

### DELETE /clientes/{id}

Objetivo: excluir um cliente existente.

Resultado esperado: cliente removido do sistema.
Resultado obtido: cliente removido com sucesso.
Status: sucesso na requisição.

---

## 2. Testes de Serviço

### POST /servicos

Objetivo: cadastrar um novo serviço oferecido pela barbearia.

Exemplo de requisição:

{
  "name": "Corte Masculino",
  "descricao": "Corte simples na máquina e tesoura",
  "preco": 35.0
}

Resultado esperado: serviço cadastrado com sucesso.
Resultado obtido: serviço cadastrado com sucesso.
Status: 200 OK.

---

### GET /servicos

Objetivo: listar todos os serviços cadastrados.

Resultado esperado: retornar a lista de serviços.
Resultado obtido: lista retornada com sucesso.
Status: 200 OK.

---

### GET /servicos/{id}

Objetivo: buscar um serviço específico pelo ID.

Resultado esperado: retornar os dados do serviço informado.
Resultado obtido: serviço retornado com sucesso.
Status: 200 OK.

---

### PUT /servicos/{id}

Objetivo: atualizar os dados de um serviço existente.

Exemplo de requisição:

{
  "name": "Corte + Barba",
  "descricao": "Corte masculino completo com barba",
  "preco": 55.0
}

Resultado esperado: serviço atualizado com sucesso.
Resultado obtido: serviço atualizado com sucesso.
Status: 200 OK.

---

### DELETE /servicos/{id}

Objetivo: excluir um serviço existente.

Resultado esperado: serviço removido do sistema.
Resultado obtido: serviço removido com sucesso.
Status: sucesso na requisição.

---

## 3. Testes de Agendamento

### POST /agendamentos

Objetivo: criar um novo agendamento vinculando um cliente a um serviço.

Exemplo de requisição:

{
  "data": "2026-05-25",
  "horario": "14:30",
  "cliente": {
    "id": 3
  },
  "servico": {
    "id": 2
  }
}

Resultado esperado: agendamento criado com sucesso.
Resultado obtido: agendamento criado com sucesso.
Status: 200 OK.

---

### GET /agendamentos

Objetivo: listar todos os agendamentos cadastrados.

Resultado esperado: retornar a lista de agendamentos.
Resultado obtido: lista retornada com sucesso.
Status: 200 OK.

---

### GET /agendamentos/{id}

Objetivo: buscar um agendamento específico pelo ID.

Resultado esperado: retornar os dados do agendamento informado.
Resultado obtido: agendamento retornado com sucesso.
Status: 200 OK.

---

### PUT /agendamentos/{id}

Objetivo: atualizar os dados de um agendamento existente.

Exemplo de requisição:

{
  "data": "2026-05-26",
  "horario": "16:00",
  "cliente": {
    "id": 3
  },
  "servico": {
    "id": 2
  }
}

Resultado esperado: agendamento atualizado com sucesso.
Resultado obtido: agendamento atualizado com sucesso.
Status: 200 OK.

---

### DELETE /agendamentos/{id}

Objetivo: excluir um agendamento existente.

Resultado esperado: agendamento removido do sistema.
Resultado obtido: agendamento removido com sucesso.
Status: sucesso na requisição.

---

# Testes de Cenários Inválidos

Além dos testes principais, também foram realizados testes com dados inexistentes para observar o comportamento da API.

## GET /clientes/999

Objetivo: buscar um cliente inexistente.

Resultado esperado: retornar erro ou mensagem informando que o cliente não foi encontrado.
Resultado obtido: erro retornado pela API.

---

## DELETE /servicos/999

Objetivo: tentar excluir um serviço inexistente.

Resultado esperado: retornar erro ou não remover nenhum registro.
Resultado obtido: comportamento tratado pela API.

---

## POST /agendamentos com cliente e serviço inexistentes

Exemplo de requisição:

{
  "data": "2026-05-25",
  "horario": "14:30",
  "cliente": {
    "id": 999
  },
  "servico": {
    "id": 999
  }
}

Objetivo: verificar se o sistema permite criar um agendamento com cliente ou serviço inexistente.

Resultado esperado: retornar erro, pois o cliente e o serviço não existem.
Resultado obtido: erro retornado pela API.

---

# Observações

Durante os testes de criação e atualização de agendamentos, foi observado que a resposta imediata do POST e do PUT retornou alguns campos de cliente e serviço como null, exibindo principalmente os IDs relacionados.

Porém, ao realizar uma requisição GET posteriormente, os dados completos de cliente e serviço foram exibidos corretamente. Dessa forma, foi possível verificar que o relacionamento entre agendamento, cliente e serviço foi salvo corretamente no banco de dados.

Esse comportamento está relacionado à forma como o backend retorna o objeto logo após salvar ou atualizar o registro.

---

# Conclusão

Os testes realizados validaram as principais funcionalidades da API do sistema de agendamentos, incluindo cadastro, listagem, atualização, exclusão e relacionamento entre cliente, serviço e agendamento.

A API respondeu corretamente aos testes principais realizados pelo Postman, demonstrando que as operações básicas do sistema estão funcionando.
