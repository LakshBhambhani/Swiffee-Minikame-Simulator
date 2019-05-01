import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    quad.jumpBack()
        
except:
    quad.homePos()
