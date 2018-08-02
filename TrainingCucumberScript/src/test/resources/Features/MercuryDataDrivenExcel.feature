Feature: Mercury Testing Register link functionlaity Using Excel

Scenario Outline: Mercury multiple user registration

Given Open Mercury Flights website
When Click on Registration link
And Populate data from "<Registration>" "<row>"
Then Validate created user "<row>"