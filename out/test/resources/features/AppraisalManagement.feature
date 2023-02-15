@AddGoalsAppraisalManagement
Feature: MIS AppraisalManagement


  Background:
    Given Verify beta-mis is open and loaded successfully.
    When User logins into application with username "arpit.mishra" and password "Gemini@123"
    Then Verify beta-mis Dashboard page opens

  @app1 @Fail1
  Scenario: Navigate to add goal page and verify Add goal window
    Then Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Click on "Add/Update goal button" button.
    And Verify Add goal window opens.
    Then Click on "Close add goal button" button.
    And Verify add goal window is closed.

  @Fail2 @rerun_web
  Scenario: Verify financial year dropdown
    Then Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    And Verify that "Add My Goal/Team Goal" text is present on the current page.
    Then Click on "Financial year dropdown" button.
    And Verify all elements are available in dropdown.
    Then Choose current financial year.
    And Verify that "Add My Goal/Team Goal" text is present on the current page.

  @Fail3
  Scenario: Verify link for list of KRAs and KPIs
    Then Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    And Verify that "Add My Goal/Team Goal" text is present on the current page.
    Then Click on "List of KRAs and KPIs link" button.
    Then Verify link is open on the same tab.

  @Fail4 @rerun_web
  Scenario: Add new KPI/KRA mapping in add goal window and validate add KPI button
    Then Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    And Verify that "Add My Goal/Team Goal" text is present on the current page.
    Then Click on "Financial year dropdown" button.
    And Verify all elements are available in dropdown.
    Then Choose current financial year.
    And Verify that "Add My Goal/Team Goal" text is present on the current page.
    When Click on "Add KPI/KRA button" button.
    Then Select "Creative" from Goal type dropdown.
    Then Enter "KRADemo" in "KRA" text field.
    When Click on "Add KPI button" button.
    Then Verify "Add KPI description text field" is visible on the current screen Appraisal.
    Then Enter "Demo" in "KPI description" text field.
    And Click on "Submit add button" button.

  @Fail5 @rerun_web
  Scenario: Verify warning popup appears when KPI/KRA fields are left empty
    Then Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    And Verify that "Add My Goal/Team Goal" text is present on the current page.
    Then Click on "Financial year dropdown" button.
    And Verify all elements are available in dropdown.
    Then Choose current financial year.
    And Verify that "Add My Goal/Team Goal" text is present on the current page.
    When Click on "Add KPI/KRA button" button.
    Then Select "Creative" from Goal type dropdown.
    Then Enter "KRADemo" in "KRA" text field.
    And Click on "Submit add button" button.
    Then Verify Warning popup appear which says "No KPI's have been added.".
    When Click on "Add KPI button" button.
    Then Verify "Add KPI description text field" is visible on the current screen Appraisal.
    Then Enter "Demo" in "KPI description" text field.
    And Click on "Submit add button" button.
    Then Verify Success pop appears which says "KPI's are added successfully!"

  @new_fail @rerun_web
  Scenario: Verify adding data in each field
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then User Clicks on "add goals" button
    And User selects "Defect Rate - x%" in KPI
    And enters "Active Project" value in project
    And enters "Active Goal Desc" value in goal description
    Then User clicks on "Engineering" nav tab
    And selects "QA" in Primary Skill
    Then User clicks on "Behavioural" nav tab
    Then Fill a field in "Behavioural" tag
    Then User clicks on "Creative" nav tab
    Then Fill a field in "Creative" tag
    Then User Clicks on "draft" button
    Then Verify "Success" popup appears
    Then User Clicks on "close" button

  @23_Jan_B2
  Scenario: Verify Add/Delete of new KPI Row
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then User Clicks on "add goals" button
    Then User clicks on "Engineering" nav tab
    Then click on "Add" option in add new KPI row.
    And verify KPI row added.
    Then click on "Delete" option in add new KPI row.
    And verify KPI row removed.

  @23_Jan_B2
  Scenario: Verify entry counts
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then Select "25" from the rows dropdown.
    And verify number of rows from lower left.

  @rerun_web
  Scenario: Verify page navigation
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then verify number of pages in lower right corner.
    Then click on next to check navigation and verify.

  @Fail6 @rerun_web
  Scenario: verify export button functionality
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    And  Click on "export in add goals" button.
    Then verify "Copy" option clickable and present.
    Then verify "PDF" option clickable and present.
    Then verify "Excel" option clickable and present.
    Then verify "Print" option clickable and present.

  @TestColSorting @rerun_web
  Scenario: verify column sorting working or not
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    And click on sorting button on first.
    Then verify sorting performed.

  @search     @new_fail2 @rerun_web
  Scenario Outline: Verify searches
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then User Clicks on "add goals" button
    And User selects "Defect Rate - x%" in KPI
    And enters "<projName>" value in project
    And enters "<goalDesc>" value in goal description
    Then User clicks on "Engineering" nav tab
    And selects "QA" in Primary Skill
    Then User Clicks on "draft" button
    Then Verify "Success" popup appears
    Then User Clicks on "close" button
    Then search "<searchQuery>" in search input
    And verify "<searchQuery>" in the search results


    Examples:
      | projName       | goalDesc    | searchQuery    |
      | Active Project | Active Goal | Active Project |
      | Active Project | Active Goal | ****           |

  @DeleteWithoutRemark    @rerun_web
  Scenario: check delete with remark and without remark
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then User Clicks on "add goals" button
    And User selects "Defect Rate - x%" in KPI
    And enters "Active Project" value in project
    And enters "Active Goal" value in goal description
    Then User clicks on "Engineering" nav tab
    And selects "QA" in Primary Skill
    Then User Clicks on "draft" button
    Then Verify "Success" popup appears
    Then User Clicks on "close" button
    And verify "Active Project" and "Active Goal" present
    Then User Clicks on "delete" button
    And clicks on submit button "without remark"
    Then verify error in submission
    And clicks on submit button "with some remark"
    Then verify submitted successfully


  @SubmitGoals @Fail7 @new_fail4 @rerun_web
  Scenario: Submit Goals
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then User Clicks on "add goals" button
    And User selects "Defect Rate - x%" in KPI
    And enters "project123" value in project
    And enters "goal123" value in goal description
    Then User clicks on "Engineering" nav tab
    And selects "QA" in Primary Skill
    Then User Clicks on "draft" button
    Then Verify "Success" popup appears
    Then User Clicks on "close" button
    Then User Clicks on "submit goal" button

  @new_fail5 @rerun_web
  Scenario: click on draft without filling any fields
    When Click on "Add Goals" Sub Tab inside "Appraisal Management" tab.
    Then Verify Add Goals tab opens
    Then User Clicks on "add goals" button
    Then User clicks on "Engineering" nav tab
    And selects "Select" in Primary Skill
    Then User Clicks on "draft" button
    Then Verify "Warning" popup appears
    Then User clicks on "Engineering" nav tab
    And selects "QA" in Primary Skill
    Then User Clicks on "draft" button
    Then Verify "Success" popup appears
    Then User Clicks on "close" button
