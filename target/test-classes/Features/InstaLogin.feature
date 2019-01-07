Feature: Insta Login Test
Scenario: Visit to Instagram.com for Invalid Login
Given Intialize the Browser Firefox 
And Vist to "https://www.instagram.com"
And click on login link and land on login page
When Enter the invalid details "username" and "Password" and log in
Then User is not successful logged in