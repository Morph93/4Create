@UI @4Create
Feature: Login scenarios


  @FirstTC
  Scenario: Verify that the homepage is displayed correctly
    Then All elements should be present on home page

  @SecondTC
  Scenario: Add items to the basket
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    Then Validate number of items that are added

  @BonusTC
  Scenario: Add cheapest, most expensive and random item to the basket
    Then I add the cheapest, most expensive and random item to the basket

  @ThirdTC
  Scenario: Check if error message is displayed for incorect promo code
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Enter promo code that's totalAmount
    Then Verify if the error message is displayed

  @FourthTC
  Scenario: Check if user is redirected to choose county page after placing the order
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    Then User should be redirected to Choose country page

  @FifthTC
  Scenario: Validate that select is disabled in country dropdown list
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    And  Open country list
    Then Validate that the Select is disabled

  @SixthTC
  Scenario: Check if proper order confirmation message is shown
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    And  Open country list
    And  Choose random country from the list
    And  Accept tac and proceed with order
    Then User should be presented with order confirmation message

  @SeventhTC
  Scenario: Validate redirection to actions page
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    And  Open country list
    And  Choose random country from the list
    And  Accept tac and proceed with order
    And  Go to webDriverUniversity page
    And  Scroll to the Actions section
    And  Take a screenshot
    And  Click on Actions
    And  Go back to Homepage tab
    And  Take a screenshot
    And  Go back to third tab Actions
    Then User should be redirected to Actions page

  @EightTC
  Scenario:  Test drag and drop functionality
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    And  Open country list
    And  Choose random country from the list
    And  Accept tac and proceed with order
    And  Go to webDriverUniversity page
    And  Scroll to the Actions section
    And  Take a screenshot
    And  Click on Actions
    And  Go back to Homepage tab
    And  Take a screenshot
    And  Go back to third tab Actions
    Then Drag and drop target box

  @NinthTC
  Scenario: Validate that the link is not displayed if not hovered upon
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    And  Open country list
    And  Choose random country from the list
    And  Accept tac and proceed with order
    And  Go to webDriverUniversity page
    And  Scroll to the Actions section
    And  Take a screenshot
    And  Click on Actions
    And  Go back to Homepage tab
    And  Take a screenshot
    And  Go back to third tab Actions
    And  Drag and drop target box
    Then Validate that Link isn't shown until mouse is hovered on it

  @TenthTC
  Scenario: Validate that the list is displayed after hovering on the element
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    And  Open country list
    And  Choose random country from the list
    And  Accept tac and proceed with order
    And  Go to webDriverUniversity page
    And  Scroll to the Actions section
    And  Take a screenshot
    And  Click on Actions
    And  Go back to Homepage tab
    And  Take a screenshot
    And  Go back to third tab Actions
    And  Drag and drop target box
    And  Hover over first hover element
    Then Validate that Link is shown after mouse is hovered on it

  @EleventhTC
  Scenario: Input previously saved message into the comment text box
    When I add 1 item 4 times in the basket
    And  I add 3 item 1 times in the basket
    And  Proceed to checkout
    And  Click to place the order
    And  Open country list
    And  Choose random country from the list
    And  Accept tac and proceed with order
    And  Go to webDriverUniversity page
    And  Scroll to the Actions section
    And  Take a screenshot
    And  Click on Actions
    And  Go back to Homepage tab
    And  Take a screenshot
    And  Go back to third tab Actions
    And  Drag and drop target box
    And  Hover over first hover element
    And  Click on link that appears after hover
    And  Save alert message and click OK
    And  Close browser
    And  Open browser again and go to contact us page
    Then  Input saved alert message into comment text box