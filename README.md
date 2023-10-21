
Este repositório é um aplicativo simples de inicialização por mola, que demonstra alguns padrões de design:

*Singleton
* Controlador
* Fábrica
* Estratégia
* Procuração
* Observador
* Programação Orientada a Aspectos

Este aplicativo de demonstração recupera números de telefone de contato de sites de 2 bancos diferentes (mais bancos podem ser adicionados) com implementações específicas por banco e oferece uma interface agradável para ocultar os detalhes.

## Começando

Estas instruções fornecerão uma cópia do projeto em funcionamento em sua máquina local para fins de desenvolvimento e teste. Consulte execução para obter notas sobre como executar o projeto em um sistema.

### Pré-requisitos

1. Clone o projeto em seu ambiente local:
    ```
    git clone https://github.com/LaisAlba/designPatternsJavaSpring.git
    ```

2. Você precisa do maven instalado em seu ambiente:
    #### Mac (homebrew):
    
    ```
    brew install maven
    ```
    #### Ubuntu:
    ```
    sudo apt-get install maven
    ```
    
### Instalando

Depois de instalar o maven em seu ambiente, instale as dependências do projeto por meio de:

```
mvn install
```

## Testando

Executando todos os testes:
```
mvn test
```

## Executando

Depois de instalar as dependências, isso pode ser executado diretamente a partir do método principal `Application.java`,
ou de uma linha de comando:
```
mvn spring-boot:run
```

Abra o navegador e vá para http://localhost:8080/api/v1/banks e você deverá ver os resultadosv


## Construído com

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Spock](http://spockframework.org/) - Spock testing framework
* [Maven](https://maven.apache.org/) - Dependency Management


