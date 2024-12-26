Feature: login functionality
  Background:
    Given user is on the login page

  Scenario: verify the login page with valid credentials
    Given the user should enter valid username and password
    When user should click on the login button
    Then verify the system should login successfully