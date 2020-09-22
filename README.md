# WAREHOUSE PRODUCT TRACKER

## Technologies stack used
Java 11, Maven, Spring Boot, Lombok, Jpa, H2

## How to access memory base?
In this project I have used in-memory H2 database. To access and view It's content use this link
```
http://localhost:8080/h2-console
Username:sa
password:password
```

## Get all products
This url will retrieve all products from database:
```
http://localhost:8080/api/v1/products
```
Data will be received like this
```
[
    {
        "id": 1,
        "productName": "Paper",
        "productDescription": "Very good",
        "expiryDate": "2023-06-19",
        "quantity": 50
    },
    {
        "id": 2,
        "productName": "Pizza",
        "productDescription": "frozen pizza",
        "expiryDate": "2021-04-01",
        "quantity": 100
    }
]
```
## Get product by ID
To received product by id use this url
```
http://localhost:8080/api/v1/products
```
This method for search for product with the same ID and the data will look like
```
{
    "id": 1,
    "productName": "Paper",
    "productDescription": "Very good",
    "expiryDate": "2023-06-19",
    "quantity": 50
}
```
## Create product
If you want to create new product you will need to use this url
```
http://localhost:8080/api/v1/products
```
To create product you will need to use JSON with body like this
```
{
    "id": 5,
    "productName": "test",
    "productDescription": "Very good",
    "expiryDate": "2023-06-19",
    "quantity": 50
}
```
## Delete product by ID
If you want to delete the product, you will need to pass the products ID as parameter
```
http://localhost:8080/api/v1/products/1
```
## Update product
To update product you will need to pass products you would like to update ID and JSON body of the updated product
```
http://localhost:8080/api/v1/products/1
```
JSON body should look like this
```
{
        "productName": "Changed name",
        "productDescription": "Changed Description",
        "expiryDate": "2025-05-23",
        "quantity": 39
}
```
## List of products with lesser than stated quantity
To get list of products with lesser than stated quantity, use this url. You must pass amount of quantity to get this working
```
http://localhost:8080/api/v1/products/quantity/55
```
With this url you will receive JSON like this
```
{
           "productName": "Paper",
           "productDescription": "Very good",
           "expiryDate": "2023-06-19",
           "quantity": 50
}
```
## List of products before stated date
To get list of products before stated date use this url
```
http://localhost:8080/api/v1/products/expiration/2021-05-05
```
This url will received you data like this
```

{
        "id": 2,
        "productName": "Pizza",
        "productDescription": "frozen pizza",
        "expiryDate": "2021-04-01",
        "quantity": 100
},
{
        "id": 3,
        "productName": "Meat",
        "productDescription": "fresh meat",
        "expiryDate": "2020-09-29",
        "quantity": 5153
}

```