import Quadruped
import time

quad = Quadruped.Quadruped()
for x in range(6):
    quad.turnLeft()
time.sleep(1)
for x in range(6):
    quad.turnRight()