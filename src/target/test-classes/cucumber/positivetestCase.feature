@tag
Feature: Purchase the order from Amazon website
  I want to use this template for my feature file
  
  Background:
  Given landing on Amazon Ecommerce Website

  @PurchaseOrder
  Scenario Outline: Positive Test of Submitting the Amazon order
    Given Logged in with username <mail> and password <password>
    When  <Product> user searching the product
    When checkout <productName> and submit the order
    Then the <confirmation> message is displayed on confirmationPage

    Examples: 
      | mail       |   password    | Product                     |productName                            |  confirmation              |
      | 9591509873 |     Ammi@7207 | Minimalist Face Serum       |Minimalist 10% Vitamin C Face Serum    | Order placed, thank you!   |
     #| 9591509873 |     Ammi@7207 | Minimalist Face Serum       |Minimalist 10% Vitamin C Face Serum    | Order placed, thank you!   |
