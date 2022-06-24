

Feature: Login to the application

  
  Scenario: Validating user login
    Given I am on the chrome browser
    When I navigated to the "https://courses.rahulshettyacademy.com/" link
    And I click on the Login button on the landing page
    And I enter <username> and <password> and try to login
    Then I should be successfully logged in to the application

    Examples: 
      | username  										| password 	|
      | dubeysuraj38@gmail.com 				| Suraj@811 | 
      | dubeysuryaprakash1@gmail.com 	| Suraj@811 | 
