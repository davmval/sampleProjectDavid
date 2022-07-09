Feature: Modification of profile details on OrangeHRM Page

  @MyInfo
  Scenario: Admin will edit details on profile
    Given admin is on My Info tab
    And admin is on Contact details subsection
    When admin edits details
    Then saves the edited details

  @MyInfo
  Scenario: Admin adds immigration information on profile page
    Given admin is on My Info tab
    And admin is on Immigration subsection
    When admin enters new immigration details
    Then the immigration details can be viewed

  @MyInfo
  Scenario: admin adds a language
    Given admin is on My Info tab
    And admin is on Qualifications subsection
    When admin adds a new language
    Then the language profile is updated