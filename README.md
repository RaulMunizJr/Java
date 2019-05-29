Useful References:

---------------Getting User Input---------------:
```
- import java.util.Scanner;
- Scanner myVar = new Scanner(System.in);
- Read a byte - nextByte()
- Read a short - nextShort()
- Read an int - nextInt()
- Read a long - nextLong()
- Read a float - nextFloat()
- Read a double - nextDouble()
- Read a boolean - nextBoolean()
- Read a complete line - nextLine()
- Read a word - next()
```
--------------Arrays---------------:
```
int[ ] arr;
int[ ] arr = new int[5];
arr[2] = 42;
String[ ] myNames = { "A", "B", "C", "D"};
.length

int[ ][ ] sample = { {1, 2, 3}, {4, 5, 6} }; 
```
--------------Loops---------------:
```
"Enhanced for loop" aka "for each"
int[ ] primes = {2, 3, 5, 7};
for (int t: primes) {
   System.out.println(t); 
}
```
||The 4 core concepts in OOP: encapsulation, inheritance, polymorphism, and abstraction.||
- --------------Encapsulation---------------:
```
"The packing of data and methods into a single component."
'The idea behind encapsulation is to ensure that implementation details are not visible to users. The variables of one class will be hidden from the other classes, accessible only through the methods of the current class. This is called data hiding.'
*To achieve encapsulation in Java, declare the class' variables as private and provide public setter and getter methods to modify and view the variables' values.*
class Example {
  private double balance=0;
  public void deposit(double x) {
    if(x > 0) {
      balance += x;
    }
  }
}
```
