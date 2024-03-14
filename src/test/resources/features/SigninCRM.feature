Feature: Sign in page CRM

  @Regression
  Scenario Outline: Sign in CRM with an email valid
    Given User navigate to url "<url>"
    When User login with username "<username>" and password "<password>" valid
    Then The user redirect to Dashboard page
    Examples:
      | url                                | username       | password |
      | https://rise.fairsketch.com/signin | admin@demo.com | harijava002 |

  @Smoke
  Scenario Outline: Sign in CRM with an email invalid
    Given User navigate to url "<url>"
    When User login with username "<username>" and password "<password>" invalid
    Then The user can not redirect to Dashboard page
    And The error message is displays
    Examples:
      | url                                | username          | password |
      | https://rise.fairsketch.com/signin | harijava002@yopmail.com | harijava002 |
      
      
       @checkinvoice
  Scenario Outline: to check invoice details
    Given User navigate to url "https://rise.fairsketch.com/signin"
    When User login with username "harijava002@yopmail.com" and password "harijava002" valid
    Then click the store
    Then Add to card "<Product>" for the given product
    Then click checkout
    Then click submit
    
     Examples:
      | Product   |
      | Art pictures|
      |Content writing |
      |Website Design|
      
      
         @store 
  Scenario Outline: to check we are in store page
    Given User navigate to url "https://rise.fairsketch.com/signin"
    When User login with username "harijava002@yopmail.com" and password "harijava002" valid
    Then click the store
    Then verify the store page title
    
    
    @checkout
  Scenario Outline: to check checkout page
    Given User navigate to url "https://rise.fairsketch.com/signin"
    When User login with username "harijava002@yopmail.com" and password "harijava002" valid
    Then click the store
    Then Add to card "Art pictures" for the given product
    Then click checkout
     Then verify the checkout title
     
       @checkproduct
  Scenario Outline: to check invoice details
    Given User navigate to url "https://rise.fairsketch.com/signin"
    When User login with username "harijava002@yopmail.com" and password "harijava002" valid
    Then click the store
    Then Add to card "<Product>" for the given product
    Then click checkout
    Then click submit
    Then verify product the "<ProductName>" in invoice
    
     Examples:
      | Product        |  ProductName  |
      | Art pictures   | Art pictures  |  
      |Content writing | Art pictures  |
      |Website Design  | Art pictures  |