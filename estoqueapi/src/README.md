# Estoque API

API REST para gerenciamento de estoque de produtos, desenvolvida com **Spring Boot** e **H2 Database**.

---

## Tecnologias

- Java 17+
- Spring Boot
- H2 Database (em memória)
- Lombok
- Maven

---

## Configuração do Banco

- Banco em memória **H2**.
- Console H2 acessível em: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- Driver JDBC: `org.h2.Driver`
- URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (em branco)

---

## Endpoints

- `GET /produtos` → Lista todos os produtos
- `GET /produtos/{id}` → Busca produto por ID
- `POST /produtos` → Adiciona um novo produto
- `PUT /produtos/{id}` → Atualiza produto existente
- `DELETE /produtos/{id}` → Remove produto
