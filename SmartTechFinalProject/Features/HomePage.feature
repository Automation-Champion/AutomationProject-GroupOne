@Homepage
Feature: User should be able to search property

Scenario: After login user should be able to search and choose property
When for properties search "New York, Lincolnshire"
And print price for all the properties
And select third property from the list
And verify agent name and phone number
Then logout from your account
