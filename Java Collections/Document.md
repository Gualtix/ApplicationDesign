# Java Collections

Java Collections is a Framework that contains a group of classes and interfaces that provides
a "Collection" of standarized data structures whit the main characteristic
that all of them implements a set of common methods and rules. Java Collection
as Framework was first introduced in the JDK 1.2.

Before this concept, collectionswhere a few data structures clases. 
Mainly, were via the array, the Vector, and the Hashtable classes, 
which unfortunately were not easy to extend, and did not implement a 
standard member interface.

Now a days, the Java Collections Framework provides high-performance 
data structures that are easy to use and extend. About this topic,
developers can use the concept of Parameterized Types (or Generics)
to define the type of the elements of the collection.

## Collection Family
There are three main families of collections:
- **List**: Ordered Collection of primitive types or Objects that can be accessed by index.
- **Map**: Collection of Key-Value pairs  where each unique key is mapped to a value.
- **Set**: Unordered Collection that does not allow duplicate elements.



# Java Interface vs Java Class
In simple terms, an interface is a contract that defines the behavior that a class must implement.
An interface is a blueprint for a class and it is used to achieve abstraction. This means
that in order to ensure this behavior, the class must implement all the methods defined in the interface.



## Here are some key points:

- Class can instantiate variable and create objects, interfaces cannot.
- Class can contain concrete methods, Interfaces contains only abstract methods. 
- Access modifiers are not allowed in interfaces. Only one public specifier is allowed.
- An Interface can implement several interfaces, Classes can only extend other Classes.
- An Interface can exted serveral interfaces.
- Interfaces cannot define Fields (only static ones are allowed), Classes can.
- An Interface cannot be instantiated, a Class can.
- A Class that implements an Interface must implement all the methods defined in the Interface.

# The Iterable Interface
This interface is very important to use, actually all the collections implements this interface.
because of the fact that all data structures must be iterable. In other words, all data structure
that we use must have a way to access all its elements. And tha is what the Iterable interface
ensures.

## Iterable Interface Definition

```java
public interface Iterable<T>
{
  //Returns an iterator over elements of type T
  Iterator<T>    iterator();
  
  //Creates a Spliterator over the elements described by this Iterable
  Spliterator<T> spliterator();

  //Performs a given action for each element
  void           forEach(Consumer<? super T> action);
}
``` 


# Data Structures
The collection framework provides a set of data structures that almost
all developers will use. Bases on the idea that a Data Structure is a
container that holds a set of elements. The collection framework provides
these sets of data structures:

- LinkedList
- ArrayList
- Vector
- HashMap
- HashTable
- LinkedHashMap
- TreeMap
- HashSet
- LinkedHashSet
- TreeSet
- PriorityQueue

# LinkedList - ArrayList - Vector
List Interface concept represents a sequential collection of elements. It is posible to precise control over the element and where is inserted.
It is also posible to add or remove elements from the list by using the index (position in the list). The List interface also provides two methods 
to efficiently insert and remove multiple elements at an arbitrary point in the list. List interface allows to add duplicate elements.

## Key Characteristics and Differences

| Feature         | LinkedList                              | ArrayList                                            | Vector                                               |
| --------------- | --------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| Data Structure  | Double Linked List                      | Growable Array                                       | Growable Array                                       |
| CRUD Efiiciency | O(n/4)                                  | O(1)                                                 | O(1)                                                 |
| Sizing          | Dynamic                                 | Fixed                                                | Fixed                                                |
| When to Use?    | Alot of Modifications, no so many reads | Alot of Reads, no so many modifications (Add/Remove) | Alot of Reads, no so many modifications (Add/Remove) |

# HashTable - HashMap - LinkedHashMap - TreeMap
Map famyly is a collection that maps keys to values. Objects that are
Stored in a Map are called **entries** and the key is the unique identifier
that is used to access the value. keys are only Primitive types, and objects
stored in a Map must implement: the **equals()** and **hashCode()** methods.
 
