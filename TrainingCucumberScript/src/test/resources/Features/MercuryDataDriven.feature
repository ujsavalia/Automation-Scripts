#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
Feature: Testing the User regisration with multiple set of data

#@tag2
Scenario Outline: Testing the user registartion with multiple set of data
Given Navigate to the application datadriven
When Click on register link datadriven
And Enter "<username>" "<password>" "<confirmpassword>" values, click on register button
Then user "<username>" created sucesful
And Close application datadriven

Examples:
    | username  | password 	| confirmpassword |
    | john 		| test123   | test123		  |
    | mercury   | test12345 | test12345       |