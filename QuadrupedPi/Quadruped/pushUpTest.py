import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    print("Running push up test")
    quad.pushUp()
    time.sleep(1)       
except:
    quad.homePos()

