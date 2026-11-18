Projeto 2 — Sistema de Empréstimo de Equipamentos

Este é meu segundo projeto com Java e Spring Boot.

A ideia foi desenvolver uma API para controlar o empréstimo de equipamentos dentro de uma empresa. Durante a atividade, pratiquei o cadastro de informações, as regras de negócio, os testes automatizados e a publicação de uma aplicação na internet.

**Atividade:** Projeto 2 — Sistema de Empréstimo de Equipamentos

**Estudante:** Janine Santos

**Repositório:** <https://github.com/jansansantoss/sistema-emprestimos>

**API publicada no Render:** <https://sistema-emprestimos-725w.onrender.com>

## 1. Sobre o projeto

Imagine uma empresa que empresta notebooks, monitores e headsets para seus colaboradores.

Antes, a empresa controlava tudo em uma planilha. O problema é que nem sempre era fácil descobrir quem estava usando determinado equipamento, quais estavam disponíveis e quais empréstimos estavam atrasados.

Foi pensando nessa situação que desenvolvi este projeto.

O sistema funciona por meio de uma **API REST**.

Uma API é uma forma de permitir que outros programas enviem pedidos e recebam informações do sistema.

Por exemplo, posso pedir à API para cadastrar um notebook, consultar os equipamentos disponíveis ou registrar uma devolução.

Cada endereço usado para realizar uma dessas operações é chamado de **rota**.

Com o projeto, a proposta é conseguir:

- Cadastrar equipamentos e colaboradores.
- Consultar equipamentos por tipo e disponibilidade.
- Registrar empréstimos e devoluções.
- Controlar a disponibilidade dos equipamentos.
- Definir automaticamente o prazo de devolução.
- Identificar empréstimos atrasados.
- Evitar cadastros duplicados e empréstimos indevidos.
- Manter o histórico dos equipamentos e colaboradores.

O projeto foi dividido em quatro partes obrigatórias: cadastro e rotas, regras de negócio, testes unitários e publicação no Render.

## 2. Tecnologias utilizadas

Estas são as principais tecnologias trabalhadas na atividade.

| Tecnologia      | Para que serve                                                    |
|-----------------|-------------------------------------------------------------------|
| Java            | Linguagem usada para programar as classes e regras do sistema.    |
| Spring Boot     | Facilita a criação e execução da API Java.                        |
| Spring Data JPA | Ajuda a salvar, consultar e atualizar informações no banco.       |
| H2 Database     | Banco de dados utilizado para desenvolver e testar o projeto.     |
| JUnit 5         | Permite criar testes automatizados para verificar o código.       |
| Maven           | Organiza as dependências e executa a compilação e os testes.      |
| Docker          | Empacota a aplicação com o ambiente necessário para executá-la.   |
| Render          | Serviço usado para deixar a API disponível na internet.           |
| Git e GitHub    | Usados para controlar as versões do código e armazenar o projeto. |

**Versão do Java do projeto:** 21

**IDE utilizada:** IntelliJ IDEA 2026.2.4

A IDE é o programa que utilizo para escrever, organizar e executar o código.

## 3. Como organizei o projeto

Para não colocar todas as responsabilidades em uma única classe, organizei a aplicação em camadas.

### Model

É onde ficam as entidades, ou seja, os objetos que representam as informações do sistema.

As principais entidades são:

- `Equipamento`: representa um notebook, monitor ou headset.
- `TipoEquipamento`: define os tipos de equipamento.
- `Colaborador`: representa a pessoa que pode receber um equipamento.
- `Emprestimo`: guarda as informações do empréstimo e das datas.

### Repository

É a camada responsável pela comunicação com o banco de dados.

Com o Spring Data JPA, utilizo os repositories para salvar, buscar e consultar informações.

### Service

É a camada onde ficam as regras de negócio que precisam coordenar operações ou consultar o banco.

Por exemplo, antes de cadastrar um equipamento, o service confere se já existe outro com o mesmo patrimônio.

### Controller

