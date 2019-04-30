import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    quad.jump()
        
except:
    quad.homePos()
