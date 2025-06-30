# Documentação JavaDoc - Password Validator BFF

## Visão Geral

Este documento descreve como gerar e visualizar a documentação JavaDoc da aplicação Password Validator BFF.

## Como Gerar a Documentação

### Pré-requisitos
- Java 24 ou superior
- Maven 3.6+ ou usar o Maven Wrapper incluído no projeto

### Comandos para Geração

#### Usando Maven (se instalado)
```bash
# Gerar apenas a documentação JavaDoc
mvn javadoc:javadoc

# Gerar documentação e criar JAR com JavaDoc
mvn javadoc:jar

# Limpar, compilar e gerar documentação
mvn clean compile javadoc:javadoc
```

#### Usando Maven Wrapper (recomendado)
```bash
# No Windows
.\mvnw.cmd javadoc:javadoc

# No Linux/Mac
./mvnw javadoc:javadoc
```

## Localização da Documentação

Após a geração, a documentação estará disponível em:
```
target/site/apidocs/index.html
```

Abra este arquivo em seu navegador para visualizar a documentação completa.

## Estrutura da Documentação

A documentação JavaDoc está organizada nos seguintes grupos:

### Controllers (Endpoints REST)
- **PasswordValidatorController**: Endpoint para validação de senhas
- **AuthController**: Endpoint para obtenção de tokens JWT

### Services (Lógica de Negócio)
- **PasswordValidatorService**: Implementação das regras de validação
- **AuthService**: Gerenciamento de autenticação OAuth2

### DTOs (Objetos de Transferência)
- **PasswordRequest**: Requisição de validação de senha
- **PasswordResponse**: Resposta da validação de senha

### Configurações
- **SecurityConfig**: Configurações de segurança e CORS
- **OAuthClientConfig**: Configurações do cliente OAuth2

### Tratamento de Exceções
- **GlobalExceptionHandler**: Manipulador global de exceções

## Funcionalidades da Documentação

### Informações Incluídas
- Descrição detalhada de cada classe e método
- Parâmetros e tipos de retorno
- Exemplos de uso e requisições HTTP
- Links para documentação externa (Spring, Java)
- Critérios de validação de senhas
- Arquitetura e organização do código

### Navegação
- **Índice de Pacotes**: Visão geral da estrutura
- **Busca**: Pesquise por classes, métodos ou conceitos
- **Links Cruzados**: Navegação entre classes relacionadas
- **Responsivo**: Funciona em desktop e mobile

## Padrões de Documentação

### Tags JavaDoc Utilizadas
- `@param`: Descrição dos parâmetros
- `@return`: Descrição do valor retornado
- `@throws`: Exceções que podem ser lançadas
- `@since`: Versão de introdução
- `@author`: Autor do código
- `@version`: Versão atual

### Exemplos Incluídos
- Requisições HTTP com curl
- Estruturas JSON de entrada e saída
- Códigos de status HTTP
- Headers necessários (Authorization, Content-Type)

## Configurações Avançadas

### Personalização
O plugin Maven JavaDoc está configurado com:
- Codificação UTF-8
- Links para documentação Java e Spring
- Agrupamento por funcionalidade
- Título e rodapé personalizados

### Integração Contínua
Para incluir na pipeline CI/CD:
```yaml
# Exemplo para GitHub Actions
- name: Generate JavaDoc
  run: ./mvnw javadoc:javadoc

- name: Publish Documentation
  uses: peaceiris/actions-gh-pages@v3
  with:
    github_token: ${{ secrets.GITHUB_TOKEN }}
    publish_dir: ./target/site/apidocs
```

## Visualização Online

### Hospedagem da Documentação
A documentação pode ser hospedada em:
- GitHub Pages
- GitLab Pages
- Netlify
- Vercel
- Servidor web interno

### Exemplo de Deploy
```bash
# Copiar documentação para servidor web
cp -r target/site/apidocs/* /var/www/html/docs/
```

## Dicas e Truques

### Regeneração Automática
```bash
# Monitorar mudanças e regenerar automaticamente
mvn javadoc:javadoc -Dshow=private -Dadditionalparam=-Xdoclint:none
```

### Incluir Código Fonte
```bash
# Gerar com links para código fonte
mvn javadoc:javadoc -Dlinksource=true
```

### Debug da Geração
```bash
# Gerar com logs detalhados
mvn javadoc:javadoc -X
```

## Suporte

Para dúvidas sobre a documentação JavaDoc:
1. Consulte a documentação oficial do Maven JavaDoc Plugin
2. Verifique os logs de geração em caso de erros
3. Consulte a documentação do Oracle JavaDoc Tool

---