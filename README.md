# Shopping-Cart
-Shopping cart servlet code -
Write a set of cooperating servlets to do the followings:
• Identify a user using login servlet
– The user should be able to log in and log out from the system
• Show a list of products, allowing the user to add them to a cart
– You do not need to extract the list of items from any database. You can hard code
the list of items that a user can view and add to their cart.
• Allows viewing the content of the cart, update contents of the cart
– The user should be able to see exactly which items they have added to the cart.
– The user should be able to update the cart i.e. add/remove items, and edit the
number of a certain item they wish to purchase
– As long as the user remains logged in in the system, they should be able to see the
content of their cart from any page
• Allows checking out by simulating a payment and emptying the cart
– The cart should be emptied when the user checks out
• Optional operation: If a user has previously added any item to their cart, log out, and
logs back in, they should be able to view the items they had added earlier in their cart.
This operation will require some kind of database function. Bonus marks if you can
complete it!
NOTE: You can use either Cookie or HttpSession or a combination of both to handle shopping
cart and login information.
