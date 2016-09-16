#include <Servo.h>
#include <Wire.h>
#include <ADXL345.h>
#include <String.h>

Servo lef, rig, ele, rud, thr,thr2;
const float alpha = .5;
double fXg = 0, fYg = 0, fZg = 0;
ADXL345 acc;
double roll, pitch;
boolean balance = false;
int count = 0;
int controllerRoll;

void setup() {
  Serial.begin(19200);	// opens serial port, sets data rate to 9600 bps
  Serial2.begin(19200);
  lef.attach(9);  //S5
  rig.attach(11); //
  ele.attach(12); //S2
  rud.attach(10); //S4
  thr.attach(7); 
  thr2.attach(6);
  Serial.println("running");
}

void loop(){

}




