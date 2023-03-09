# Banking-App
## Descripción del proyecto

Proyecto creado con arquitectura hexagonal para la creación de cuentas y transferencia entre cuentas.

### 1. Capacidades de la aplicación:
   * Creación de cuentas 
   * Consulta de todas las cuentas
   * Consulta de cuentas por número de cuenta
   * Realizar transferencia entre cuentas
### 2. Base de datos en memoria
   * schema.sql -> Realiza la creación del schema de la base de datos
   * data.sql -> Creación de cuentas
### 3. Enpoint de entrada al sistema
   * GET /api/account - Listar todas cuentas
     * Response: ```[{
       "id": 1,
       "accountNumber": "024779",
       "balance": 1000000 },
       {
       "id": 2,
       "accountNumber": "412789",
       "balance": 10000000
       }
       ]```
   * POST /api/account - Crear una cuenta
     * Request ```{
       "id": 3,
       "accountNumber": "024778",
       "balance": 10000
       }```
     * Response ```{
       "id": 3,
       "accountNumber": "024778",
       "balance": 10000
       }```
   * GET /api/account/{numero_de_cuenta} - Listar una cuenta por número
     * result ```{
       "id": 3,
       "accountNumber": "024778",
       "balance": 10000
       }```
   * POST /api/account/transfer - Realizar una transferencia entre cuentas
     * Response ``` {
       "id": 3,
       "senderAccount": "024779",
       "recipientAccount": "412789",
       "amount": 10000
       }```
     * Response ``` {
       "transactionRef": "4aa9f0e7-c42f-431b-b763-7c514ce81c7a"
       }```