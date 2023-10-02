# hex-arch-app

References: https://github.com/PacktPublishing/Designing-Hexagonal-Architecture-with-Java


OpenAPI - https://www.baeldung.com/spring-rest-openapi-documentation

Error handlers - https://www.baeldung.com/global-error-handler-in-a-spring-rest-api

RabbitMQ 
- https://mmarcosab.medium.com/tutorial-rabbitmq-com-spring-boot-480e3a6682e6
- https://docs.spring.io/spring-amqp/reference/html/


@startuml

!theme plain
top to bottom direction
skinparam linetype ortho

class AbstractAuditable {
createdDate:  Date
lastModifiedDate:  Date
}
class AbstractPersistable {
id:  PK
}
class AccountData {
id:  Long
accountNumber:  String
accountStatus:  AccountStatusEnum
accountType:  AccountTypeEnum
currentBalance:  BigDecimal
dataOpened:  LocalDate
dateClosed:  LocalDate
}
class CustomerData {
id:  Long
customerType:  CustomerTypeEnum
}
class PersonData {
id:  Long
address:  String
dateOfBirth:  LocalDate
email:  String
firstName:  String
lastName:  String
phoneNumber:  String
taxIdentifier:  String
}
class TransactionData {
id:  Long
amount:  BigDecimal
transactionDate:  LocalDateTime
transactionType:  TransactionTypeEnum
}

AbstractAuditable    -[#595959,plain]-^  AbstractPersistable
AccountData         "0..*" <-[#595959,plain]-> "0..1" CustomerData        
AccountData         "0..1" <-[#595959,plain]-> "0..*" TransactionData     
CustomerData        "0..1" -[#595959,plain]-> "0..1" PersonData          
PersonData          "0..1" -[#595959,plain]-> "0..1" CustomerData        
@enduml
