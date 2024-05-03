# 🪙Currency Converter

Api developed to do currency converter as a dev challenge. This currency converter avaible 
4 currencys ( BRL, USD, EUR, JPY ).

## 🛠️Tech's
- Spring Boot
- Spring Data JPA
- Swagger
- Lombok

## 🚀How to run
- Clone git repository
- Run: 
````
 mvn clean package
 java -jar target/api-currency-converter-0.0.1-SNAPSHOT.jar
````
The API can be acessed at <a href="http://localhost:8080">localhost:8080</a>
The Swagger at <a href="http://localhost:8080/swagger-ui.html">localhost:8080/swagger-ui.html</a>

## 📚API Endpoints
### 🗨️Obs
The API automatically create two users when starts: <br>
``````
{                                    {
    "id": 1,                            "id": 2,
    "name": "Alpha"                     "name": "Beta"
}                                     }
``````
<b>Important: The API deletes all users when start's again.</b>

### 🎯Endpoints

- Create Transaction
````
http POST http://localhost:8080/transactions

{
    "userId": 1,
    "originCurrency": "BRL",
    "originValue": 100,
    "destinationCurrency": "EUR"
}
````

- Get Transactions
````
http GET http://localhost:8080/transactions

[
    {
        "id": 1,
        "userId": 1,
        "originCurrency": "BRL",
        "originValue": 100.0,
        "destinationCurrency": "EUR",
        "destinationValue": 18.35,
        "conversionRate": 0.1835,
        "date": "2024-05-03"
    }
]
````


- Get Transaction by id
````
http GET http://localhost:8080/transactions/1

{
    "id": 1,
    "userId": 1,
    "originCurrency": "BRL",
    "originValue": 100.0,
    "destinationCurrency": "EUR",
    "destinationValue": 18.35,
    "conversionRate": 0.1835,
    "date": "2024-05-03"
}

````
- Get Transactions by User id
````
http GET http://localhost:8080/transactions/user/1

[
    {
        "id": 1,
        "userId": 1,
        "originCurrency": "BRL",
        "originValue": 100.0,
        "destinationCurrency": "EUR",
        "destinationValue": 18.35,
        "conversionRate": 0.1835,
        "date": "2024-05-03"
    }
]
````