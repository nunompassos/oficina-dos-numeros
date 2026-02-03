# 🔧 Oficina dos Números

**Modelar a sorte, um número de cada vez**
*Modeling luck, one number at a time*

---

## 🇵🇹 Visão Geral

A **Oficina dos Números** é uma aplicação backend desenvolvida em **Java 25** cujo objetivo é gerar **previsões estatísticas** para o sorteio do **Euromilhões**, com base em diferentes **modelos matemáticos e probabilísticos**.

A aplicação não promete ganhos nem resultados garantidos. O seu foco é **explorar estatística aplicada**, oferecendo ao utilizador transparência total sobre os modelos utilizados, os seus pressupostos e limitações.

Aqui, a sorte não é adivinhada — é **modelada**.

---

## 🇬🇧 Overview

**Oficina dos Números (Numbers Workshop)** is a backend application developed in **Java 25** whose goal is to generate **statistical predictions** for the **EuroMillions** lottery, based on different **mathematical and probabilistic models**.

The application does not promise winnings or guaranteed results. Its focus is on **applied statistics**, offering full transparency regarding the models used, their assumptions, and their limitations.

Here, luck is not guessed — it is **modeled**.

---

## 🎯 Objetivos / Goals

### 🇵🇹

* Disponibilizar diferentes **modelos estatísticos** de previsão
* Permitir que o utilizador **escolha o modelo** a utilizar
* Explicar de forma clara **como cada modelo funciona**
* Manter uma arquitetura **simples, extensível e testável**
* Servir como projeto técnico e didático em **backend Java**

### 🇬🇧

* Provide multiple **statistical prediction models**
* Allow users to **choose which model** to apply
* Clearly explain **how each model works**
* Maintain a **simple, extensible, and testable** architecture
* Serve as a technical and educational **Java backend project**

---

## 🧠 Conceito Central / Core Concept

### 🇵🇹

A aplicação segue a metáfora de uma **oficina**:

* Cada modelo estatístico é uma **ferramenta**
* Os dados históricos são a **matéria-prima**
* A previsão é o **produto final**, sempre probabilístico

### 🇬🇧

The application follows the **workshop metaphor**:

* Each statistical model is a **tool**
* Historical data is the **raw material**
* The prediction is the **final product**, always probabilistic

Models are interchangeable and independent, allowing different approaches to the same problem.

---

## ⚙️ Stack Tecnológica / Tech Stack

* **Java 25**
* **Micronaut Framework**
* **Gradle (Kotlin DSL)**
* REST API
* Jackson (JSON)
* OpenAPI / Swagger
* JUnit 5

### Persistência / Persistence (planned)

* PostgreSQL

---

## 🧱 Arquitetura / Architecture

* **Domain** — domain entities and business rules
* **Application** — application services and use cases
* **Infrastructure** — statistical model implementations and repositories
* **API** — REST layer

Statistical models follow the **Strategy Pattern**, allowing new models to be added without impacting the rest of the system.

---

## 📊 Modelos Estatísticos Planeados / Planned Models

* Historical frequency
* Number delay
* Weighted combinations
* Hybrid models
* Statistical simulations

Each model includes:

* Name
* Description
* Assumptions
* Known limitations

---

## 🌐 API (example)

* `GET /models` — list available models
* `POST /predict?model={id}` — generate a prediction using the selected model

All responses include a **statistical transparency disclaimer**.

---

## ⚠️ Aviso Importante / Disclaimer

### 🇵🇹

> Esta aplicação gera resultados **puramente estatísticos**.
> Não existe qualquer garantia de prémio ou ganho financeiro.
> O Euromilhões é um jogo de azar e deve ser encarado como tal.

### 🇬🇧

> This application generates **purely statistical results**.
> There is no guarantee of winnings or financial gain.
> EuroMillions is a game of chance and should be treated as such.

The Oficina dos Números promotes **mathematical exploration and critical thinking**, not irresponsible gambling.

---

## 🚀 Roadmap

* [ ] Micronaut project bootstrap
* [ ] First statistical model implementation
* [ ] REST API exposure
* [ ] Unit tests for models
* [ ] Historical data persistence
* [ ] Model performance comparison

---

## 🌍 Nome Internacional / International Name

* **Oficina dos Números** → **Numbers Workshop**

Maintaining the same conceptual identity.

---

## 📄 Licença / License

Apache License 2.0

---

🔧 *Oficina dos Números* — where data is crafted with rigor and curiosity.
