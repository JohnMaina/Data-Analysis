# JumoAssessment
## How to run the program

## Method 1 (NetBeans IDE)
Using NetBeans IDE, open project named JumoAssessment
Right-click on the project
Select Run.

## Method 2 (jar file via commandline)
Via commandline, navigate to /JumoAssessment directory.
Run the command: java -jar JumoAssessment.jar 
NB// if you move the jar file elsewhere, make sure weather.dat file is in the same directory with the jar file

## Assumptions
The weather.dat file will not change.

## PS.
There was a trade off between reducing time and space complexity from 2n to n in the expensive of simplicity and readability. I favored simplicity and readabilty since the 2 in 2n is a constant hence not significant. But in a situation where it is significant, it can be done through eliminating the second loop.
