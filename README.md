I combined all the tasks in one application in order to reflect more complex structure of program (using main application loop, reusable utils classes etc.).  
For the sake of simplicity I didn't create any kind of validation of input or Javadocs.  
Main logic of all the task are located in `skazinski.szymon.task.*` packages.

All the task have their own runner located in `skazinski.szymon.runner.*` packages. Runners allow running using different input and output streams (driven by `Reader` and `Printer` implementation). 

* Task 1
    * Simple solution with one method based mainly on Java Stream.
    * In order to optimize after sorting collection I'm getting first and last element to retrieve min and max values (instead of using Stream.min(), Stream.max() methods).
  * I also created simple POJO `Measurements` to wrap an output.
       
* Task 2
    * Simple solution using for a loop in order to find appropriate pairs of integers and Stream for sort and collect output.
    
* Task 3
    * For sake of clarity I created `Graph` class that is wrapper of `SortedSet` with all needed methods. In order to sort it I implemented `Comparable` interface instead of using `Comparator`;
    

