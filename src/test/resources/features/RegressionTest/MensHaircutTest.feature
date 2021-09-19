Feature: Haircut - Mens Test

@UI
Scenario Outline: Verify User Able To Select Haircut For Mens Successfully

	Given I Select Chrome Browser To Launch URL "<URL>" For Test Execution
	Then I Verify Home Page is Loaded Successfully
	When I Enter Service Search as "<ServiceSearch>"; in Home Page
	When I Click On Service Option as "<ServiceSearch>" from drop-down; in Home Page
	When I Enter Location as "<Location>"; in Home Page
	When I Click On Search Button; in Home Page
	Then I Verify Multiple Search Results Displayed for User Searched Service; in Haircut Page
	When I Click On Business Name as "<BusinessName>"; in Haircut Page
	Then I Verify Saber Haircut Page loaded Successfully
	When I Click On All Business Services; in Saber Haircut Page
	When I Click On Second Staff in Filter From Staff Member Option; in Saber Haircut Page
	When I Store Results of "<GenderType>" Gender Haircut Details; in Saber Haircut Page
	When I Click On "<GenderType>" Gender Type Book Button; in Saber Haircut Page
	When I Click On Select Time Button; in Saber Haircut Page
	Then I Verify Atleast Two Time Slots Availale for Haircut Booking; in Saber Haircut Page
	Then I Compare Details Stored for "<GenderType>" is same as Details Displayed in Saber Haircut Page

@UITest
Examples:
| URL                              | ServiceSearch | Location          | BusinessName      | GenderType |
| https://www.mytime.com/consumers | haircut       | San Francisco, CA | Test - Sabre Cuts | Men        |