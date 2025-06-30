# Password Validator BFF

Backend for Frontend robusto para validação de senhas com Spring Boot

Um microsserviço moderno construído com Spring Boot 3.5.3 que fornece APIs seguras para validação de senhas com critérios rigorosos de segurança. Utiliza OAuth2 + JWT, integração com Keycloak e arquitetura limpa.

## Índice

- [Demo](#demo)
- [Características](#características)
- [Tecnologias](#tecnologias)
- [Instalação](#instalação)
- [Desenvolvimento](#desenvolvimento)
- [Testes](#testes)
- [Build](#build)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Critérios de Validação](#critérios-de-validação)
- [API](#api)
- [Cobertura de Testes](#cobertura-de-testes)
- [Licença](#licença)

## Demo

```bash
# Executar localmente
./mvnw spring-boot:run
# Acesse: http://localhost:8080
```

### Endpoints de Demonstração
```bash
# Obter token de acesso
curl -X POST http://localhost:8080/auth/token

# Validar senha (com token)
curl -X POST http://localhost:8080/validar \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{"password": "MinhaSenh@123"}'
```

## Características

### Validação de Senhas
- 7 critérios rigorosos de segurança implementados
- Feedback específico para cada critério não atendido
- Validação em tempo real via API REST
- Tratamento de erros robusto e padronizado

### Segurança Avançada
- OAuth2 + JWT com Keycloak integration
- Client credentials flow para autenticação de aplicações
- CORS configurado para integração com frontend
- Spring Security com endpoints protegidos

### Arquitetura
- Clean Architecture com separação de responsabilidades
- Standalone microservice pronto para containerização
- Injeção de dependência nativa do Spring
- JavaDoc completo (100% documentado)

### Qualidade de Código
- Testes unitários abrangentes (90%+ cobertura)
- JaCoCo para relatórios de cobertura
- Tratamento global de exceções
- Bean Validation para validação de entrada

## Tecnologias

### Core
- Java 24 - Linguagem de programação
- Spring Boot 3.5.3 - Framework principal
- Spring Security - Segurança e autenticação
- Maven - Gerenciamento de dependências

### Segurança
- OAuth2 Resource Server - Validação de JWT
- OAuth2 Client - Client credentials flow
- Spring Security OAuth2 JOSE - Manipulação JWT
- Keycloak - Servidor de autorização

### Testes & Qualidade
- JUnit 5 - Framework de testes
- AssertJ - Assertions fluentes
- JaCoCo - Cobertura de código
- Lombok - Redução de boilerplate

### Build & Deploy
- Maven Wrapper - Build tool
- Spring Boot Maven Plugin - Packaging
- JavaDoc Maven Plugin - Documentação

## Instalação

### Pré-requisitos
- Java 24 ou superior
- Maven 3.6+ (ou use o Maven Wrapper incluído)
- Git
- Keycloak Server (para autenticação)

### Clonando o Repositório
```bash
git clone https://github.com/seu-usuario/password-validator-bff.git
cd password-validator-bff
```

### Configuração do Ambiente
```bash
# Configurar variáveis de ambiente
export KEYCLOAK_ISSUER_URI=http://localhost:8081/realms/nome-criativo
export KEYCLOAK_CLIENT_ID=frontend-client
export KEYCLOAK_CLIENT_SECRET=your-client-secret
export KEYCLOAK_TOKEN_URI=http://localhost:8081/realms/nome-criativo/protocol/openid-connect/token
```

### Instalando Dependências
```bash
./mvnw clean install
```

## Desenvolvimento

### Servidor de Desenvolvimento
```bash
./mvnw spring-boot:run
# Aplicação disponível em: http://localhost:8080
```

### Modo de Desenvolvimento com Hot Reload
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=development
# DevTools habilitado para reload automático
```

### Configuração do Keycloak (Desenvolvimento)
```bash
# Docker Compose para Keycloak local
docker run -p 8081:8080 \
  -e KEYCLOAK_ADMIN=admin \
  -e KEYCLOAK_ADMIN_PASSWORD=admin123 \
  quay.io/keycloak/keycloak:23.0 start-dev
```

## Testes

### Executar Todos os Testes
```bash
./mvnw test
# Executa todos os testes unitários
```

### Testes com Cobertura
```bash
./mvnw test jacoco:report
# Gera relatório de cobertura em target/site/jacoco/
```

### Testes Específicos
```bash
# Testes de serviço
./mvnw test -Dtest=PasswordValidatorServiceTests

# Testes de controller
./mvnw test -Dtest=*ControllerTests

# Testes de configuração
./mvnw test -Dtest=*ConfigTests
```

### Executar Testes para CI/CD
```bash
./mvnw clean test -Dmaven.test.failure.ignore=false
```

### Estrutura de Testes
```
src/test/java/com/password_validator_bff/password_validator/
├── PasswordValidatorApplicationTests.java  # Testes de contexto
├── controller/
│   ├── AuthControllerTests.java           # Testes de autenticação
│   └── PasswordValidatorControllerTests.java  # Testes de validação
├── service/
│   ├── AuthServiceTests.java             # Testes OAuth2
│   └── PasswordValidatorServiceTests.java   # Testes de lógica
├── dto/
│   ├── PasswordRequestTests.java         # Testes de request
│   └── PasswordResponseTests.java        # Testes de response
├── config/
│   ├── SecurityConfigTests.java          # Testes de segurança
│   └── OAuthClientConfigTests.java       # Testes OAuth2 config
└── exception/
    └── GlobalExceptionHandlerTests.java  # Testes de exceções
```

## Build

### Build de Desenvolvimento
```bash
./mvnw clean compile
# Compilação para desenvolvimento
```

### Build de Produção
```bash
./mvnw clean package
# Gera JAR otimizado em target/
```

### Gerar Documentação
```bash
./mvnw javadoc:javadoc
# Documentação disponível em target/site/apidocs/
```

### Análise de Qualidade
```bash
./mvnw clean test jacoco:report
# Relatórios em target/site/jacoco/
```

### Artefatos de Build
```
target/
├── password-validator-0.0.1-SNAPSHOT.jar    # JAR executável
├── classes/                                 # Classes compiladas
├── site/
│   ├── apidocs/                            # Documentação JavaDoc
│   └── jacoco/                             # Relatórios de cobertura
└── surefire-reports/                       # Relatórios de testes
```

## Estrutura do Projeto

```
password-validator-bff/
├── src/
│   ├── main/
│   │   ├── java/com/password_validator_bff/password_validator/
│   │   │   ├── PasswordValidatorApplication.java     # Classe principal
│   │   │   ├── controller/                          # Camada REST
│   │   │   │   ├── AuthController.java              # Endpoint OAuth2
│   │   │   │   └── PasswordValidatorController.java # Endpoint validação
│   │   │   ├── service/                            # Lógica de negócio
│   │   │   │   ├── AuthService.java                # Serviço OAuth2
│   │   │   │   └── PasswordValidatorService.java   # Serviço validação
│   │   │   ├── dto/                               # Objetos transferência
│   │   │   │   ├── PasswordRequest.java          # Request validação
│   │   │   │   └── PasswordResponse.java         # Response validação
│   │   │   ├── config/                           # Configurações
│   │   │   │   ├── SecurityConfig.java          # Segurança & CORS
│   │   │   │   └── OAuthClientConfig.java       # Cliente OAuth2
│   │   │   ├── exception/                       # Tratamento erros
│   │   │   │   └── GlobalExceptionHandler.java # Handler global
│   │   │   └── package-info.java               # Documentação pacote
│   │   └── resources/
│   │       ├── application.yml                 # Configuração principal
│   │       └── application.properties         # Configurações extras
│   └── test/                                 # Espelho da estrutura main
├── target/                                   # Artefatos de build
├── .github/                                 # Templates GitHub
│   ├── workflows/ci-cd.yml                 # Pipeline CI/CD
│   ├── ISSUE_TEMPLATE/                     # Templates de issues
│   └── pull_request_template.md           # Template PR
├── docs/                                   # Documentação adicional
│   ├── JAVADOC.md                         # Guia JavaDoc
│   ├── CONTRIBUTING.md                    # Guia contribuição
│   ├── CHANGELOG.md                       # Histórico mudanças
│   └── PROJECT_CONFIG.md                  # Configurações projeto
├── pom.xml                               # Configuração Maven
├── mvnw, mvnw.cmd                       # Maven Wrapper
├── LICENSE                              # Licença MIT
└── README.md                           # Esta documentação
```

## Critérios de Validação

### Regras Implementadas
Uma senha é considerada válida quando atende aos seguintes critérios:

| Critério | Descrição | Exemplo Válido | Exemplo Inválido |
|-------------|--------------|-------------------|---------------------|
| Comprimento | Mínimo de 9 caracteres | `MinhaSenh@1` | `Curta1!` |
| Dígito | Pelo menos 1 número (0-9) | `Senha123!` | `SenhaTexto!` |
| Minúscula | Pelo menos 1 letra minúscula | `minhaSenh@1` | `MAIUSCULA1!` |
| Maiúscula | Pelo menos 1 letra maiúscula | `MinhaSenh@1` | `minuscula1!` |
| Especial | Pelo menos 1 caractere especial | `Senha123!` | `Senha123` |
| Sem Repetição | Caracteres únicos | `Abcdefg1!` | `Abcdefgg1!` |
| Sem Espaços | Não deve conter espaços | `MinhaSenh@1` | `Minha Senh@1` |

### Caracteres Especiais Aceitos
```
! @ # $ % ^ & * ( ) - +
```

### Exemplos de Validação
```java
// Senhas Válidas
"MinhaSenh@123"  // Todos os critérios atendidos
"Abcdefgh1!"     // 9 chars, sem repetição
"MyP@ssw0rd"     // Complexidade adequada

// Senhas Inválidas  
"123456789"      // Sem letras nem especiais
"MinhaSenh@"     // Sem dígitos
"minhasen@1"     // Sem maiúsculas
"MINHASEN@1"     // Sem minúsculas
"MinhaSenh1"     // Sem caracteres especiais
"MinhaSennh@1"   // Caracteres repetidos (n)
"Minha Sen@1"    // Contém espaços
"Curta1!"        // Menos de 9 caracteres
```

## API

### Endpoint de Autenticação
```http
POST /auth/token
Content-Type: application/json
```

**Response:**
```json
{
  "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Endpoint de Validação
```http
POST /validar
Content-Type: application/json
Authorization: Bearer {access_token}

{
  "password": "MinhaSenh@123"
}
```

Response - Senha Válida:
```json
{
  "isValid": true,
  "messages": []
}
```

Response - Senha Inválida:
```json
{
  "isValid": false,
  "messages": [
    "A senha deve conter pelo menos 9 caracteres.",
    "A senha deve conter ao menos um dígito.",
    "A senha não deve conter caracteres repetidos."
  ]
}
```

### Códigos de Status HTTP
| Status | Descrição | Quando Ocorre |
|--------|-----------|---------------|
| `200 OK` | Validação realizada | Senha processada com sucesso |
| `400 Bad Request` | Dados inválidos | Campo password vazio ou nulo |
| `401 Unauthorized` | Token inválido | JWT expirado ou malformado |
| `500 Internal Server Error` | Erro interno | Problema no servidor |

### Exemplo de Integração
```bash
# 1. Obter token
TOKEN=$(curl -s -X POST http://localhost:8080/auth/token | jq -r '.access_token')

# 2. Validar senha
curl -X POST http://localhost:8080/validar \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json" \
  -d '{"password": "MinhaSenh@123"}' | jq '.'
```

## Cobertura de Testes

### Comandos de Cobertura
```bash
# Executar com cobertura
./mvnw clean test jacoco:report

# Visualizar relatório
open target/site/jacoco/index.html

# Relatório no terminal
./mvnw jacoco:report -q

# Verificar threshold
./mvnw jacoco:check
```

### Padrões de Código

#### Código Java
```java
// Bom - Documentado e tipado
/**
 * Valida senha conforme critérios de segurança estabelecidos.
 * 
 * @param password a senha a ser validada (não pode ser null)
 * @return resultado da validação com lista de erros
 * @throws IllegalArgumentException se password for null
 */
public PasswordResponse validate(String password) {
    if (password == null) {
        throw new IllegalArgumentException("Password cannot be null");
    }
    // implementação...
}

// Evitar - Sem documentação nem validação
public Object validate(Object p) {
    // implementação sem clareza
}
```

#### Testes
```java
// Estrutura recomendada
@DisplayName("Password Validator Service Tests")
class PasswordValidatorServiceTests {

    private PasswordValidatorService service;

    @BeforeEach
    void setUp() {
        service = new PasswordValidatorService();
    }

    @Test
    @DisplayName("Should validate password with all criteria met")
    void shouldValidateValidPassword() {
        // Given
        String validPassword = "ValidPass1!";
        
        // When
        PasswordResponse response = service.validate(validPassword);
        
        // Then
        assertThat(response.isValid()).isTrue();
        assertThat(response.messages()).isEmpty();
    }
}
```
## Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

<div align="center">


[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/seu-usuario)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/seu-perfil)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)

</div>