É a camada que recebe as requisições HTTP.

Quando envio um POST, GET, PUT ou DELETE pelo Postman, o controller recebe o pedido e chama o service correspondente.

O controller não deve concentrar as regras de negócio.

A organização principal proposta na atividade é:

    src/
    ├── main/
    │   ├── java/com/.../emprestimos/
    │   │   ├── EmprestimosApplication.java
    │   │   ├── model/
    │   │   │   ├── Equipamento.java
    │   │   │   ├── TipoEquipamento.java
    │   │   │   ├── Colaborador.java
    │   │   │   └── Emprestimo.java
    │   │   ├── repository/
    │   │   │   ├── EquipamentoRepository.java
    │   │   │   ├── ColaboradorRepository.java
    │   │   │   └── EmprestimoRepository.java
    │   │   ├── service/
    │   │   │   ├── EquipamentoService.java
    │   │   │   ├── ColaboradorService.java
    │   │   │   └── EmprestimoService.java
    │   │   └── controller/
    │   │       ├── EquipamentoController.java
    │   │       ├── ColaboradorController.java
    │   │       └── EmprestimoController.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/.../emprestimos/model/
            ├── EquipamentoTest.java
            └── EmprestimoTest.java

Essa é a estrutura de referência usada para organizar as principais partes do projeto.

## 4. Como rodar o projeto

### O que preciso ter instalado

- Java na versão compatível com o `pom.xml`.
- Uma IDE para projetos Java.
- Maven ou o Maven Wrapper incluído no projeto.
- Git, caso queira clonar o repositório.

### Passo 1 — Baixar o projeto

No terminal, posso clonar o repositório:

    git clone https://github.com/jansansantoss/sistema-emprestimos.git

Depois, entro na pasta do projeto:

    cd sistema-emprestimos

### Passo 2 — Conferir o Java

O projeto utiliza Maven. A versão do Java precisa ser compatível com a configuração do arquivo `pom.xml`.

Para conferir o Java instalado:

    java -version

### Passo 3 — Conferir a porta

No arquivo:

    src/main/resources/application.properties

A configuração de porta indicada na atividade é:

    server.port=${PORT:8080}

Isso significa que a aplicação utiliza a porta informada pela variável `PORT`, quando existir.

Se a variável não estiver definida, utiliza a porta **8080**.

Essa configuração permite executar o projeto localmente e também no Render.

### Passo 4 — Executar a aplicação

Posso abrir a classe principal do Spring Boot na IDE e clicar em **Run**.

### Passo 5 — Acessar a API

Com a aplicação funcionando localmente, posso consultar:

    http://localhost:8080/equipamentos

Também posso utilizar:

    http://localhost:8080/colaboradores

É normal que a API não tenha uma página inicial em `/`, porque o projeto foi desenvolvido para responder às rotas REST.

### Banco de dados H2

O H2 foi utilizado como banco de dados para os testes e o desenvolvimento.

## 5. Rotas da API

Uma rota é o endereço usado para executar alguma operação.

Os métodos HTTP mais utilizados foram:

- `GET`: consulta informações.
- `POST`: cadastra ou cria informações.
- `PUT`: atualiza informações ou registra mudanças.
- `DELETE`: remove informações.

### 5.1 Equipamentos

| Método | Rota                 | O que faz                                                            |
|--------|----------------------|----------------------------------------------------------------------|
| GET    | `/equipamentos`      | Lista equipamentos. Permite filtrar por tipo e disponibilidade.      |
| GET    | `/equipamentos/{id}` | Busca um equipamento pelo ID.                                        |
| POST   | `/equipamentos`      | Cadastra um equipamento novo.                                        |
| PUT    | `/equipamentos/{id}` | Atualiza nome e tipo de um equipamento.                              |
| DELETE | `/equipamentos/{id}` | Remove um equipamento, desde que não tenha histórico de empréstimos. |

O cadastro deve retornar **201 Created**.

A atualização retorna **200 OK** e a exclusão bem-sucedida retorna **204 No Content**.

