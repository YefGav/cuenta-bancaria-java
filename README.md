# Cuenta Bancaria Java 🏧

Este proyecto implementa un sistema de cuentas bancarias en Java siguiendo la metodología de **Test Driven Development (TDD)**. Se desarrollaron dos tipos de cuentas con comportamientos específicos y se acompañó cada funcionalidad con tests unitarios utilizando **JUnit 5** y **Hamcrest**.

## Funcionalidades

- **Account (Cuenta):**  
  - **Atributos protegidos:** saldo, número de consignaciones, número de retiros, tasa anual de interés y comisión mensual.
  - **Métodos:** consignar, retirar, calcular interés mensual, generar extracto mensual e imprimir información.

- **SavingsAccount (Cuenta de Ahorros):**  
  - **Estado activo/inactivo:** La cuenta es activa si el saldo es mayor o igual a 10,000.
  - **Comportamientos sobrescritos:**  
    - *deposit:* Permite reactivar la cuenta si el saldo alcanza o supera 10,000.
    - *withdraw:* Permite retirar dinero solo si la cuenta está activa y desactiva la cuenta si el saldo baja de 10,000.
    - *monthlyStatement:* Aplica una comisión adicional de 1000 por cada retiro extra (más de 4).
    - *print:* Muestra el saldo, la comisión mensual y el total de transacciones.

- **CheckingAccount (Cuenta Corriente):**  
  - **Sobregiro (overdraft):** Permite retirar más allá del saldo, registrando el monto del sobregiro.
  - **Comportamientos sobrescritos:**  
    - *withdraw:* Actualiza el overdraft permitiendo que el saldo se vuelva negativo.
    - *deposit:* Reduce primero el overdraft con el depósito recibido.
    - *monthlyStatement:* Utiliza la lógica común definida en la clase base.
    - *print:* Muestra el saldo, la comisión mensual, el total de transacciones y el valor del overdraft.

## Tecnologías Utilizadas

- **Java 11+**
- **JUnit 5:** Para escribir y ejecutar pruebas unitarias.
- **Hamcrest:** Para realizar aserciones en los tests.
- **TDD (Test Driven Development):** Cada funcionalidad se desarrolló escribiendo primero el test que falla y luego implementando el código para pasar el test.
- **PlantUML:** Para generar el diagrama de clases que modela el sistema.


