Feature: login page feature

Background: 
Given user is on login page

Scenario Outline: login successfully with valid credentials
When user enter email "<email>" and password "<password>"
And user click on login button
Then page title should be "<title>"
Examples:
|email|password|title|
|admin@yourstore.com|admin|Product tags / nopCommerce administration hvnmv|