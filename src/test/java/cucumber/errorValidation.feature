@tag
Feature: Error Validation
  I want to use this template for my feature file
  
   Background:
  Given landing on Amazon Ecommerce Website

  @ErrorValidation
  Scenario Outline: validating the error message
     Given Logged in with username <mail> and password <password>
     Then <errormsgg> message is displayed

    Examples: 
      | mail          |   password     | errormsgg                   |
      | numberrrrr    |     Passwordd  | Your password is incorrect  |
