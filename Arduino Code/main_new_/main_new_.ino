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
//char character;
//byte finished = 1;
int count = 0;
//int leftAileron = 90,rightAileron = 90,rudder=90,elevator=90,thrust=0;
int controllerRoll;

void setup() {
  Serial.begin(19200);	// opens serial port, sets data rate to 9600 bps
  Serial2.begin(19200);
  lef.attach(9); //S5
  rig.attach(11); //
  ele.attach(12); //S2
  rud.attach(10); //S4
  thr.attach(7); 
  thr2.attach(6);
//  pinMode(2,OUTPUT);
//  pinMode(8,OUTPUT);
//  digitalWrite(2, HIGH);
//  pinMode(10,OUTPUT);
//  digitalWrite(10,HIGH);
  //acc.begin();
  Serial.println("running");
}

void loop(){

}




