import Quadruped
import time

quad = Quadruped.Quadruped()

try:
    for x in range(5):
         quad.bow
         time.sleep(1)
         quad.bend     
     
except:
    quad.homePos()