#### Exemplo: cadastrar equipamento

**Método:** POST

**Rota:**

    /equipamentos

**Body JSON:**

    {
      "patrimonio": "NB-001",
      "nome": "Notebook Dell",
      "tipo": "NOTEBOOK"
    }

O equipamento deve ser cadastrado como disponível.

Também posso consultar somente os equipamentos indisponíveis:

    GET /equipamentos?disponivel=false

Ou utilizar filtros por tipo, conforme as rotas implementadas.

### 5.2 Colaboradores

| Método | Rota                              | O que faz                                         |
|--------|-----------------------------------|---------------------------------------------------|
| POST   | `/colaboradores`                  | Cadastra um colaborador.                          |
| GET    | `/colaboradores`                  | Lista os colaboradores.                           |
| GET    | `/colaboradores/{id}`             | Busca um colaborador pelo ID.                     |
| GET    | `/colaboradores/{id}/emprestimos` | Mostra o histórico de empréstimos do colaborador. |

#### Exemplo: cadastrar colaborador

**Método:** POST

**Rota:**

    /colaboradores

**Body JSON:**

    {
      "nome": "Ana Souza",
      "email": "ana@empresa.com",
      "cargo": "Analista"
    }

O cadastro deve retornar **201 Created**.

Um colaborador não pode ser cadastrado duas vezes com o mesmo e-mail.

### 5.3 Empréstimos

| Método | Rota                                           | O que faz                               |
|--------|------------------------------------------------|-----------------------------------------|
| POST   | `/emprestimos?equipamentoId=1&colaboradorId=1` | Registra um empréstimo.                 |
| GET    | `/emprestimos`                                 | Lista todos os empréstimos.             |
| GET    | `/emprestimos?atrasados=true`                  | Lista somente os empréstimos atrasados. |
| GET    | `/emprestimos/{id}`                            | Busca um empréstimo pelo ID.            |
| PUT    | `/emprestimos/{id}/devolucao`                  | Registra a devolução do equipamento.    |

#### Exemplo: realizar empréstimo

**Método:** POST

    POST /emprestimos?equipamentoId=1&colaboradorId=1

Neste caso, estou dizendo ao sistema que o equipamento de ID 1 será emprestado ao colaborador de ID 1.

Os IDs são enviados como parâmetros na URL, utilizando `@RequestParam`.

O sistema é responsável por registrar a data do empréstimo e calcular o prazo de devolução.

O sucesso deve retornar **201 Created**.

#### Exemplo: devolver equipamento

**Método:** PUT

    PUT /emprestimos/1/devolucao

Esse endereço registra a devolução do empréstimo de ID 1.

O sistema deve preencher a data da devolução e liberar novamente o equipamento.

O sucesso deve retornar **200 OK**.

Os números utilizados nos exemplos representam IDs ilustrativos. Eles dependem dos registros existentes no banco.

## 6. Regras de negócio — R1 a R10

As regras de negócio definem o que o sistema pode ou não permitir.

Aprendi que algumas regras ficam na entidade, porque dependem apenas dos dados daquele objeto. Outras precisam ficar no service, porque consultam informações de outras entidades ou do banco de dados.

### R1 — Patrimônio não pode repetir

Não posso cadastrar dois equipamentos com o mesmo patrimônio.

Antes de salvar, o sistema precisa conferir se aquele patrimônio já está cadastrado.

**Onde fica:** `EquipamentoService`.

### R2 — Equipamento novo começa disponível

Todo equipamento novo deve começar disponível para empréstimo.

Mesmo que alguém envie `"disponivel": false` no JSON, o sistema deve salvar o equipamento como disponível.

**Onde fica:** `EquipamentoService`.

### R3 — E-mail não pode repetir

Dois colaboradores não podem utilizar o mesmo e-mail no cadastro.

Essa conferência evita duplicidade de pessoas.

**Onde fica:** `ColaboradorService`.

### R4 — Só posso emprestar equipamento disponível

