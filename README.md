----------------------------------------------------------------------------------
     Welcome to the irexchange Coding Exercise!
-----------------------------------------------------------------------------------
If you can, please write a solution in a couple of different languages (say java and javascript) so that we can understand your proficiency in both.
 
Please share the solution through Github. Take as much time as you need. We perform these tests
to get a feel for how you approach problems, how you think, and how you design
your code.

Please do not share the test on social media (blogs facebook etc).

Thank you and have fun.

Consider the following children’s game:

* n children stand around a circle.
* Starting with a given child and working clockwise, each child gets a
sequential number, which we will refer to as it’s id.
* Then starting with the first child, they count out from 1 until k. The
k’th child is now out and leaves the circle. The count starts again
with the child immediately next to the eliminated one.
* Children are so removed from the circle one by one. The winner is the
child left standing last.

Write a method on a new class, which, when given n and k, returns the
sequence of children as they go out, and the id of the winning child. Create any
additional classes, tests, etc, you need to support the design of your solution.
 
## Decisions Made/Approach

* My general idea was starting with using a Tree as my primary data structure to store the data;
* However, after some thoughts I decided to come up to use single Linked List since I find that Linked List is straight-forward and easy to implement;
* I did not use any Mocking API like Mockito for this coding exercise since it is not required;
* Tests cases are included as part of the solution;

## Performance

* The search performance should be O(1) if the list only contains one element;
* The search performance should be O(n) if the list contains n-th element;
* Overall performance should be O(n) since the algorithm only iterate through the list once, record between previous and next node, and perform a swap
between head and tail of the linked list.

Please feel free to reach out to us if you have any questions or concerns.

## Improvements

* Write any interface to interact between inputs due to time constraint;
* Create bundle the code in JAR file due to time constraint;
* Write a better instructions on how to run the code due to time constraint;

## HOWTO run

To execute the solution, simply go to the Main glass and run program in any IDE.