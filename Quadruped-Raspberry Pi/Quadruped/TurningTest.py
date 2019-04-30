import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    print("Running turning test")
    for x in range(6):
        quad.turnLeft()
    time.sleep(1)
    for x in range(6):
        quad.turnRight()
    time.sleep(1)       
except:
    quad.homePos()