Se o equipamento já estiver emprestado, não posso realizar outro empréstimo com ele.

O método `emprestar()` verifica a disponibilidade e altera o estado do equipamento.

**Onde fica:** entidade `Equipamento`.

### R5 — O empréstimo tem prazo de 14 dias

Ao realizar um empréstimo, o sistema registra a data atual e calcula a devolução prevista para 14 dias depois.

Além disso, o equipamento fica indisponível.

**Onde fica:** construtor da entidade `Emprestimo`, entidade `Equipamento` e `EmprestimoService`.

### R6 — Não posso devolver duas vezes

Se o empréstimo já tiver uma data de devolução, não posso registrar outra devolução.

O sistema precisa impedir essa operação.

**Onde fica:** entidade `Emprestimo`.

### R7 — Devolver libera o equipamento

Quando um equipamento é devolvido, o sistema registra a data da devolução e altera sua disponibilidade para `true`.

Assim, ele pode ser emprestado novamente.

**Onde fica:** entidades `Emprestimo` e `Equipamento`, com a operação coordenada pelo `EmprestimoService`.

### R8 — Identificar empréstimos atrasados

Um empréstimo está atrasado quando:

1.  A data prevista de devolução já passou.
2.  O equipamento ainda não foi devolvido.

Essa informação é calculada, não precisa ser armazenada em uma coluna própria.

**Onde fica:** entidade `Emprestimo` e consultas do `EmprestimoRepository`.

### R9 — Não apagar equipamento com histórico

Se um equipamento já participou de algum empréstimo, ele não pode ser excluído.

Isso evita perder o histórico do sistema.

**Onde fica:** `EquipamentoService`, consultando o `EmprestimoRepository`.

### R10 — Colaborador com atraso não pode pegar outro equipamento

Antes de realizar um empréstimo, o sistema verifica se o colaborador já possui outro empréstimo atrasado.

Se existir, o novo empréstimo deve ser bloqueado.

**Onde fica:** `EmprestimoService`.

### Como os erros são apresentados

Na versão obrigatória descrita no enunciado, quando uma regra é quebrada, o sistema lança uma exceção com uma mensagem explicando o motivo.

Sem o bônus de tratamento de erros, essas exceções podem resultar em **HTTP 500**.

Para incluir a mensagem na resposta, o PDF orienta configurar:

    server.error.include-message=always

Se o bônus de tratamento de erros foi implementado, as respostas ficam mais específicas:

| Situação                                           | HTTP            |
|----------------------------------------------------|-----------------|
| Equipamento, colaborador ou empréstimo inexistente | 404 Not Found   |
| Patrimônio ou e-mail duplicado                     | 409 Conflict    |
| Operação proibida pelo estado atual                | 409 Conflict    |
| Dados inválidos                                    | 400 Bad Request |

Esses códigos específicos dependem da implementação do bônus.

## 7. Como testar o projeto

Usei o plano de testes para verificar se as regras foram aplicadas corretamente.

Os testes de API podem ser feitos com o Postman, enviando requisições HTTP.

O enunciado recomenda executar os cenários na ordem, começando com o banco vazio, porque alguns testes dependem dos cadastros feitos anteriormente.

### 7.1 Plano de testes da atividade

