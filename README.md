# JumoAssessment
## How to run the program

### Method 1 (NetBeans IDE)
1. Using NetBeans IDE, open project named JumoAssessment
2. Right-click on the project
3. Select Run.

### Method 2 (jar file via commandline)
1. Via commandline, navigate to /JumoAssessment directory.
2. Run the command: java -jar JumoAssessment.jar 
NB// if you move the jar file elsewhere, make sure weather.dat file is in the same directory with the jar file

### Assumptions
1. The weather.dat file will not change.

### PS.
There was a trade off between reducing time and space complexity from 2n to n in the expensive of simplicity and readability. I favored simplicity and readabilty since the 2 in 2n is a constant hence not significant. But in a situation where it is significant, it can be done through eliminating the second loop.
