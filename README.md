
## API de Funcinários

### Objetivo

Desenvolver uma aplicação (backend e frontend) que possibilite realizar o crud de
funcionários.

#### Expectativas

- Desenvolva o sistema em Java.
- Desenvolva o frontend com HTML5 com React, Angular ou ExtJS.

## Resolução

### Backend

Foi utilizado o Spring com Java 8 na resolução do problema dado acima, utilizado Flyway para criação do banco de dados, o banco de dados é o h2, executado em memoria, já são criados alguns registros com o banco de dados, também foi utilizado o lombok.

Para executar o projeto, precisamos fazer a compilação, para isso acesse a pasta do projeto backend e execute o seguinte comando (necessário ter o Java instalado e o Maven instalado e configurado):
```
mvn clean install
```
Com o build feito com sucesso, vamos rodar o projeto, para isso acesse a pasta target dentro do diretorio do projeto e execute o seguinte comando:
```
javar -jar backend-0.0.1-SNAPSHOT.jar
```

### Frontend
Foi utilizado Angular 8 no frontend junto com Bootstrap 4 e ngx-bootstrap.

Para executar o projeto entre na pasta do frontend e execute o seguinte comando (necessário ter o NodeJS instalado):
```
npm install
```
Depois execute o comando:
```
ng serve -o
```
Necessário executar o frontend na porta padrão 4200.