| Passo | Teste                                                             | Resultado esperado                                      |
|-------|-------------------------------------------------------------------|---------------------------------------------------------|
| 1     | Cadastrar notebook NB-001                                         | 201, equipamento disponível                             |
| 2     | Cadastrar novamente o mesmo patrimônio                            | Erro de patrimônio duplicado (R1)                       |
| 3     | Cadastrar monitor MN-001 enviando disponível=false                | 201, mas salvo como disponível (R2)                     |
| 4     | Cadastrar headset HS-001                                          | 201                                                     |
| 5     | Cadastrar Ana Souza                                               | 201                                                     |
| 6     | Repetir o cadastro com o mesmo e-mail                             | Erro de e-mail duplicado (R3)                           |
| 7     | Emprestar o notebook para Ana                                     | 201, prazo de 14 dias e equipamento indisponível (R5)   |
| 8     | Tentar emprestar o notebook novamente                             | Erro de equipamento indisponível (R4)                   |
| 9     | Tentar emprestar o monitor para colaborador inexistente           | Erro, sem alterar a disponibilidade do monitor          |
| 10    | Consultar equipamentos indisponíveis                              | Somente o notebook emprestado                           |
| 11    | Devolver o notebook                                               | 200, data de hoje e equipamento disponível (R7)         |
| 12    | Tentar devolver o mesmo empréstimo novamente                      | Erro de devolução duplicada (R6)                        |
| 13    | Tentar excluir notebook que já foi emprestado                     | Erro por existir histórico (R9)                         |
| 14    | Criar um empréstimo e alterar o prazo no H2 para uma data passada | Consulta de atrasados retorna o empréstimo vencido (R8) |
| 15    | Tentar emprestar headset para colaborador com atraso              | Operação bloqueada (R10)                                |
| 16    | Consultar o histórico de empréstimos da Ana                       | Mostra os empréstimos da colaboradora                   |
| 17    | Repetir os passos 1, 5, 7 e 11 no Render                          | Mesmos comportamentos na API publicada                  |

### 7.2 Testando empréstimos atrasados

Como não seria prático esperar 14 dias para testar um atraso, o PDF orienta alterar a data prevista diretamente no H2.

Exemplo de comando SQL apresentado na atividade:

    UPDATE EMPRESTIMO
    SET DATA_PREVISTA_DEVOLUCAO = '2026-11-01'
    WHERE ID = 2;

O ID e a data precisam ser ajustados conforme os registros usados no teste.

Depois da alteração, posso consultar:

    GET /emprestimos?atrasados=true

A resposta deve mostrar somente os empréstimos realmente atrasados.

## 8. Testes unitários com JUnit 5

Além dos testes com Postman, a atividade exige testes unitários.

Um teste unitário verifica uma pequena parte do código, como um método ou uma regra, sem precisar testar toda a aplicação.

Na Parte 3, os testes são feitos diretamente nas entidades, sem subir o Spring Boot e sem utilizar o banco de dados.

### EquipamentoTest

A classe deve verificar pelo menos três situações:

- Emprestar um equipamento disponível deixa ele indisponível.
- Tentar emprestar um equipamento indisponível lança exceção.
- Devolver um equipamento deixa ele disponível novamente.

### EmprestimoTest

A classe deve verificar sete situações:

- Um empréstimo criado em 14/11 tem devolução prevista para 28/11.
- Devolver um empréstimo aberto registra a data informada.
- Uma segunda devolução gera exceção.
- Um empréstimo não devolvido, com prazo vencido, está atrasado.
- Um empréstimo com prazo futuro não está atrasado.
- Um empréstimo já devolvido não está atrasado.
- Um empréstimo cujo prazo termina hoje ainda não está atrasado.

### Como executar os testes

No IntelliJ IDEA, posso clicar com o botão direito em:

    src/test/java

E selecionar:

    Run 'All Tests'

Também posso utilizar o Maven Wrapper pelo terminal do Windows:

    .\mvnw.cmd test

No meu ambiente, executei `\.\mvnw.cmd test` no terminal do IntelliJ IDEA. O resultado registrado foi **BUILD SUCCESS**, com **11 testes executados, sem falhas ou erros**.

O objetivo é que todos os testes fiquem verdes, sem erros e sem falhas.

Os testes usam métodos como:

- `assertTrue(``)`: verifica se uma condição é verdadeira.
- `assertFalse(``)`: verifica se uma condição é falsa.
- `assertEquals(``)`: compara o resultado com o valor esperado.
- `assertThrows(``)`: verifica se uma exceção foi lançada.

Uma coisa que achei importante aprender foi a organização dos testes em três momentos: preparar, executar e conferir.

## 9. Publicação no Render

O Render foi utilizado para colocar a API na internet.

