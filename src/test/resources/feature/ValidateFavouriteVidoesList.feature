@Hooks
Feature: Validate vidoes are getting added to favourite list

  @test_001
  Scenario: Validate vidoes are getting added to favourite list
    Given I launch discover website
    And I add two vidoes to favourite list
    When I navigate to my vidoes page
    Then I should see cooresponding vidoes with same name and title in my videos page
