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

In summary, encapsulation provides the following benefits:
- Control of the way data is accessed or modified
- More flexible and easily changed code
- Ability to change one part of the code without affecting other parts
```
- --------------Inheritance---------------:
```
"A process by which one class inherits the members and methods of another class."
'Inheritance is the process that enables one class to acquire the properties (methods and variables) of another. With inheritance, the information is placed in a more manageable, hierarchical order.

The class inheriting the properties of another is the subclass (also called derived class, or child class); the class whose properties are inherited is the superclass (base class, or parent class).'

*To inherit from a class, use the extends keyword. 
This example shows how to have the class Dog to inherit from the class Animal.*

class Dog extends Animal {
 // some code
}

Here, Dog is the subclass, and Animal is the superclass.
```
