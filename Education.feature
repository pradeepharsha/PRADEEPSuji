Feature: I am automation functionality of Add Jobs in Orange HRM Application 

   Background: Common step
        Given User launch crome browser
        When User Oper URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
   
   Scenario: Successfull Login with valid page
    And User enters username as "Admin" and password as "admin123"
    Then Go to Qualifications Page
    When Add Education with educationname as "EngineeringScience" 
    When Click on logout button
    Then Close Browser
    
   # Scenario: Successfull Login with valid page
    #And User enters username as "Admin" and password as "admin123"
    #Then Go to Nationality Page
    #When Add nationality record  as "indian0322"
    #When Click on logout button
    #Then Close Browser