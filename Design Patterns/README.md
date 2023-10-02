## Creational Design Pattern

1. Singleton
   1. to limit creation of new instance
   2. ways:
      1. privatize constructor, public getinstance method which returns the class instance. (static variable)
      2. intialize static variable in the begining of the class creation.
      3. volatile variable + double check and synchronize class to return the existing class instance for all threads
2. Factory
   1. to hide the logic of creation of related classes
   2. ways:
      1. use interface
      2. create classes to implement the interface
      3. create factory class to implement switch case to return the required object
3. Abstract Factory:
   1. Another layer of abstraction over factory
   2. Create a super factory for the factories
   3. ways:
      1. Create interface to be implemented
      2. Create concrete classes for the created interface
      3. 