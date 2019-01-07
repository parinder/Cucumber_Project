Feature: Facebook Application Login

Scenario: Visit to facebook.com
Given user on facebook login page
When Enter the valid login details - username & Password
Then User should see the profile hompage with feeds

Scenario: Visit to facebook.com
Given user on facebook login page
When Enter the invalid login details - username & Password
Then User should see the error Message