Feature: As a user I want to see the home page so I can use the app

    Background: The app is open
        Given User is on the home page

    Scenario: Home Page loads
        When The user clicks multiple times the button
        Then The counter shows the number of clicks



