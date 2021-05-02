#School Simulation project
Hilea Vlad George
This was my first big OOP project

In order to run the program you have to write 2 arguments on the command line: file, number of days.
Example java Administrator mySchool.txt 200

The code first prints the starting status of the school. The courses, the instructors and the students. The way to program works is that every single day
it prints the status of the school: first the courses, then the students, then the instructors. 
If a Course has finished or cancelled on a specific day, it will showat the end of the course descirption that it is finished and the instructor and students
of the course are not enrolled or assigned anymore because the course finished that day
It is the same with a course that is cancelled. In the day it is cancelled it will be printed that it is cancelled and the instructor is not assigned anymore and the students are not enrolled anymore
because the course cancelled.

Extension
The extension I implemented is that a student or instructor needs a break after more than 10 days of work. After that they will go on a 2 days break to
recover. It will be printed near the name of the instructor or student "Is on pause" to know which person is on a break 
