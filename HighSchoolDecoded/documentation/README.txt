Project name: High School- Decoded README
Anushka Saran, Helen Wang, Lily Li


Introduction:
Welcome to a high school: a place where many students are burdened with the stress of mounds of homework, test scores, AP classes, SATs, and getting into college. On top of this, students are increasingly distracted from their work by laptops and mobile devices. How can students be expected to keep up with all of their work without getting distracted and still have time to pursue their own interests? Never fear! High School- Decoded? can help students navigate through their murky high school years. With this personalizable high school/college guide app, students can keep track of assignments and events, learn to prioritize, and avoid procrastinating, while at the same time getting ready for college!

Instructions:
Click the start button to open your account on High School- Decoded. When you first open the app, you will be prompted for your grades, classes, activities, and colleges and majors that you are interested in. You can edit these later if you want. Use your mouse to navigate through the app and click on buttons that can perform various operations. 
————————————————————————————————————————————————————————————————————————————————————————

Features List:

Must-Have Features:
___________________

1. (DONE)The user can customize the app so that it shows information about their grades,
   classes, activities, colleges that he/she is interested in, and majors
2. (DONE)The user can use the app to calculate their GPAs, basic math operations, and 	
    chances of getting into colleges
3. (DONE)For assignments:
   1. Users can set a time limit in which they have to complete the assignments
   2. Users can check off assignments and earn points if they were completed within the
   time limit
   3. Users can add/delete/rename assignments
