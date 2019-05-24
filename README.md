# Swiffee - Minikame Simulator

@author Laksh Bhambhani, Megan Choy
@date April 9, 2019 - May 22, 2019

This program makes a simulation of a Quadruped moving, but it can also be used to move the robot in real life. To move the robot, the user will use pre-made methods. Kids who would like to try testing a Quadruped, but don't have one, can use this simulation. It is also useful to try coding and using robots in an easy and simple way. 

There is also a simulation of the Quadruped to mimic what it would look like in real life. To code, there is a simple IDE and a terminal to show how the Quadruped is working and if there are any errors. New coders can easily code with simple methods that can be used in many ways.

### Instructions:
Open the executable jar file. If you are opening from the code, go into folder Quadruped then class SimulatorWindow and start coding with The Java API (no need to worry, you need to code in java and you definitely know this language): <a href=https://lakshbhambhani.github.io/SwiffeeAPI/>JAVA API</a> or https://lakshbhambhani.github.io/SwiffeeAPI/

To see an example, go to "File" in the top left and then "Open" and open Examples.txt. You can type methods that are in the Java APi. There are also variables like booleans and integers and you can even type if statements. Find the syntax in the Java API

If there is a problem, report the bug under "Help" and then click "Report a Bug".

First, type in the code at the SwiffeeIDE and click "Run" once you are done to see the robot move. If you are connected to a bot, you can click the "Run on Bot" button and see the simulator and bot run at the same time!

### Classes used:

| Class Name | Description |
| --- | --- |
| About Panel | Displays the version of the software you are using plus names of devlopers |
| Body | the blueprint class representing the body of the Quadruped |
| ControlMultithread | Tries to run XboxListener and Xbox Map Window together using multithreading |
| ControlPanel | Displays the XboxMap to user |
| ControlPanelJFrame | The window to use Xbox controller to control the bot |
| CoordinateSystem | Used to display animations in Swiffee |
| FullBody | the class instantiating the Body and Legs classes |
| Java | the analyzer of the code the user inputs |
| Legs | the blueprint class representing the legs of the Quadruped |
| SettingsPanel | User can change the IP of the bot from here |
| Simulator | the panel drawing the body and legs of the Quadruped |
| SimulatorMenu | Contains the Menubar options for Swiffee |
| SimulatorWindow | the window and graphics of the Quadruped |
| URLReader | Reads the text on a URL. Helps us know whether Bot is moving or no |
| Xbox | A runnable class used for listening during Multithreading |
| XboxControl | Contains methods to use Xbox without instantiating Xbox many times |
| XboxListener | This is where we listen to Xbox inputs and process it on the bot |

### Responsibilities:<br>
Laksh works with the hardware and software regarding the robot. The classes like SFTPBean, ScptTo, and ConnectToBot are all used to send and execute code on the actual robot. He also works on the Android and IOS app to control the robot. For the simulator, he made the Java class which analyzes what the user codes. Also Xbox Listeners are made by him.
<br><br>
Megan works on the simulator, animations, and the other requirements like the ReadME and UML diagram. She works with the classes regarding to the simulator graphics and window and the images like Body and Legs.

### Credit:
#### Jsch
JSch allows you to connect to an ssh server and use port forwarding. We use this to connect to the bot directly and access files or write files instead of connecting to the bot's server and directly triggering commands.

#### Jamepad
A library to use gamepads in Java in a better way. Cloned from William A Hartman. We use this library to listen to xbox inputs which is connected to the simulator via your computer.

#### Jsoup
Jsoup is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods. Used for connecting to Bot's server.

#### Html Parser
HTML Parser is used to get the text which is on a specific URL. Used to read the message on the bot's status page which tells you what it is doing. If bot is doing the command, then Simulator will also be forced to show the same animation.

### Known Bugs:
Animations for bow, bendBack, jumpUp, jumpBack are not the best...
The legs of the quadruped on the simulator can sometimes "come off" when used too much.
Method pushUp only works on the robot (does nothing on the simulator).

## Want to know more?
Read the <a href="https://lakshbhambhani.github.io/SwiffeeDocs/">Swiffee Docs</a>

## License

All packages in this repository are released under the MIT License.
