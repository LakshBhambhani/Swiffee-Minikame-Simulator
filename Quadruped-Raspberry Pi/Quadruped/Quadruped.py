from adafruit_servokit import ServoKit 
import time

kit = ServoKit(channels=16)

class Quadruped():

    def homePos(self):
        kit.servo[4].angle = 40     #FL HIP
        kit.servo[5].angle = 110    #FL FOOT
        kit.servo[6].angle = 130    #FR HIP
        kit.servo[7].angle = 70     #FR FOOT
        kit.servo[8].angle = 130    #BL HIP
        kit.servo[9].angle = 70     #BL FOOT
        kit.servo[10].angle = 40    #BR HIP
        kit.servo[11].angle = 110   #BR FOOT
        print('switching to home position')

    def walkForward(self):
        kit.servo[7].angle = 50
        kit.servo[9].angle = 50
       

        time.sleep(0.2)
        
        kit.servo[6].angle = 150
        kit.servo[8].angle = 110
        kit.servo[4].angle = 60
        kit.servo[10].angle = 20

        time.sleep(0.2)

        kit.servo[7].angle = 70
        kit.servo[9].angle = 70

        time.sleep(0.2)

        kit.servo[5].angle = 130
        kit.servo[11].angle = 130

        time.sleep(0.2)

        kit.servo[6].angle = 110
        kit.servo[8].angle = 150
        kit.servo[4].angle = 20
        kit.servo[10].angle = 60

        time.sleep(0.2)

        kit.servo[5].angle = 110
        kit.servo[11].angle = 110

        time.sleep(0.2)

        print('Walking Forward')

    def turnLeft(self):
        kit.servo[5].angle = 130
        kit.servo[11].angle = 130

        time.sleep(0.2)

        kit.servo[4].angle = 10
        kit.servo[10].angle = 10

        time.sleep(0.2)

        kit.servo[5].angle = 110
        kit.servo[11].angle = 110

        time.sleep(0.2)

        kit.servo[4].angle = 40
        kit.servo[10].angle = 40

        time.sleep(0.2)

        kit.servo[7].angle = 50
        kit.servo[9].angle = 50

        time.sleep(0.2)

        kit.servo[6].angle = 80
        kit.servo[8].angle = 80

        time.sleep(0.2)

        kit.servo[7].angle = 70
        kit.servo[9].angle = 70

        time.sleep(0.2)

        kit.servo[6].angle = 130
        kit.servo[8].angle = 130

        time.sleep(0.2)

        print('turning left')

    def turnRight(self):
        kit.servo[5].angle = 130
        kit.servo[11].angle = 130

        time.sleep(0.2)

        kit.servo[4].angle = 140
        kit.servo[10].angle = 140

        time.sleep(0.2)

        kit.servo[5].angle = 110
        kit.servo[11].angle = 110

        time.sleep(0.2)

        kit.servo[4].angle = 40
        kit.servo[10].angle = 40

        time.sleep(0.2)

        kit.servo[7].angle = 50
        kit.servo[9].angle = 50

        time.sleep(0.2)

        kit.servo[6].angle = 180
        kit.servo[8].angle = 180

        time.sleep(0.2)

        kit.servo[7].angle = 70
        kit.servo[9].angle = 70

        time.sleep(0.2)

        kit.servo[6].angle = 130
        kit.servo[8].angle = 130

        time.sleep(0.2)

        print('turning right')

    def bow(self):
        kit.servo[5].angle = 140
        kit.servo[7].angle = 15
        kit.servo[9].angle = 130
        kit.servo[11].angle = 30
        time.sleep(0.2)

        print('bowing')

    def bendBack(self):
        kit.servo[5].angle = 30
        kit.servo[7].angle = 130
        kit.servo[9].angle = 15
        kit.servo[11].angle = 140
        time.sleep(0.2)
        
        print('bending back')

    def pushUp(self):
        kit.servo[4].angle = 130
        kit.servo[5].angle = 70
        kit.servo[6].angle = 60
        kit.servo[7].angle = 130

        kit.servo[8].angle = 170
        kit.servo[9].angle = 50
        kit.servo[10].angle = 10
        kit.servo[11].angle = 130

        time.sleep(1)

        for i in range(5):
            for  k in range(80):
                kit.servo[5].angle = 70 + k
                kit.servo[7].angle = 130 - k
                time.sleep(0.001)
            for  k in range(80):
                kit.servo[5].angle = 110 - k
                kit.servo[7].angle = 90 + k
                time.sleep(0.001)

        print('Finished 5 push ups')
