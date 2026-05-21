# Care Plus - Front-End Project

## Overview

This project was developed for **FIAP** as part of the **Project Based Learning** for the first year of the **Analysis and Systems Development** program at **FIAP**.

The objective of this project is to design and implement a full working web-app that simulate a real-world digital solution for the company. The focus is on building responsive and user-friendly screens using modern web development technologies.

## Technologies Used

This project was developed using the following technologies:

```
Frontend:
├── React 
├── Tailwind

Backend:
├── Java
├── Spring Boot

Database:
├── Oracle
├── Spring Boot
```

These technologies were chosen to ensure responsive layouts, visual consistency, and interactive user interfaces.

## Project Structure

The project consists of multiple front-end screens designed to represent different parts of the application. The interfaces were developed following best practices for layout organization, responsiveness, and maintainability.

```
FullStackAssistentx/
├──backend/src/main/java/br/com/fiap/assistentx/           
│   ├── src/main/java/br/com/fiap/assistentx
│   │   ├── controller/
│   │   │   ├── InvestimentoController.java
│   │   │   ├── ModeloController.java
│   │   │   ├── OrigemTransacaoController.java
│   │   │   ├── TipoInvestimentoController.java
│   │   │   ├── TransacaoController.java
│   │   │   └── UsuarioController.java
│   │   ├── dto/
│   │   │   ├── CategoriaDoModeloDTO.java
│   │   │   ├── InvestimentoDTO.java
│   │   │   ├── ModeloDTO.java
│   │   │   ├── OrigemTransacaoDTO.java
│   │   │   ├── ResumoCategoriaModeloDTO.java
│   │   │   ├── ResumoClassificacaoInvestimentoDTO.java
│   │   │   ├── ResumoEntradasDTO.java
│   │   │   ├── ResumoModeloDTO.java
│   │   │   ├── ResumoOrigemTransacaoDTO.java
│   │   │   ├── ResumoPatrimonioDTO.java
│   │   │   ├── ResumoSaidasDTO.java
│   │   │   ├── TransacaoDTO.java
│   │   │   ├── UsuarioDTO.java
│   │   │   └── UsuarioModeloDTO.java
│   │   ├── filter/
│   │   │   └── TokenFilter.java
│   │   ├── model/
│   │   │   ├── CategoriaDoModelo.java
│   │   │   ├── CategoriaOrigem.java
│   │   │   ├── CategoriaOrigemId.java
│   │   │   ├── EntidadeFinanceira.java
│   │   │   ├── Investimento.java
│   │   │   ├── Modelo.java
│   │   │   ├── ModeloComCategoria.java
│   │   │   ├── ModeloComCategoriaId.java
│   │   │   ├── OrigemTransacao.java
│   │   │   ├── TipoInvestimento.java
│   │   │   ├── Transacao.java
│   │   │   └── Usuario.java
│   │   ├── repository/
│   │   │   ├── InvestimentoRepository.java
│   │   │   ├── ModeloRepository.java
│   │   │   ├── OrigemTransacaoRepository.java
│   │   │   ├── TipoInvestimentoRepository.java
│   │   │   ├── TransacaoRepository.java
│   │   │   └── UsuarioRepository.java
│   │   ├── service/
│   │   │   ├── HelperService.java
│   │   │   ├── InvestimentoService.java
│   │   │   ├── ModeloService.java
│   │   │   ├── OrigemTransacaoService.java
│   │   │   ├── PatrimonioService.java
│   │   │   ├── ResumoModeloService.java
│   │   │   ├── TipoInvestimentoService.java
│   │   │   ├── TransacaoService.java
│   │   │   ├── TransacoesService.java
│   │   │   └── UsuarioService.java
│   │   └── AssistentxApplication.java
│   └── pom.xml
├── frontend/
└── README.md
```


## Frontend token validation

This project doesn't use other library or frameworks besides ReactJS and SpringBoot Java, and does not have proper security features, only mocked ones. To reach the API's, a filter checks the HTTP Header "Authorization" and filters the user id after "Bearer usuario_"


## Collaborators

Project developed by:

- Guilherme Karkoski
- Lucas Falcone de Rezende
- Chrisman Gabriel Coimbra Campos
- Sara Pires Alves Silva
- Bruno Antoneli

## Login Information

User: joao@email.com.br
Password: senha

## License

This project is intended for academic purposes only.
