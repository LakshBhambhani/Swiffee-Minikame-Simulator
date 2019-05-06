# Swiffee - Minikame Simulator

@author Laksh Bhambhani, Megan Choy
@date April 9, 2019

This program makes a simulation of a Quadruped moving, but it can also be used to move the robot in real life. To move the robot, the user will use pre-made methods. Kids who would like to try testing a Quadruped, but don't have one, can use this simulation. It is also useful to try coding and using robots in an easy and simple way. 

There is also a simulation of the Quadruped to mimic what it would look like in real life. To code, there is a simple IDE and a terminal to show how the Quadruped is working and if there are any errors. New coders can easily code with simple methods that can be used in many ways.

Instructions:
Open the window and start coding with The Java API (no need to worry, you need to code in java and you definitely know this language):

Classes used:

| Class Name | Description |
| --- | --- |
| Java | the analyzer of the code the user inputs |
| SimulatorWindow | the window and graphics of the Quadruped |
| Simulator | the panel drawing the body and legs of the Quadruped |
| Body | the blueprint class representing the body of the Quadruped |
| Legs | the blueprint class representing the legs of the Quadruped |
| FullBody | the class instantiating the Body and Legs classes |
| SFTPBean | protocol for sending the code the user programmed to the robot |
| ScpTo | calls SFTPBean to send code to robot |
| ConnectToBot | executes the code on the robot |

Responsibilities:
Laksh works with the hardware and software regarding the robot. The classes like SFTPBean, ScptTo, and ConnectToBot are all used to send and execute code on the actual robot. He also works on the Andriod and IOS app to control the robot. For the simulator, he made the Java class which analyzes what the user codes. 
<br>
Megan works on the simulator, animations, and the other requirements like the ReadME and UML diagram. She works with the classes regarding to the simulator graphics and window and the images like Body and Legs. 
