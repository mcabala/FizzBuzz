# FizzBuzz 

I have created 5 Java Programs(FizzBuzzStep1,FizzBuzzStep2,FizzBuzzStep3,FizzBuzzConst and FizzBuzzTest). We can run all java program individually and also we can pass the argument starting from 1 to n where n is any integer.

If there is no argument passed, then the loop is iterated from 1 to 20.

## Technical description: 
 
### Step 1: 

Write some code that prints out the following for a contiguous range of numbers: 

* the number 
* 'fizz' for numbers that are multiples of 3 
* 'buzz' for numbers that are multiples of 5 
* 'fizzbuzz' for numbers that are multiples of 15 
 
e.g. if I run the program over a range from 1-20 I should get the
following output

 
1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz 
 
Step1 Code changes committed in first commit.
 
### Step 2: 

Enhance your existing FizzBuzz solution to perform the following: 
 
* If the number contains a three you must output the text
  'lucky'. This overrides any existing behaviour e.g. if I run the
  program over a range from 1-20 I should get the following output

 
1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz 
 
Step2 Code changes committed in second commit.
 
### Step 3: 

Enhance your existing solution to perform the following: 
 
* Produce a report at the end of the program showing how many times
  the following were output 
  
** fizz 
** buzz 
** fizzbuzz 
** lucky 
** an integer 
 
e.g. if I run the program over a range from 1-20 I should get the following output 
 
1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz 

fizz: 4 
buzz: 3 
fizzbuzz: 1 
lucky: 2 
integer: 10
 
(Integer is 10 because there were 10 numbers that were not altered in any way). 

Step3 Code changes, Updated README.md document and Junit Test committed in third commit.

 