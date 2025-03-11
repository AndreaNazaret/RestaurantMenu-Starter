Feature: Restaurant Menu


  Scenario: Choose Starter

    Given app start screen "Menu Sections"
    And app show text "Choose one..." on section "Starters"
    And app show price "0 euros" on section "Starters"
    And app show text "Choose one..." on section "Main Courses"
    And app show price "0 euros" on section "Main Courses"
    And app show text "Choose one..." on section "Desserts"
    And app show price "0 euros" on section "Desserts"
    And app show price "0 euros" on section "Total Price"

    When user press section "Starters"

    Then app start screen "Menu Items"
    And app show price "10 euros" on item "First Starter"
    And app show price "9 euros" on item "Second Starter"


  Scenario: Choose Main Course

    Given app start screen "Menu Sections"
    And app show text "Choose one..." on section "Starters"
    And app show price "0 euros" on section "Starters"
    And app show text "Choose one..." on section "Main Courses"
    And app show price "0 euros" on section "Main Courses"
    And app show text "Choose one..." on section "Desserts"
    And app show price "0 euros" on section "Desserts"
    And app show price "0 euros" on section "Total Price"

    When user press section "Main Courses"

    Then app start screen "Menu Items"
    And app show price "15 euros" on item "First Main Course"
    And app show price "18 euros" on item "Second Main Course"


  Scenario: Choose Dessert

    Given app start screen "Menu Sections"
    And app show text "Choose one..." on section "Starters"
    And app show price "0 euros" on section "Starters"
    And app show text "Choose one..." on section "Main Courses"
    And app show price "0 euros" on section "Main Courses"
    And app show text "Choose one..." on section "Desserts"
    And app show price "0 euros" on section "Desserts"
    And app show price "0 euros" on section "Total Price"

    When user press section "Desserts"

    Then app start screen "Menu Items"
    And app show price "7 euros" on item "First Dessert"
    And app show price "8 euros" on item "Second Dessert"


  Scenario: Choose First Starter

    Given app start screen "Menu Sections"
    And app show text "Choose one..." on section "Starters"
    And app show price "0 euros" on section "Starters"
    And app show text "Choose one..." on section "Main Courses"
    And app show price "0 euros" on section "Main Courses"
    And app show text "Choose one..." on section "Desserts"
    And app show price "0 euros" on section "Desserts"
    And app show price "0 euros" on section "Total Price"
    And user press section "Starters"
    And app start screen "Menu Items"
    And app show price "10 euros" on item "First Starter"
    And app show price "9 euros" on item "Second Starter"

    When user press item "First Starter"

    Then app resume screen "Menu Sections"
    And app show text "First Starter" on section "Starters"
    And app show price "10 euros" on section "Starters"
    And app show text "Choose one..." on section "Main Courses"
    And app show price "0 euros" on section "Main Courses"
    And app show text "Choose one..." on section "Desserts"
    And app show price "0 euros" on section "Desserts"
    And app show price "10 euros" on section "Total Price"
