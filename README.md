# CSX42: Assignment 4
Name:  Kasturi Tarachand More

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [arrayvisitors/src](./arrayvisitors/src/) folder.

## Instruction to clean:

Assuming you are at arrayvisitors/ folder.

```commandline
 ant -buildfile src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

Assuming you are at arrayvisitors/ folder.

```commandline
 ant -buildfile src/build.xml all 
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintsout="common.txt" -Dmissingintsout="missing.txt" -Ddebug=1

```
Note: Arguments accept the absolute path of the files.


## Description:

Slack Days Used: 1/5

Data Structure Used: Arrays

Time Complexities:

#####For Finding Common Integers: O(2nLogn + n) = O(nlogn)

After sorting the arrays, compare elements of the arrays in a while loop and increment only one of the array index if the elements are not equal otherwise increment index in both the arrays.

#####For Finding Missing Integers: O(2n) = O(n)

Iterate through the whole array to mark all present numbers and then iterate again to another array of the same length to find absentees. 
Thus, time complexity is O(n) + O(n) or O(2N)

## References:

https://www.baeldung.com/java-check-string-number

https://knpcode.com/java-programs/find-common-element-between-two-arrays-java/

https://javarevisited.blogspot.com/2018/04/how-to-find-k-missing-numbers-in-array-java.html


## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [07/22/2019]