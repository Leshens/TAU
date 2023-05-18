Feature: Cart

  Scenario: AddingToCart
    Given User is loged in
    When User adds item to cart
    And go to cart
    Then He should see item in cart

  Scenario: RemoveFromCart
    Given User has item in cart
    When User remove item from cart
    Then He cart should be empty