4. (DONE)There is a schedule for each day that shows:
   1. which assignments the user plans to do that day
   2. how much time the user wants to spend on each assignment
   3. when to take breaks (after every completed assignment, a certain # of mins)
   4. set a timer for an assignment
   5. awards points to user when he/she completes an assignment
5. (DONE) All of the information above is displayed in an easy to navigate GUI with as  
   aesthetically pleasing graphics as possible
6. (DONE)Store data locally

Want-to-Have Features:
______________________

1. (DONE) Line graph of past week’s performance(points collected for completing assignments)
2. (1/2 DONE, we used numbers instead of stars)Users can prioritize assignments by giving
   them a certain number of stars
3. Color-coded activities
4. Timed freezing of the screen (so can’t use it and be distracted during that time 
   period)
5. Program plays calming music(that can be turned off) while user is working
6. “Share” information (ie email, text, etc.) 
7. Activities calendar (weekly/monthly)
8. Sleep record + calculator from __ to __ = this many hours; graphs past sleep

Stretch Features:
_________________

1. 4 yr plan 
2. User can record and save videos
3. Send messages to other people/ collaborate w/others within the application
4. Utilities that can help the user do homework such as:
   1. Note taking (w/ highlighting & underlining)
   2. Making flashcards (animation can be a want-to-have/stretch feature)
   3. Drawing/making diagrams
   4. When taking notes, connects to thesaurus.com or the google definitions thing
   (grammar)
5. User can create a study playlist (music)
6. Homework help sources/links in a help section
7. Simple calculator for physics problems

Class List:
————————————————————————————————————————————————————————————————————————————————————————
PACKAGE college:
________________

1.ACTScores: representation of a set of ACTScore entity (with 25th percentile, midpoint, 
	and 75th percentile)
2.AnnualStats: entity representing a set of ACT and SAT scores 
3.ChanceCalculator: methods to calculate college admission chances
4.GPACalc: methods to calculate unweighted/weighted/finals scores given grades
5.SATScores: representation of a set of ACTScore entity (with 25th percentile, midpoint, 
	and 75th percentile)
6.School: entity representing a school that is parsed through online connection
7.Search: represents the entities after the “search” button is pressed. Includes JSON 
	parsing and organizes data into objects.
8.SearchFunction: Accesses data from JSON based on data entered

PACKAGE functions:
__________________

9.Activity: This class represents an activity that the user enters in activity window on
	the dashboard
10.Assignment: a assignment that the user has to complete, the user’s time limit for each 
   assignment, points for each assignment 
11.Points: manages the points that the user receives for completing an assignment based on
	it priority, and the time they took to complete it vs. the goal time limit that the
	user had set

PACKAGE graphics:
_________________

12.ActivityGui: Gui for the activities window. In this window, the user 
	can create a daily schedule that lists an event/activity and the time it will occur.
	An event/activity can also be deleted, but there is a bug with that(the table will
	create some empty rows at the top of the table, but if you close the window and then
	open it again, the empty rows will disappear and it will work as expected).
13.AssignmentGui: graphics interface for assignments. The user can in
	information about assignments(such as whether it is completed, the subject related to 
	the assignment, due date, the goal amount of time to spend on the assignment, and its
	priority level). The user can also look at a graph that shows the points they have 
	earned over time. When an assignment is selected in the table, a timer (at the 
	bottom)automatically starts and when the assignment is checked off, it is 
	automatically stopped, but it must be reset manually.
	Assignments can also be deleted (but there is a bug with that; the window must be 	closed if an assignment is deleted and then opened again before further use). 
	Points are awarded based on completion of assignments. 
14.ChanceCalculatorGui: graphics for calculating college admission chances given SAT or ACT 	scores
15.ClassesGui: represents the graphics interface for entering classes and grades for those
	classes by the user. This information is then displayed on the Dashboard window under 
	the current grades panel.
16.CollegesGui: graphics interface for college related functions
17.GPACalculatorGui: graphics for calculating unweighted/weighted/finals calculators
18.GradesGui: graphics to add in grades
19.Graph: Takes information from assignments to create a graph of the points earned every
	day
20.MajorGui: graphics to show list of 100 majors
21.ProfileGui: represents the graphics interface for entering information about the user.
	The information is then presented at the top right of the dashboard window.
22.UtilitiesGui: graphics interface for utilities such as a calendar, 
	stop watch, and basic math calculator, which the user can use for homework if needed. 
	The calculator does not work if the user tries to perform multiple operations at one 	time


PACKAGE loginSystem:
____________________

23.Dashboard:graphics interface for homepage, where the user can click on  
	buttons(assignments, classes, colleges, grades, profile, and utilities) 
24.Login: graphics interface for logging in. User enters in their username and password(if 
	they have already registered)
25.Register: graphics interface for registering. The data entered by the user is also   
	entered into the database. 
26.WelcomePage: graphics interface for when the application is first opened, like a cover 
	page

————————————————————————————————————————————————————————————————————————————————————————

Responsibilities List:

1. Anushka: Local database storage, user input, WelcomePage, Login, Register, Dashboard, 
   AssignmentGui; created README
2. Helen: Graph, ProfileGui, UtilitiesGui, ActivityGui, Activity, Assignment, Points,
   ClassesGui; created UML
3. Lily: Calculators and GUI for weighted/unweighted/finals grades; GUI for list of majors; 
   calculator and GUI for college admission chances using test scores; created presentation 

————————————————————————————————————————————————————————————————————————————————————————

Feedback:

1. Specify what various operations you can click on
2. How will you be able to do the video recordings?
3. What is the appeal of this? You can use your own agenda and calculator
4. There are too many factors to know your chance of getting into college, how will you 
   Get a realistic calculation?
5. How will you get all of the information about what majors each college provides etc
6. What is subjectList? You can just have an arrayList of subjects

Feedback given by: Amy, Emily, Sasha
————————————————————————————————————————————————————————————————————————————————————————

Sources:

Gui code was written using WindowBuilder Software

Tutorial on WindowBuilder: 
https://www.youtube.com/watch?v=vw_3Oe6e_Vc&feature=youtu.be

Tutorial on database storage:
https://www.youtube.com/watch?v=KRhv4iPgzHE&t=4s
https://www.youtube.com/watch?v=P9q5r2Vj36Y (to add,insert delete operation database)
Java Eclipse GUI Tutorial 9 # Populate JTable data from database in java Eclipse and Sqlite(populate jtable from database)

https://www.youtube.com/watch?v=yJUQshXN_EY&t=768s(add checkbox column in jtable)
https://www.youtube.com/watch?v=B071LpsqARw(add,delete and update jtable)
http://www.h2database.com/html/tutorial.html(h2 database tutorial)


Tutorials on login systems with databases:
https://www.youtube.com/watch?v=7CW2gYXiGY4&t=12s
https://www.youtube.com/watch?v=IQ5RgyP7H90

Tutorial on Swing graphics for java application:
https://www.youtube.com/watch?v=4SzG7wOkP98

API used for SAT/ACT scores and college admissions: 
https://collegescorecard.ed.gov/data/

JAVA library to parse JSON files: Json Simple
http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm

Json Simple library tutorial used to see class dependencies
https://www.mkyong.com/java/json-simple-example-read-and-write-json/

JAVA Calculator tutorial used to write code for simple calculator
https://www.thoughtco.com/simple-calculator-example-program-2033906

JAVA graph tutorial used to write code for the point graph
https://www.java-forums.org/new-java/7995-how-plot-graph-java-given-samples.html

Tutorial on JTables:
https://www.youtube.com/watch?v=P9q5r2Vj36Yhttps://www.youtube.com/watch?v=P9q5r2Vj36YJava 

JTable Ep.16 - Add/Insert,Update,Delete/Remove Dynamically
https://www.youtube.com/watch?v=yJUQshXN_EY&t=768s (checkbox columns)
