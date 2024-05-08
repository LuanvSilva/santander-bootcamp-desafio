#Santander dev week 2024


##Diagrama de Classe
```mermaid
classDiagram
    class User {
        - String name
        - Account account
        - Features features
        - Card card
        - News news
    }

    class Account {
        - String number
        - String agency
        - Float balance
        - Float limit
    }

    class Features {
        - String icon
        - String description
    }

    class Card {
        - String number
        - Float limit
    }

    class News {
        - String icon
        - String description
    }

    User "1"*--"1" Account
    User "1"*--"N" Features
    User "1"*--"1" Card
    User "1"*--"N" News

```
