# RankIt

## Sobre
RankIt é uma API robusta para avaliação de cursos, oferecendo uma maneira eficiente de acessar e avaliar informações detalhadas sobre diversos cursos. A API retorna dados como nome do curso, autor, nota, número de aulas, duração total, preço e descrição.

## Tecnologias Utilizadas
Este projeto é desenvolvido com Java, utilizando o framework Spring Boot. As seguintes dependências são utilizadas:
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Jakarta Persistence API
- Springdoc OpenAPI UI
- Jakarta Validation API
- MySQL Connector Java
- Hibernate Validator
- Spring Boot Starter Test

## Instalação
Para instalar e executar o RankIt, siga estas etapas:

1. **Clone o repositório:**
   ```shell
   git clone https://github.com/herickkgb/RankIt
   ```
2. **Abra o projeto no IntelliJ IDEA:**
   - Certifique-se de que o IntelliJ está configurado com o JDK correto.
   - Importe o projeto como um projeto Maven.

3. **Configure o banco de dados MySQL:**
   - Crie um novo banco de dados no MySQL.
   - Atualize o arquivo `application.properties` com as credenciais do seu banco de dados.

4. **Execute o projeto:**
   - Use o IntelliJ IDEA para executar o projeto.

## Configuração `application.properties`
```properties
# DataSource
spring.datasource.url=jdbc:mysql://localhost:3306/cursos_api
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

## Acesso à Documentação da API
Após iniciar a aplicação, você pode acessar a documentação da API através do Swagger UI no seguinte endereço:
```
http://localhost:8080/swagger-ui/index.html#/curso-controller/findById
```

## Endpoints da API
### Buscar Cursos
-

**Buscar cursos por nome**:
  - **GET** `/api-v1/name/{name}`
    - Busca cursos com base no nome fornecido. Retorna uma lista de cursos que correspondem ao nome especificado.

### Exemplos de Retorno das Requisições
#### GET /api-v1/name/{name}
Retorna uma lista de cursos que correspondem ao nome especificado.
```json
[
  {
    "id": 12,
    "nome": "Curso Básico de Python",
    "author": "Ana Souza",
    "nota": 4.5,
    "numeroDeAulas": 40,
    "duracaoTotalCurso": 60,
    "preco": "100.00",
    "descricao": "Introdução à programação em Python"
  },
  // ... outros cursos com nome similar
]
```

## Uso
Após a instalação, você pode começar a usar a API para avaliar cursos. Envie requisições HTTP para os endpoints disponíveis para criar, recuperar, atualizar ou deletar informações dos cursos, além de buscar cursos por nome.

### Exemplos de Retorno das Requisições
- **GET**:
  ```json
  {
    "id": 10,
    "nome": "Curso de Machine Learning",
    "author": "Lucas Rodriguez",
    "nota": 4.6,
    "numeroDeAulas": 60,
    "duracaoTotalCurso": 90,
    "preco": "150.00",
    "descricao": "Aprendendo algoritmos de machine learning"
  }
  ```

- **POST**:
  ```json
  {
    "id": 11,
    "nome": "Curso de Inteligência Artificial",
    "author": "Maria Silva",
    "nota": 4.8,
    "numeroDeAulas": 50,
    "duracaoTotalCurso": 75,
    "preco": "200.00",
    "descricao": "Introdução ao mundo da IA"
  }
  ```

- **PUT**:
  ```json
  {
    "id": 10,
    "nome": "Curso Avançado de Machine Learning",
    "author": "Lucas Rodriguez",
    "nota": 4.7,
    "numeroDeAulas": 65,
    "duracaoTotalCurso": 95,
    "preco": "180.00",
    "descricao": "Aprofundamento em algoritmos de machine learning"
  }
  ```

- **DELETE**:
  ```json
  {
    "mensagem": "Curso com id 10 deletado com sucesso."
  }
  ```

## Exceções Personalizadas
Este projeto implementa exceções personalizadas segu

indo as melhores práticas de programação. Isso garante uma melhor gestão de erros e uma comunicação mais clara dos problemas aos usuários da API.

## Contribuição
Contribuições são sempre bem-vindas! Se você tem uma sugestão para melhorar este projeto, sinta-se à vontade para fazer um fork do repositório e enviar um pull request.

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](https://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT) para detalhes.

---
