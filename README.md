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
- --------------Polymorphism---------------:
```
"Polymorphism, which refers to the idea of "having many forms", occurs when there is a hierarchy of classes related to each other through inheritance."

Here is an example: Dog and Cat are classes that inherit from the Animal class. Each class has its own implementation of the makeSound() method.

class Animal {
  public void makeSound() {
    System.out.println("Grr...");
  }
}
class Cat extends Animal {
  public void makeSound() {
    System.out.println("Meow");
  }
}
class Dog extends Animal {
  public void makeSound() {
    System.out.println("Woof");
  }
}

As all Cat and Dog objects are Animal objects, we can do the following in main:

public static void main(String[ ] args) {
  Animal a = new Dog();
  Animal b = new Cat();
}

a.makeSound();
//Outputs "Woof"

b.makeSound();
//Outputs "Meow"
```
|||Overriding & Overloading|||
- --------------Overriding---------------:
```
"A subclass can define a behavior that's specific to the subclass type, meaning that a subclass can implement a parent class method based on its requirement."

class Animal {
    public void makeSound() {
        System.out.println("Grr...");
    }
}
class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}

Cat class overrides the makeSound() method of its superclass Animal.

Rules for Method Overriding:
- Should have the same return type and arguments
- The access level cannot be more restrictive than the overridden method's access level (Example: If the superclass method is declared public, the overriding method in the sub class can be neither private nor protected)
- A method declared final or static cannot be overridden
- If a method cannot be inherited, it cannot be overridden
- Constructors cannot be overridden
```
- --------------Overloading---------------:
```
"When methods have the same name, but different parameters, it is known as method overloading.
This can be very useful when you need the same method functionality for different types of parameters.
```
- --------------ArrayList---------------: Use an ArrayList when you need rapid access to your data. 
```
import java.util.ArrayList;

public class MyClass {
  public static void main(String[ ] args) {
    ArrayList<String> colors = new ArrayList<String>();
    colors.add("Red");
    colors.add("Blue");
    colors.add("Green");
    colors.add("Orange");
    colors.remove("Green");

    System.out.println(colors);
  }
}
// Output: [Red, Blue, Orange]

Other useful methods include the following:
- contains(): Returns true if the list contains the specified element 
- get(int index): Returns the element at the specified position in the list
- size(): Returns the number of elements in the list
- clear(): Removes all of the elements from the list

Note: As with arrays, the indexing starts with 0.
```
- --------------LinkedList---------------: Use a LinkedList when you need to make a large number of inserts and/or deletes.
```
LinkedList<String> c = new LinkedList<String>();
c.add("Red");
c.add("Blue");
c.add("Green");
c.add("Orange");
c.remove("Green");

for(String s: c) {
  System.out.println(s);
}
/* Output:
Red
Blue
Orange
 */
```
- --------------HashMap---------------:
```
"Used for storing collection of the data in the form of key and value pairs."
'One object is used as a key (index) to another object (the value).'

*The put, remove, and get methods are used to add, delete, and access values in the HashMap.*
import java.util.HashMap;
public class MyClass {
  public static void main(String[ ] args) {
    HashMap<String, Integer> points = new HashMap<String, Integer>();
    points.put("Amy", 154);
    points.put("Dave", 42);
    points.put("Rob", 733);
    System.out.println(points.get("Dave")); 
  }
}
// Outputs 42

HashMap with Strings as its keys and Integers as its values.

Use the get method and the corresponding key to access the HashMap elements.

A HashMap cannot contain duplicate keys. Adding a new item with a key that already exists overwrites the old element.
The HashMap class provides containsKey and containsValue methods that determine the presence of a specified key or value.
If you try to get a value that is not present in your map, it returns the value of null. 
```
- --------------Sets---------------:
```
"A Set is a collection that cannot contain duplicate elements. It models the mathematical set abstraction."
'One of the implementations of the Set is the HashSet class.'

import java.util.HashSet;

public class MyClass {
  public static void main(String[ ] args) {
    HashSet<String> set = new HashSet<String>();
    set.add("A");
    set.add("B");
    set.add("C");
    System.out.println(set);
  }
}
//  Output: [A, B, C]

You can use the size() method to get the number of elements in the HashSet.
```
