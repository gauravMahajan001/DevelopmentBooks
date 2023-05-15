# DevelopmentBooks
Development Books is used for shop book.The user can shop books and get discount based on the book quantity. 

## Rules

The rules are described below :

- If, however, you buy two different books from the series, you get a 5% discount on those two books.
- If you buy 3 different books, you get a 10% discount.
- With 4 different books, you get a 20% discount
- If you go for the whole hog, and buy all 5, you get a huge 25% discount.
- Note that if you buy, say, 4 books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but       the 4th book still costs 50 EUR.

## Prerequisites

- Java - Version 17 
- SprintBoot - 3.0.6
- Maven - Dependency management
- JUnit - Version 5 or higher(added dependency in pom.xml)
- IDE - Eclipse or STS or any other IDE which supports Java

## Code commit guidelines


- feat: a new feature
- refactor: refactoring production code
- test: adding tests, refactoring test; no production code change
- chore: updating build tasks, package manager configs, etc; no production code change


## Steps to run the application in command prompt
```
1) Setup application as per above instructions.
2) Once application setup is completed,
   open command prompt at location <ProjectDirectory>\target
   and execute below command
   java -jar DevelopmentBooks-0.0.1-SNAPSHOT.jar
```
## Application url
```
url : http://localhost:8080/api/book/shop
```
## Request Body
```
 title : book name
 price : book price
 quantity : number of books
 
[{
	"title": "Clean Code",
	"price": 50.0,
	"quantity": 2
}, {
	"title": "The Clean Coder",
	"price": 50.0,
	"quantity": 2
}, {
	"title": "Clean Architecture",
	"price": 50.0,
	"quantity": 2
}, {
	"title": "Test Driven Development by Example",
	"price": 50.0,
	"quantity": 1
}, {
	"title": "Working Effectively With Legacy Code",
	"price": 50.0,
	"quantity": 1
}]
```
## Reponse Body
```
 totalPrice : total books price after discount
 booksCombination : combination of books
 booksName : books name per combination
 price : total books price after discount per combination 
 discount : discount percentage per combination
 totalBook : total number of books
 
{
    "totalPrice": 320.0,
    "booksCombination": [
        {
            "booksName": [
                "Clean Code",
                "The Clean Coder",
                "Clean Architecture",
                "Test Driven Development by Example"
            ],
            "price": 160.0,
            "discount": 20.0
        },
        {
            "booksName": [
                "Clean Code",
                "The Clean Coder",
                "Clean Architecture",
                "Working Effectively With Legacy Code"
            ],
            "price": 160.0,
            "discount": 20.0
        }
    ],
    "totalBook": 8
}
```