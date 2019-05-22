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

    def walkBackward(self):
        kit.servo[7].angle = 90
        kit.servo[9].angle = 90
       

        time.sleep(0.2)
        
        kit.servo[6].angle = 110
        kit.servo[8].angle = 150
        kit.servo[4].angle = 20
        kit.servo[10].angle = 60

        time.sleep(0.2)

        kit.servo[7].angle = 70
        kit.servo[9].angle = 70

        time.sleep(0.2)

        kit.servo[5].angle = 130
        kit.servo[11].angle = 130

        time.sleep(0.2)

        kit.servo[6].angle = 150
        kit.servo[8].angle = 110
        kit.servo[4].angle = 60
        kit.servo[10].angle = 20

        time.sleep(0.2)

        kit.servo[5].angle = 110
        kit.servo[11].angle = 110

        time.sleep(0.2)

        print('Walking Backward')

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
        
    def jumpUp(self):
        kit.servo[4].angle = 10     #FL HIP
        kit.servo[5].angle = 20    #FL FOOT
        kit.servo[6].angle = 170    #FR HIP
        kit.servo[7].angle = 120     #FR FOOT
        kit.servo[8].angle = 0    #BL HIP
        kit.servo[9].angle = 70     #BL FOOT
        kit.servo[10].angle = 160    #BR HIP
        kit.servo[11].angle = 110   #BR FOOT

        time.sleep(3)
        
        
        kit.servo[9].angle = 140     #BL FOOT
        kit.servo[11].angle = 40   #BR FOOT
#         time.sleep(0.01)
#         kit.servo[8].angle = 180     #BL FOOT
#         kit.servo[10].angle = 0    #BR HIP
        
        time.sleep(0.5)
        
#         kit.servo[4].angle = 40     #FL HIP
#         kit.servo[5].angle = 110    #FL FOOT
#         kit.servo[6].angle = 130    #FR HIP
#         kit.servo[7].angle = 70     #FR FOOT
#         kit.servo[8].angle = 130    #BL HIP
#         kit.servo[9].angle = 70     #BL FOOT
#         kit.servo[10].angle = 40    #BR HIP
#         kit.servo[11].angle = 110   #BR FOOT
        
#         time.sleep(2)
#         
#         kit.servo[5].angle = 180    #FL FOOT
#         kit.servo[7].angle = 0     #FR FOOT
#         kit.servo[9].angle = 0     #BL FOOT
#         kit.servo[11].angle = 180   #BR FOOT
    
    def jumpBack(self):
        kit.servo[4].angle = 10     #FL HIP
        kit.servo[5].angle = 20    #FL FOOT
        kit.servo[6].angle = 170    #FR HIP
        kit.servo[7].angle = 120     #FR FOOT
        kit.servo[8].angle = 0    #BL HIP
        kit.servo[9].angle = 70     #BL FOOT
        kit.servo[10].angle = 160    #BR HIP
        kit.servo[11].angle = 110   #BR FOOT

        time.sleep(3)
        
        
        kit.servo[9].angle = 140     #BL FOOT
        kit.servo[11].angle = 40   #BR FOOT
#         time.sleep(0.01)
#         kit.servo[8].angle = 180     #BL FOOT
#         kit.servo[10].angle = 0    #BR HIP
        
        time.sleep(1.5)
        
        kit.servo[4].angle = 40     #FL HIP
        kit.servo[5].angle = 110    #FL FOOT
        kit.servo[6].angle = 130    #FR HIP
        kit.servo[7].angle = 70     #FR FOOT
        kit.servo[8].angle = 130    #BL HIP
        kit.servo[9].angle = 70     #BL FOOT
        kit.servo[10].angle = 40    #BR HIP
        kit.servo[11].angle = 110   #BR FOOT
        
#         time.sleep(2)
#         
#         kit.servo[5].angle = 180    #FL FOOT
#         kit.servo[7].angle = 0     #FR FOOT
#         kit.servo[9].angle = 0     #BL FOOT
#         kit.servo[11].angle = 180   #BR FOOT

    def dance(self):
        kit.servo[4].angle = 0     #FL HIP
        kit.servo[6].angle = 180    #FR HIP
        kit.servo[8].angle = 180    #BL HIP
        kit.servo[10].angle = 0    #BR HIP

        for x in range(5):
            

            kit.servo[7].angle = 50    #FL FOOT
            kit.servo[9].angle = 60   #BR FOOT
            kit.servo[5].angle = 110    #FL FOOT
            kit.servo[11].angle = 110   #BR FOOT

            time.sleep(0.2)

            kit.servo[7].angle = 20    #FL FOOT
            kit.servo[9].angle = 120   #BR FOOT

            time.sleep(0.2)

            kit.servo[7].angle = 70    #FL FOOT
            kit.servo[9].angle = 70   #BR FOOT
            kit.servo[5].angle = 150    #FL FOOT
            kit.servo[11].angle = 50   #BR FOOT

            time.sleep(0.2)

    def dance(self):
        homePos()
        kit.servo[4].angle = 140     #FL HIP
        kit.servo[6].angle = 180    #FR HIP
        kit.servo[8].angle = 40    #BL HIP
        kit.servo[10].angle = 0    #BR HIP

        
        

