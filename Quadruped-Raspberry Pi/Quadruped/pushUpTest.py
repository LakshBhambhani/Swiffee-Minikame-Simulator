import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    quad.homePos()
    quad.pushUp()
    time.sleep(5)       
except:
    quad.homePos()

