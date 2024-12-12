# Guia Avançado de Uso do HTTP Server

Este guia fornece instruções detalhadas sobre como configurar e utilizar o servidor HTTP, explicando seus recursos principais e casos de uso práticos. Inclui também cenários onde sua utilização é recomendada.

---

## Por Que Utilizar este Servidor HTTP?

O servidor HTTP aqui apresentado é ideal para aplicações que exigem:

- **Desempenho escalável:** Com suporte a canais assíncronos.
- **Flexibilidade:** Configurações personalizáveis para segurança e rotas.
- **Simplicidade:** API fácil de usar com abstrações claras.
- **Extensibilidade:** Permite adicionar middlewares e manipular sessões.

Casos de uso comuns incluem:

- APIs RESTful para sistemas back-end.
- Servidores de arquivos estáticos.
- Microsserviços com lógica de negócios.

---


## Configurando e Usando o Servidor

### 1. Configuração Básica do Servidor

Inicialize o servidor com as configurações de porta e host desejadas. Por padrão, ele utiliza `127.0.0.1` como host e a porta 80.

#### Código de Exemplo

```java
HttpServer server = new HttpServerIO(8080, "localhost");
server.enablePrintTrace(); // Habilita logs detalhados
```

> **Nota:** Utilize `enablePrintTrace` para visualizar logs úteis durante o desenvolvimento e depuração.

---

### 2. Definição de Rotas

Rotas são gerenciadas por meio de `RouteExecutor`, que processa cada requisição recebida.

#### Código de Exemplo para Rotas Simples

```java
server.setRouteExecutor(connection -> {
    HttpServerResponse response = connection.getResponse();
    response.contentType("application/json")
           .append("{\"message\":\"Hello, World!\"}")
           .statusCode(200);
});
```

---

### 3. Configuração Avançada

A classe `ServerConfiguration` permite ajustar configurações de segurança e desempenho.

#### Exemplos de Configuração Avançada

- **Habilitar CORS:**

```java
config.enableCORS();
```

- **Limitar requisições:**

```java
config.enablereqLimitRating(500);
```

- **Sanitizar entradas:**

```java
config.enableSanitizeInput();
```

Integre essas configurações com o servidor:

```java
server.setConfiguration(config);
```


---


---
### 4. configurador
1. **Validação do Tamanho do Payload:**
   Verifica se o payload da requisição excede o limite configurado.

2. **Validação de IPs Bloqueados:**
   Impede que endereços IP bloqueados acessem o servidor.

3. **Validação de Limit Rating:**
   Verifica se a quantidade de requisições de um IP excede o limite configurado em limitReq.

4. **Sanitização de Entrada (Sanitize Input):**
    Habilita a sanitização de entradas para proteger contra ataques de injeção, como SQL Injection e XSS. Se configurado, as entradas são processadas para remover caracteres perigosos.

3. **Habilitação de CORS (Cross-Origin Resource Sharing):**
    Habilita o suporte a CORS, permitindo que o servidor aceite requisições de origens diferentes. Isso é útil em aplicações web que fazem chamadas para servidores de diferentes domínios.

---

---

### 5. Manipulação de Sessões

Gerencie sessões utilizando a interface `HttpSession`. Isso permite armazenar dados temporários para o usuário.

#### Código de Exemplo

```java
HttpSession session = ... // Obtido da requisição
session.insert("username", "JohnDoe");
String user = session.getSession("username", String.class);
```

> **Nota:** Configure tempos de expiração de sessão para reforçar a segurança.

---

### 5. Inicializando o Servidor

Após configurar rotas e propriedades, inicie o servidor.

#### Código de Exemplo

```java
server.start();
```

> **Atenção:** Certifique-se de que as configurações estejam completas antes de chamar `start()`.

---

## Melhores Práticas

1. **Modularize as Rotas:** Separe o tratamento de rotas em métodos ou classes para manter o código limpo.
2. **Valide Dados:** Use `sanitizeInput` para evitar vulnerabilidades como injeção de código.
3. **Otimize Logs:** Ative logs somente em ambiente de desenvolvimento ou depuração.
4. **Teste com Alta Carga:** Execute testes de carga para ajustar limites de requisições.

---

## Recursos Adicionais

### Interfaces e Classes Importantes

- **HttpServer:** Configurações gerais do servidor.
- **RouteExecutor:** Define lógica para manipular rotas.
- **HttpServerResponse:** Métodos para configurar respostas HTTP.
- **HttpSession:** Gerenciamento de sessões de usuário.

### Principais Configurações

- Porta e Host: `setPort(int port)`, `setHost(String host)`
- Segurança: `enableCORS()`, `enableSanitizeInput()`
- Logs: `enablePrintTrace()`

---

Com este guia, você pode configurar, personalizar e escalar seu servidor HTTP de maneira eficiente. Explore os exemplos e adapte-os às necessidades específicas do seu projeto.

