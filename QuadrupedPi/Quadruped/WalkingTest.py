import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    print("Running walking test")
    for x in range(6):
    	quad.walkForward();
    time.sleep(1)       
except:
    quad.homePos()

