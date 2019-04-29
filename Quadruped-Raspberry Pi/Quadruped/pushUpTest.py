import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    quad.pushUp()
    time.sleep(1)       
except:
    quad.homePos()

