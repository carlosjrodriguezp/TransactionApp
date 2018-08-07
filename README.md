# TransactionApp

As part of the PayClip technical assessment, the following app covers all the requirements described in shared text send by email.

## Installation
Java 8 SDK and JRE are needed in order to compile and execute locally.

## Usage
The Transaction app process 4 basic operation from the command line: add transaction, list transactions, show transaction and sum transactions.
The proper commands for executing the different opperations:

#### ADD TRANSACTION
`java -jar TransactionApp-1-jar-with-dependencies.jar <user_id> add "<{json_data}>"`

You need to specify the `user_id` value and the `json_data` string.
This command will store the json data in a local file name `data-stored`.

#### LIST TRANSACTION
`java -jar TransactionApp-1-jar-with-dependencies.jar <user_id> list`

You need to specify the `user_id` in order to list all the transactions contained in the `data-stored` file.

#### SHOW TRANSACTION
`java -jar TransactionApp-1-jar-with-dependencies.jar <user_id> <transaction_id>`

This command will show the specific transaction.

#### SUM TRANSACTION
`java -jar TransactionApp-1-jar-with-dependencies.jar <user_id> sum`

This command will show the amount field sum from all the transactions for the specific `user_id`.