- The **equals()**   method. 
- The **hashCode()** method. 

Java Collections Framework provides a some variations that uses the Key-Value concepts
to store and retrieve objects. They have the following characteristics and differences:

| Feature                 | HashTable           | HashMap             | LinkedHashMap       | TreeMap                                                |
| ----------------------- | ------------------- | ------------------- | ------------------- | ------------------------------------------------------ |
| Iteration Order         | Random              | Random              | Linked              | Sorted                                                 |
| Null Values             | No                  | Yes                 | No                  | No                                                     |
| CRUD Efiiciency         | O(1)                | O(1)                | O(1)                | O(log(n))                                              |
| Requirements for Keys   | equals and hashCode | equals and hashCode | equals and hashCode | Comparator needs to be supplyed for key implementation |
| Order of Data Insertion | Random              | Random              | Linked              | Sorted                                                 |


# HashSet - LinkedHashSet - TreeSet
The core concept of a Set is that it does not allow duplicate elements. Set Interface has at most one null element.
This interface models the matematical concept of a Set. This interface contains the add a feature that restricts 
the insertion of the duplicate elements.

The set interface allows the users to perform the basic mathematical operation on the set, such as:

- **Intersection**: This operation returns all the common elements from the given two sets.
- **Union**: This operation adds all the elements in one set with the other.
- **Difference**: This operation removes all the values present in one set from the other set.

## Key Characteristics and Differences

| Feature                 | HashSet                    | LinkedHashSet          | TreeSet                                 |
| ----------------------- | -------------------------- | ---------------------- | --------------------------------------- |
| Data Structure          | Hash Table                 | Linked List            | Red - Black Tree                        |
| Order of Data Insertion | Random                     | Linked                 | Sorted                                  |
| Null Values             | One Null Only              | One Null Only          | No                                      |
| CRUD Efiiciency         | O(1)                       | O(1)                   | O(log(n))                               |
| When to Use?            | No Insertion Ordern Needed | Insertion Order Needed | Sort Elements Acordting to a Comparator |
| Memory Usage            | Minimum                    | High                   | High                                    |

---
**NOTE**

Treeset uses **CompareTo()** method to compare the elements and remove possible duplicates.

---

# Collection Relationship
Java Collection has a wide range of data structures that can be used ensuring the best performance possible.
In figures 1 and 2, we can see the Implements and Extends relationships between the data structures.


# Collection Hierarchy
![](./img/Collection.jpg) 
*Fig. 1. Collection Hierarchy*

# Map Hierarchy
![](./img/Map.jpg)
*Fig 2. Map Hierarchy*

# Features
- Reduces Programming Complexity and Effort by using powerful, performed and
  flexible data structures
- Provides a standard interface for the collection classes
- Increases the interoperability of the collections with other Java applications
- Increases program speed and high-quality implementation
- Encorage the use of generics to define the type of the elements of thecollection
- Provides a set of common methods and rules
- Encourage software reuse
- Garantees uniformity among the framework and reduces the effor of learnig new APIs per structure


# When is it Recommended to Use
The Collection interface (java.util.Collection) and Map interface (java.util.Map) are the two main “root” interfaces of Java collection classes
this means that its implementation is almost by default, they are widely used and i would dare to say that it should be used in almost every situation.
However, there are some situations where low level programming is required in order to get the best performance, like the case of embedded applications
running very close to hardware where the performance is critical and the only data structure used is the array, in this case the framework is not
suportred by the limitations of the hardware.


# References:

| Topic                         | Source                                                            |
| :---------------------------- | :---------------------------------------------------------------- |
| Iterable Interface in Java    | https://www.geeksforgeeks.org/iterable-interface-in-java/         |
| Iterable Definition           | https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html |
| Java Collection Core Concepts | https://www.youtube.com/watch?v=Ma7u6KEKzPE&t=1784s               |
| Java Collection Framework     | https://www.geeksforgeeks.org/collections-in-java-2/              |