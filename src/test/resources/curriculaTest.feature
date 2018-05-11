
@curriculaTest
Feature: To test curricula tab is working
  I want to run curricula functionality tests

 @defaultCurricula
 Scenario: Default Look of Curricula Tab
 
 Given navigate to curricula tab
 When curricula tab is clicked
 Then curricula default
 
 @expandButton
 Scenario: Collapse/Expand Functionality
 Given current tab is curricula
 When expand buttons are clicked
 Then information should expand/collapse
 
 @vpSkills
 Scenario: VP Login Skills Functionality
 Given navigate to curricula tab as vp
 When curricula tab clicked
 Then skills form default appear
