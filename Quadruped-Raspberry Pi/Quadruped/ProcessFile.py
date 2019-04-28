import Quadruped

quad = Quadruped.Quadruped()

filepath = 'Test.txt'  
with open(filepath) as fp:  
   line = fp.readline()
   cnt = 1
   while line:
        #print("Line {}: {}".format(cnt, line.strip()))
        if line.strip() == "moveForward()":
            quad.walkForward()
        if line.strip() == "turnLeft()":
            quad.turnLeft()
        if line.strip() == "turnRight()":
            quad.turnRight
        line = fp.readline()
        cnt += 1