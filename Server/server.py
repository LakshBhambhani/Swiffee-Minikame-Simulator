import RPi.GPIO as GPIO
from flask import Flask, render_template, request
import Quadruped

app = Flask(__name__)

quad = Quadruped.Quadruped()

GPIO.setmode(GPIO.BCM)
   
@app.route("/<action1>")
def action1(action1):
   # Convert the pin from the URL into an integer:
   global message
   if action1 == "walkForward":
      message = "Walking Forward"
      quad.walkForward()
   if action1 == "turnLeft":
      message = "Turning Left"
      quad.turnLeft()
   if action1 == "turnRight":
      message = "Turning Right"
      quad.turnRight()
   if action1 == "homePos":
      message = "Switching to Home Position"
      quad.homePos()
   if action1 == "bow":
      message = "Bowing"
      quad.bow()
   if action1 == "bendBack":
      message = "Bending Back"
      quad.bendBack()
   # For each pin, read the pin state and store it in the pins dictionary:
   for pin in pins:
      pins[pin]['state'] = GPIO.input(pin)

   templateData = {
      'message' : message,
      'pins' : pins
   }

   return render_template('main.html', **templateData)


   

if __name__ == "__main__":
   app.run(host='0.0.0.0', port=80, debug=True)
