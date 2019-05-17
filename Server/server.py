from flask import Flask, render_template, request
import Quadruped

app = Flask(__name__)

quad = Quadruped.Quadruped()

@app.route('/')
def index():
    return render_template('main.html')
   
@app.route("/")
def main():
   templateData = {
      'message': ""
      }
   # Pass the template data into the template main.html and return it to the user
   return message
   
@app.route("/<action1>")
def action1(action1):
   # Convert the pin from the URL into an integer:
   global message
   if action1 == "walkForward":
      message = "Walking Forward"
      return message()
      quad.walkForward()
   elif action1 == "turnLeft":
      message = "Turning Left"
      return message()
      quad.turnLeft()
   elif action1 == "turnRight":
      message = "Turning Right"
      quad.turnRight()
   elif action1 == "homePos":
      message = "Switching to Home Position"
      quad.homePos()
   elif action1 == "bow":
      message = "Bowing"
      quad.bow()
   elif action1 == "bendBack":
      message = "Bending Back"
      quad.bendBack()
   elif action1 == "jumpUp":
      message = "Jumping Up"
      quad.jumpUp()
   elif action1 ==  "jumpBack":
      message = "Jumping Back"
      quad.jumpBack()
   elif action1 == "pushUp":
      message = "Completed 5 push ups"
      quad.pushUp()
   else:
      message = ""

   templateData = {
      'message' : message,
   }

   return message

if __name__ == "__main__":
   app.run(host='0.0.0.0', port=80, debug=True)
