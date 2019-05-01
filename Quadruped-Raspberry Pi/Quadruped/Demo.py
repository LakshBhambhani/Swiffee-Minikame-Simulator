import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    print("Running Demo")
    for x in range(6):
        quad.turnLeft()
    time.sleep(1)
    for x in range(6):
        quad.turnRight()
    time.sleep(1)
    for x in range(6):
        quad.walkForward()
    for x in range(6):
        quad.bow()
        time.sleep(1)
        quad.bendBack()
    quad.pushUp()
    time.sleep(2)
    quad.jump()
        
except:
    quad.homePos()