Antes disso, a aplicação funcionava apenas no meu computador, utilizando `localhost`.

Com o deploy, ela passa a ter um endereço público.

**Link da API:** <https://sistema-emprestimos-725w.onrender.com>

### Como funciona a publicação

De forma resumida, o processo descrito na atividade foi:

1.  Preparar o projeto Java.
2.  Configurar a porta no `application.properties`.
3.  Criar o arquivo `Dockerfile` na raiz do projeto.
4.  Enviar os arquivos para o GitHub.
5.  Criar um Web Service no Render.
6.  Selecionar o repositório e a branch `main`.
7.  Utilizar Docker como ambiente de publicação.
8.  Acompanhar os logs até a aplicação iniciar.

O Dockerfile é o arquivo que orienta o Docker a montar e executar a aplicação.

O Dockerfile trabalha em duas etapas: compilar o projeto com Maven e executar o arquivo JAR utilizando Java.

A versão do Java do Dockerfile precisa ser compatível com a versão configurada no `pom.xml`.

A configuração de porta é:

    server.port=${PORT:8080}

O Render define a variável `PORT`, e o Spring Boot utiliza esse valor para iniciar o servidor.

Quando um novo commit é enviado à branch vinculada, o Render pode realizar um novo deploy automaticamente.

### Como testar no Render

Depois da publicação, basta substituir o endereço local pelo endereço público.

Exemplo:

    https://sistema-emprestimos-725w.onrender.com/equipamentos

A API usa HTTPS no Render.

Acessar somente a URL principal, sem uma rota, pode apresentar 404. Isso é esperado quando não existe um endpoint configurado para `/`.

### Cuidados com o plano gratuito

No plano gratuito, observei estas limitações descritas na atividade:

**O serviço pode dormir após 15 minutos sem uso.**

Nesse caso, a primeira requisição depois da pausa pode levar quase um minuto para responder.

**O H2 pode perder os dados quando a aplicação reinicia ou recebe um novo deploy.**

Isso acontece porque ele é utilizado como banco de testes, sem persistência permanente nessa configuração.

Num sistema real, seria melhor utilizar um banco persistente, como PostgreSQL.

### Segurança do console H2

O console do H2 não deve ficar disponível publicamente.

Para evitar deixar o console exposto no Render, a configuração indicada é:

    SPRING_H2_CONSOLE_ENABLED=false

## 10. Bônus opcionais

### Nível 1

- [ ] **Swagger:** documentação visual das rotas, com uma interface para consultar e testar a API.
- Durante o desenvolvimento do projeto, tentei acessar o Swagger pelo navegador, mas a página apresentou o erro 404.

Depois, verifiquei o arquivo pom.xml e percebi que a dependência do Swagger ainda não estava configurada.
Para instalar o Swagger no Intellij IDEA como meu projeto utiliza spring boot 4, teria que consultar a documentação de compatibilidade.
sendo assim, se era necessário procurar a seção de dependencias no pom.xml e acrescentar dentro do pom

depois salvar e atualizar o Maven.

testar o load Maven changes ou atualizar direto pelo ícone do Maven.
aguardar a conclusão da importação das dependências.
Reiniciar a aplicação e executar novamente meu EmprestimosApplication.java para configurmar que a aplicação iniciou sem erros.

Depois abrir o Swagger http://localhost:8080/swagger-ui.html e se tivesse tudo configurado corretamente 
ia aparecer uma interface com os endpoints da minha API, Como minha API já estava funcionando normalmente no Postman e publicada no Render, preferi não fazer essa alteração agora, para evitar possíveis problemas antes da entrega.

Decidi deixar a instalação do Swagger para outro momento, quando puder estudar melhor seu funcionamento e realizar os testes com mais tranquilidade.

Considerações sobre os bônus opcionais

Como ainda estou aprendendo Java e Spring Boot, procurei me concentrar primeiro nas quatro partes obrigatórias da atividade: criar as entidades e rotas da API, desenvolver as regras de negócio R1 a R10, realizar os testes unitários com JUnit 5 e publicar o projeto no Render utilizando Docker.

