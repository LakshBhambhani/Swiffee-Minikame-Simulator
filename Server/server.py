from flask import Flask, render_template, request, redirect, url_for
import Quadruped
import threading

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
  
def walkForward():
   quad.walkForward()

def walkBackward():
   quad.walkBackward()

def turnLeft():
   quad.turnLeft()

def turnRight():
   quad.turnRight()

def homePos():
   quad.homePos()

def bow():
   quad.bow()

def bendBack():
   quad.bendBack()

def jumpUp():
   quad.jumpUp()

def jumpBack():
   quad.jumpBack()

def pushUp():
   quad.pushUp()

def dance():
   quad.dance()

def swerve():
   quad.swerve()

def demo():
   quad.demo()

def sayHi():
   quad.sayHi()

@app.route("/<action1>")
def action1(action1):
   # Convert the pin from the URL into an integer:
   global message
   if action1 == "walkForward":
      message = "walkForward"
      thread = threading.Thread(target=walkForward)
      thread.start()
      return message + ' started' 
   elif action1 == "walkBackward":
      message = "walkBackward"
      thread = threading.Thread(target=walkBackward)
      thread.start()
      return message + ' started' 
   elif action1 == "turnLeft":
      message = "turnLeft"
      thread = threading.Thread(target=turnLeft)
      thread.start()
      return message + ' started' 
   elif action1 == "turnRight":
      message = "turnRight"
      thread = threading.Thread(target=turnRight)
      thread.start()
      return message + ' started' 
   elif action1 == "homePos":
      message = "homePos"
      thread = threading.Thread(target=homePos)
      thread.start()
      return message + ' started' 
   elif action1 == "bow":
      message = "bow"
      thread = threading.Thread(target=bow)
      thread.start()
      return message + ' started' 
   elif action1 == "bendBack":
      message = "bendBack"
      thread = threading.Thread(target=bendBack)
      thread.start()
      return message + ' started' 
   elif action1 == "jumpUp":
      message = "jumpUp"
      thread = threading.Thread(target=jumpUp)
      thread.start()
      return message + ' started' 
   elif action1 ==  "jumpBack":
      message = "jumpBack"
      thread = threading.Thread(target=jumpBack)
      thread.start()
      return message + ' started' 
   elif action1 == "pushUp":
      message = "pushUp"
      thread = threading.Thread(target=pushUp)
      thread.start()
      return message + ' started' 
   elif action1 == "dance":
      message = "dance"
      thread = threading.Thread(target=dance)
      thread.start()
      return message + ' started' 
   elif action1 == "swerve":
      message = "swerve"
      thread = threading.Thread(target=swerve)
      thread.start()
      return message + ' started' 
   elif action1 == "demo":
      message = "demo"
      thread = threading.Thread(target=demo)
      thread.start()
      return message + ' started' 
   elif action1 == "sayHi":
      message = "sayHi"
      thread = threading.Thread(target=sayHi)
      thread.start()
      return message + ' started' 
   else:
      message = ""

   templateData = {
      'message' : message,
   }

  

if __name__ == "__main__":
   app.run(host='0.0.0.0', port=80, debug=True)
