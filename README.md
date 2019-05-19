# Swiffee - Minikame Simulator

@author Laksh Bhambhani, Megan Choy
@date April 9, 2019

This program makes a simulation of a Quadruped moving, but it can also be used to move the robot in real life. To move the robot, the user will use pre-made methods. Kids who would like to try testing a Quadruped, but don't have one, can use this simulation. It is also useful to try coding and using robots in an easy and simple way. 

There is also a simulation of the Quadruped to mimic what it would look like in real life. To code, there is a simple IDE and a terminal to show how the Quadruped is working and if there are any errors. New coders can easily code with simple methods that can be used in many ways.

### Instructions:
Open the window in class SimulatorWindow and start coding with The Java API (no need to worry, you need to code in java and you definitely know this language): <a href=https://lakshbhambhani.github.io/Swiffee-Minikame-Simulator/>JAVA API</a> or https://lakshbhambhani.github.io/Swiffee-Minikame-Simulator/

The only methods that work right now are "moveForward(); moveBackward(); turnLeft(); turnRight(); homePos();". To see an example, go to "File" in the top left and then "Open" and open Commands.txt.

If there is a problem, report the bug under "Help" and then click "Report a Bug".

First, type in the code at the SwiffeeIDE and click "Run" once you are done to see the robot move. Don't worry about the "Run on Bot" button. You can also code in the terminal and make booleans and integers. Read more about that in the Swiffee API.

### Classes used:

| Class Name | Description |
| --- | --- |
| About Panel | Displays the version of the software you are using plus names of devlopers |
| Body | the blueprint class representing the body of the Quadruped |
| ConnectToBot | executes the code on the robot |
| ControlMultithread | Tries to run XboxListener and Xbox Map Window together using multithreading |
| ControlPanel | Displays the XboxMap to user |
| ControlPanelJFrame | The window to use Xbox controller to control the bot |
| CoordinateSystem | Used to display animations in Swiffee |
| FullBody | the class instantiating the Body and Legs classes |
| Java | the analyzer of the code the user inputs |
| Legs | the blueprint class representing the legs of the Quadruped |
| RemoteExecute | Remotely executes files on the bot using Jsch(ssh) |
| ScpTo | calls SFTPBean to send code to robot |
| SettingsPanel | User can change the IP of the bot from here |
| SFTPBean | protocol for sending the code the user programmed to the robot |
| Simulator | the panel drawing the body and legs of the Quadruped |
| SimulatorMenu | Contains the Menubar options for Swiffee |
| SimulatorWindow | the window and graphics of the Quadruped |
| URLReader | Reads the text on a URL. Helps us know whether Bot is moving or no |
| Xbox | A runnable class used for listening during Multithreading |
| XboxControl | Contains methods to use Xbox without instantiating Xbox many times |
| XboxListener | This is where we listen to Xbox inputs and process it on the bot |

### Responsibilities:<br>
Laksh works with the hardware and software regarding the robot. The classes like SFTPBean, ScptTo, and ConnectToBot are all used to send and execute code on the actual robot. He also works on the Andriod and IOS app to control the robot. For the simulator, he made the Java class which analyzes what the user codes. Also Xbox Listeners are made by him.
<br><br>
Megan works on the simulator, animations, and the other requirements like the ReadME and UML diagram. She works with the classes regarding to the simulator graphics and window and the images like Body and Legs. 

## License

All packages in this repository are released under the MIT License.