Durante o desenvolvimento, também consegui implementar uma parte do bônus de tratamento de erros, que faz parte do Nível 2.

No arquivo EmprestimoController.java, utilizei o @ExceptionHandler para tratar algumas situações de erro. Por exemplo, quando um recurso não é encontrado, o sistema pode retornar 404 Not Found. Já quando uma operação não pode ser realizada por causa de uma regra do sistema, pode retornar 409 Conflict.

Esse tratamento foi feito diretamente no controller, sem precisar criar uma classe separada com @RestControllerAdvice.

Decidi não implementar os outros bônus neste momento, porque preferi entender melhor o funcionamento do projeto, realizar os testes e garantir que a API estivesse publicada no Render.

Pretendo estudar esses recursos com mais calma e, futuramente, utilizá-los para melhorar o projeto e continuar aprendendo Java.

## 11. O que aprendi e as dificuldades que encontrei


Durante o desenvolvimento deste projeto, comecei a entender melhor como as classes de uma aplicação Java trabalham juntas.

No começo, tive dificuldade para diferenciar o que deveria ficar na entidade e o que deveria ficar no service.

Depois fui entendendo que as regras que dependem somente do próprio objeto podem ficar na entidade. Já as regras que precisam buscar informações no banco ficam no service.

Também aprendi a trabalhar com `LocalDate`, que representa uma data sem precisar guardar a hora.

Usei esse conceito para entender como o sistema calcula o prazo de devolução e identifica empréstimos atrasados.

Outro assunto importante foi o `@Transactional`. Entendi que ele ajuda quando uma operação precisa modificar mais de uma informação no banco e não pode ficar salva pela metade.

Também pratiquei os testes com JUnit 5 e percebi como eles ajudam a encontrar erros antes de publicar o sistema.

Na parte do deploy, aprendi a diferença entre executar uma API localmente e disponibilizá-la pela internet.

Com o Git, GitHub, Docker e Render, comecei a entender melhor o caminho que o código percorre até ficar disponível para outras pessoas.

Durante as aulas, também conheci o conceito de DTO (Data Transfer Object) e aprendi que ele serve para organizar os dados que uma API recebe ou envia.

No meu projeto, não utilizei uma classe DTO específica para registrar os empréstimos. Optei por receber o ID do equipamento e o ID do colaborador diretamente pela URL, utilizando @RequestParam no EmprestimoController.

Com isso, consegui entender que existem diferentes formas de receber informações em uma API e que os DTOs podem ajudar a organizar melhor esses dados.

Pretendo estudar mais sobre DTOs e utilizá-los em projetos futuros, conforme for avançando nos meus estudos de Java e Spring Boot.


Foi um projeto importante para praticar os conceitos das aulas e aprender a resolver problemas durante o desenvolvimento.

## 12. Autor

**Nome:** JANINE SANTOS

**GitHub:** <https://github.com/jansansantoss>

**Repositório do projeto:** <https://github.com/jansansantoss/sistema-emprestimos>

**API no Render:** <https://sistema-emprestimos-725w.onrender.com>

Projeto desenvolvido como atividade prática de Java e Spring Boot.

## 13. Entrega da atividade

O checklist da atividade pede:

- [ ] Código publicado no GitHub, com o último push realizado.
- [ ] README com instruções de execução, rotas, link do Render e bônus feitos.
- [ ] Todas as rotas obrigatórias funcionando.
- [ ] Regras R1 a R10 verificadas com o plano de testes.
- [ ] Testes unitários aprovados.
- [ ] API funcionando no Render.
- [ ] Links do GitHub e Render enviados no Classroom.

**Prazo informado no enunciado:** domingo, 22/11/2026, às 23h59.

Este projeto representa mais uma etapa do meu aprendizado com Java, Spring Boot e desenvolvimento de APIs.

Falta gravar o vídeo e adicionar aqui no Readme