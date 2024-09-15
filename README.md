# Calculadora API

A API de Calculadora é um microsserviço desenvolvido com Spring Boot que permite avaliar expressões matemáticas e armazenar os resultados em um banco de dados. Esta aplicação oferece uma interface RESTful para realizar cálculos e fornece uma estrutura para armazenar e recuperar os resultados calculados.

## Tecnologias Usadas

- **Java**: 17
- **Spring Boot**: 3.3.3
- **Spring Data JPA**: 3.3.3
- **Maven**: 4.0.0
- **H2 Database**
- **Lombok**

## Requisitos

- **Java 17**: Certifique-se de que o Java 17 está instalado em seu sistema.
- **Maven**: Para gerenciar dependências e construir o projeto.

## Estrutura do Projeto

- **Controller**: `CalculadoraController` - Gerencia as requisições para a API.
- **Service**: `CalculadoraService` - Processa a expressão matemática e armazena o resultado.
- **Repository**: `CalculadoraRepository` - Interage com o banco de dados.
- **Exception**: `GlobalExceptions` - Gerencia as exceções globais.
- **Utilitário**: `AvaliadorExpressao` - Avalia expressões matemáticas usando o motor JavaScript.

## Configuração

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/rafaelduartejv/Teste-Accurate.git
    ```

2. **Navegue até o diretório do projeto**:
    ```bash
    cd Teste-Accurate
    ```

3. **Compile e execute o projeto**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints da API

- **Calcular Expressão**
    - **Método**: `POST`
    - **URL**: `/api/calculadora`
    - **Corpo da Requisição**:
      ```json
      {
        "expressao": "5 + 3 * (2 - 1)"
      }
      ```
    - **Resposta**:
      ```json
      {
        "expressao": "5 + 3 * (2 - 1)",
        "resultado": 8.0,
        "timestamp": "2024-09-15T00:00:00"
      }
      ```

## Testes

Para garantir que o sistema funciona conforme esperado, os seguintes testes são realizados:

- **Controller**: Testa sucesso, expressão inválida e expressão nula.
- **Service**: Testa expressões válidas e inválidas.
- **Utilitário**: Testa expressões válidas, inválidas e divisão por zero.

Execute os testes com o comando:

```bash
mvn test

