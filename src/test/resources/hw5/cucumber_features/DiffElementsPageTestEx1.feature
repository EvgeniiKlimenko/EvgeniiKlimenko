Feature: Different elements Page test
  In order to see logs while using UI elements
  As a user
  I want to go to Different elements Page and check selections UI elements

  Scenario: Select some UI elements and check logs for them
    Given I open JDI GitHub site
    Then Page title should be 'Home Page'
    When I login as user 'Roman Iovlev'
    Then name of logged in user should be 'ROMAN IOVLEV'
    When I click on 'Service' button in Header
    And I click on "Different elements" button in Service dropdown menu
    Then 'Different elements' page should be opened with page title 'Different Elements'
    When I click 'Water' and 'Wind' checkboxes
    And I click 'Selen' radiobutton
    And I click 'Yellow' in dropdown menu
    Then Names of all selected elements should be in log's texts