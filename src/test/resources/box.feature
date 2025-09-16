@boxes
Feature: create boxes
  Let's create different types of boxes

  @box
  Scenario: Create box
    Given create box with width 5 and height 10 and depth 4
    Then I get volume 200

  @cube
  Scenario: Create cube
    Given create box with width 3 and height 3 and depth 3
    Then I get volume 27
