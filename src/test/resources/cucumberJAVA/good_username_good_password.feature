Feature: Can I login?
  Testing if i can log in

  Scenario Outline: Login with credentials
    Given I am at saucedemo.com page
    When I put "<username_s>" as username and "<password_s>" as password and click login button
    Then On top of page should be "<answer>"

    Examples:
      | username_s    | password_s    | answer      |
      | standard_user | standard_user | .app_logo   |
      | secret_sauce  | secret_sauce  | .login_logo |
      | secret_sauce  | standard_user | .login_logo |
      | standard_user | standard_user | .login_logo |

    #https://www.youtube.com/watch?v=W1Y6amceFi0