import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    quad.jumpUp()
        
except:
    quad.homePos()
