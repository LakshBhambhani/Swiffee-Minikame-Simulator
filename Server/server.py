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

@app.route('/status')
def foo():
   #t1 = threading.Thread(target=walkForward(), args=()) 
   #t1.start()
   return message + 'start'
  

@app.route("/<action1>")
def action1(action1):
   # Convert the pin from the URL into an integer:
   global message
   def do_work():
        # do something that takes a long time
        import time
        time.sleep(5)

   
   if action1 == "walkForward":
      message = "Walking Forward"
      #return redirect(url_for('foo'))
      thread = threading.Thread(target=do_work)
      thread.start()
      return 'started'   
   elif action1 == "turnLeft":
      message = "Turning Left"
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
   
   if message == "Walking Forward":
      return message()
      quad.walkForward()

   templateData = {
      'message' : message,
   }

  

if __name__ == "__main__":
   app.run(host='0.0.0.0', port=80, debug=True)
