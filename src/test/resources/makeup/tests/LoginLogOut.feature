Feature: User login

  Scenario: Valid Login
    Given User is on the Login Page
    When User enters valid credential
      | Username                       | Password |
      | anastasiavictorivna1@gmail.com | Zse45aw3 |

  Scenario: Invalid Login
    Given User is on the Login Page
    When User enters invalid credential
      | Username                       | Password |
      | anastasiavictorivna11@gmail.com |Qwerty12!! |
    Then User should be able to see error message "Zbyt dużo nieudanych prób. Spróbuj ponownie później lub skorzystaj z funkcji \"Nie pamiętam hasła\"."
