# computerV1
Polynomial equation solver (degree 0, 1, 2), including non-real solutions, without use of any math libraries

# How to run
Make sure you have the means to run java applications, such as having a JRE installed on your machine or by use of an IDE such as IntelliJ or Netbeans

# Usage
-simply run the application and enter an equation in the following form:
a * X^0 + b * X^1 + c * X^2 = d * X^0 + e * X^1 + f * X^2
keep order X^0->X^1->X^2

-Must include all terms up to desired degree eg:
degree 1: 1 * X^0 + 1 * X^1 = 1 * X^0 + 1 * X^1
degree 2: 1 * X^0 + 1 * X^1 + 1 * X^2 = 1 * X^0 + 1 * X^1 + 1 * X^2
use coefficient of 0 to disregard a term.

-replace a,b,c,d,e,f with desired coefficients eg:
0 * X^0 + 1 * X^1 + 2 * X^2 = 3 * X^0 + 4 * X^1 + 5 * X^2

-can replace '+' with '-', use negative coefficients, fractions or decimal coefficients eg:
-1 * X^0 + 2.43 * X^1 - 3/4 * X^2 = 4 * X^0 - -5.2 * X^1 + 6/-3 * X^2

# Results
-provides reduced form:
a * X^0 + b * X^1 + c * X^2 = 0

-provides polynomial degree:
0/1/2, deplays appropriate message for polynomial degrees > 2

-provides discriminant info for polynomial degree = 2:
Discriminant is positive/negative/0

-provides solutions (including non-real solutions)

-special cases for polynomial degree 0:
"No solutions" or "All real numbers are a solution" will be displayed in special cases such as 1 ∗ X^0 = 2 ∗ X^0 or 1 ∗ X^0 = 1 ∗ X^0 etc
