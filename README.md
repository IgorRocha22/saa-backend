# 🐾 SAA - Sistema de Adoção de Animais (Backend)

API RESTful desenvolvida com **Spring Boot** para gerenciar o Sistema de Adoção de Animais (SAA). Este projeto serve como o backend da aplicação, fornecendo endpoints para listar animais disponíveis, gerenciar cadastros e processar adoções.

Projeto desenvolvido como parte do Trabalho de Conclusão de Curso (TCC) em Desenvolvimento Full Stack.

---

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 4.x.x
* **Gerenciador de Dependências:** Gradle (Groovy)
* **Banco de Dados:** 
    * _Desenvolvimento:_ H2 Database (Em memória)
    * _Produção (Futuro):_ PostgreSQL
* **ORM:** Spring Data JPA (Hibernate)
* **Utilitários:** Lombok (Redução de boilerplate)
* **Validação:** Hibernate Validator

---

## ⚙️ Pré-requisitos

Para executar este projeto localmente, você precisará ter instalado:

* **Java JDK 21**
* **Git**

---

## 🏃‍♂️ Como Rodar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/saa-backend.git](https://github.com/seu-usuario/saa-backend.git)
    cd saa-backend
    ```

2.  **Execute a aplicação (Via Terminal):**
    * **Linux/Mac:**
        ```bash
        ./gradlew bootRun
        ```
    * **Windows:**
        ```bash
        gradlew.bat bootRun
        ```

3.  **Acesse a API:**
    O servidor iniciará na porta `8080`.
    * URL Base: `http://localhost:8080/api`
    * Console H2 (Banco de dados): `http://localhost:8080/h2-console`
        * _JDBC URL:_ `jdbc:h2:mem:saadb`
        * _User:_ `sa`
        * _Password:_ (vazio)

---

## 📚 Documentação da API

### Base URL
`http://localhost:8080/api`

### 🐶 Animais (`/animals`)

#### 1. Listar Todos (Vitrine)
Retorna todos os animais cadastrados.

* **Endpoint:** `GET /animals`
* **Resposta (200 OK):**
    ```json
    [
      {
        "id": 1,
        "name": "Thor",
        "species": "DOG",
        "breed": "Labrador",
        "age": "YOUNG",
        "size": "LARGE",
        "gender": "MALE",
        "imageUrl": "https://...",
        "status": "AVAILABLE",
        "createdAt": "2025-02-12T10:00:00.000+00:00"
      }
    ]
    ```

#### 2. Buscar por ID
Retorna os detalhes de um animal específico.

* **Endpoint:** `GET /animals/{id}`
* **Exemplo:** `GET /animals/1`

#### 3. Cadastrar Animal (Admin)
Cria um novo registro no banco de dados.

* **Endpoint:** `POST /animals`
* **Content-Type:** `application/json`
* **Corpo da Requisição (Exemplo):**
    ```json
    {
      "name": "Luna",
      "species": "CAT",
      "breed": "Persian",
      "age": "ADULT",
      "size": "MEDIUM",
      "gender": "FEMALE",
      "imageUrl": "[https://images.unsplash.com/photo-cat](https://images.unsplash.com/photo-cat)...",
      "personality": "Calm and independent",
      "healthStatus": "Vaccinated",
      "temperament": ["Calm", "Independent"],
      "status": "AVAILABLE"
    }
    ```

---

## 🏗️ Estrutura do Projeto

O código segue o padrão de camadas (Layered Architecture):

```text
src/main/java/com/saa/backend
├── config/          # Configurações (ex: DatabaseSeeder, CORS)
├── controller/      # Camada de API (Endpoints REST)
├── model/           # Entidades JPA (Animal)
│   └── enums/       # Domínios fixos (Species, Status, Gender...)
├── repository/      # Interfaces Spring Data JPA
└── SaaBackendApplication.java # Classe Main
```
---

## 📝 Enums (Domínio)

Para garantir a integridade dos dados, o sistema utiliza Enums estritos. Ao enviar JSONs, utilize os valores em **Inglês** (Caixa Alta):

* **Species:** `DOG`, `CAT`
* **Gender:** `MALE`, `FEMALE`
* **Size:** `SMALL`, `MEDIUM`, `LARGE`
* **Age:** `PUPPY`, `YOUNG`, `ADULT`, `SENIOR`
* **Status:** `AVAILABLE`, `IN_PROCESS`, `ADOPTED`

---
## 🤝 Contribuição

Projeto desenvolvido para fins educacionais. Sinta-se à vontade para abrir Issues ou Pull Requests.