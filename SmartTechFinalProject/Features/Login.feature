@Login
Feature: User should able to login successfully

Scenario: Login Function should work properly as per requirements
Given open the browser
And navigate to "https://www.zoopla.co.uk/"
And click on Sign in from upper right corner 
When enter username "Refat29@yahoo.com" and password "newyork1975"
And click sign in button
Then user should be landed in homepage