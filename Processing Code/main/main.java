import processing.core.*; 
import processing.xml.*; 

import procontroll.*; 
import net.java.games.input.*; 
import processing.serial.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class main extends PApplet {

ControllIO controllIO;
ControllDevice joypad;
ControllStick stick2;
ControllStick stick1;

Serial myPort;

public void setup() {
  size(900, 900);
  println(Serial.list());
  myPort = new Serial(this, Serial.list()[0], 19200);
  controllIO = ControllIO.getInstance(this);
  try {
    joypad = controllIO.getDevice("FireStorm Dual Analog 2");
    stick2 = joypad.getStick(1);
    stick2.setTolerance(0.06f);
    stick2.setMultiplier(90f);
    stick1 = joypad.getStick(0);
    stick1.setTolerance(.06f);
    stick1.setMultiplier(90);
    controllerConnected = true;
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}


public void draw() {
  thrust = thrust - 70;
  myPort.write("1:" + leftAileron + ":" + rightAileron + ":" + elevator + ":" + rudder + ":" + thrust + ":\n");
  println("1:" + leftAileron + ":" + rightAileron + ":" + elevator + ":" + rudder + ":" + thrust + ":\n");
  delay(20);
  strokeWeight(2);
  stroke(0xff7C7C7C);
  fill(0xff7C7C7C);
  rect(0, 0, width, height);

  drawOutputs();
  drawOptions();

  if (keyPressed) {
    //keyEvent();
  }
  if (controllerConnected) {
    x = (int) stick2.getY();
    y = (int) stick2.getX();
    thrust = 90 - (int) stick1.getY();
    rudder = 90 + (int) stick1.getX();
  }
  //head = roll;
  //Dividing Line
  stroke(0xffFFFFFF);
  line(300, 300, 300, height);
  line(300, 300, width, 300);
  //pitch=roll;
  if (controllerConnected) {
    drawAxes();
  } else {
    testMode();
  }
}

public void drawAxes() {
  fill(255);
  stroke(0xff000000);
  int tempX = x * 300 / 90;
  int tempY = y * 300 / 90;

  line(tempX + 600, 300, tempX + 600, height);
  line(300, 600 + tempY, width, 600 + tempY);

  textAlign(LEFT);
  textSize(20);
  leftAileron = x + 90;
  rightAileron = 90 - x;
  elevator = 90 + y;
  text("Left Aileron " + leftAileron, 5, 320);
  text("Right Aileron " + rightAileron, 5, 345);
  text("Elevator " + elevator, 5, 370);
  text("Rudder " + rudder, 5, 395);
  text("Thrust " + thrust, 5, 420);

  stroke(0xff424242);
  line(600, 300, 600, height);
  line(300, 600, width, 600);

  //Intersection Box
  fill(0xffC7C7C7);
  stroke(0xff424242);
  rect(tempX - 5 + 600, tempY + 600 - 5, 10, 10);
}

public void drawSlider(float a, float b, float c, float d, float e, float f, float g) {
  if (g < 0) {
    g = 0;
  }
  if (g > d) {
    g = d;
  }
  stroke(0xffFFFFFF);
  fill(0xff424242);
  line(a, b, a, b+d+2*c);
  rect(a - (.5f * e), b + c + d - g - (.5f * f), e, f);
}

public void drawOutputs() {
  //Altimeter
  stroke(0xff000000);
  textAlign(CENTER);
  textSize(25);
  fill(0xffC7C7C7);
  ellipse(120, 150, 200, 200);
  fill(0xff000000);
  text("Altitude= 0", 120, 160);

  //Pitch
  fill(0xffC7C7C7);
  textSize(12);
  ellipse(340, 150, 200, 200);
  text("Pitch= "+pitch, 340, 45);
  line(340+90*cos(pitch*3.14f/180), 150-90*sin(pitch*3.14f/180), 340-90*cos(pitch*3.14f/180), 150+90*sin(pitch*3.14f/180));
  line(340+60*cos((pitch+15)*3.14f/180), 150-60*sin((pitch+15)*3.14f/180), 340+90*cos(pitch*3.14f/180), 150-90*sin(pitch*3.14f/180));

  //Heading
  ellipse(560, 150, 200, 200);
  text("Heading= "+head, 560, 45);
  int offset= 60;
  line(560+90*cos((head+90)*3.14f/180), 150-90*sin((head+90)*3.14f/180), 560-90*cos((head+90)*3.14f/180), 150+90*sin((head+90)*3.14f/180));
  line(560+40*cos((head+180)*3.14f/180), 150-40*sin((head+180)*3.14f/180), 560-40*cos((head+180)*3.14f/180), 150+40*sin((head+180)*3.14f/180));
  line(560+90*cos((head+90)*3.14f/180), 150-90*sin((head+90)*3.14f/180), 
  560+60*cos((head+105)*3.14f/180), 150-60*sin((head+105)*3.14f/180));
  line(560+90*cos((head+90)*3.14f/180), 150-90*sin((head+90)*3.14f/180), 
  560+60*cos((head+75)*3.14f/180), 150-60*sin((head+75)*3.14f/180));

  //Roll
  text("Roll= "+roll, 780, 45);
  ellipse(780, 150, 200, 200);
  line(780+90*cos(roll*3.14f/180), 150-90*sin(roll*3.14f/180), 
  780-90*cos(roll*3.14f/180), 150+90*sin(roll*3.14f/180));
  line(780+15*cos((roll+90)*3.14f/180), 150-15*sin((roll+90)*3.14f/180), 
  780-30*cos((roll+90)*3.14f/180), 150+30*sin((roll+90)*3.14f/180));
}

public void drawOptions() {
  if(connected){
    fill(0xff7C7C7C);
    rect(175, 850, 100, 25);
    fill(0xff000000);
    text("Connected", 225, 870);
  }else{
    fill(0xff000000);
    rect(175, 850, 100, 25);
    fill(0xffFFFFFF);
    text("Not Connected", 225, 870);
  }
}

int v = 0;
int x = 0;
int y = 0;
int option = 0;
int roll = 0; //this is in degrees
int head = 0;
int pitch = 0;

int rudder = 90, rudderLast = 0, leftAileron = 90, leftAileronLast = 0, rightAileron = 90, rightAileronLast = 0;
int thrust = 0, thrustLast = 0, elevator = 90, elevatorLast = 0;
boolean connected = false, ready = true, controllerConnected = false, axesSelected = true;
String data = "";

public void mouseDragged() {
  if (controllerConnected == false) {
    if (mouseY > (520 - leftAileron) && mouseY < (600 - leftAileron) && mouseX < 500 && mouseX > 400) {
      leftAileron = leftAileron + (pmouseY - mouseY);
      if (leftAileron > 200) {
        leftAileron = 200;
      }
      else if (leftAileron < 0) {
        leftAileron = 0;
      }
    }
    else if (mouseY > (520 - rightAileron) && mouseY < (600 - rightAileron) && mouseX < 650 && mouseX > 550) {
      rightAileron = rightAileron + (pmouseY - mouseY);
      if (rightAileron > 200) {
        rightAileron = 200;
      }
      else if (rightAileron < 0) {
        rightAileron = 0;
      }
    }
    else if (mouseY > (520 - elevator) && mouseY < (600 - elevator) && mouseX < 800 && mouseX > 700) {
      elevator = elevator+(pmouseY-mouseY);
      if (elevator>200) {
        elevator=200;
      }
      else if (elevator < 0) {
        elevator = 0;
      }
    }
    else if (mouseY > (820-thrust) && mouseY < (900 - thrust) && mouseX < 800 && mouseX > 700) {
      thrust = thrust+(pmouseY-mouseY);
      if (thrust>200) {
        thrust=200;
      }
      else if (thrust<0) {
        thrust=0;
      }
    }
    else if (mouseY > (820-rudder) && mouseY < (900-rudder) && mouseX<500 && mouseX>400) {
      rudder = rudder + (pmouseY - mouseY);
      if (rudder > 200) {
        rudder = 200;
      }
      else if (rudder < 0) {
        rudder = 0;
      }
    }
  }
}

public void serialEvent(Serial myPort) {
  connected = true;
  if(myPort.available () > 0) {
    String inString = myPort.readStringUntil('\n');
    if (inString != null) {
      String[] list = split(inString, ':');
      pitch = ((int)PApplet.parseFloat(list[0]));
      roll = ((int)PApplet.parseFloat(list[1]));
    }
  }
}

public void testMode() {
  drawSlider(450, 325, 25, 200, 50, 30, leftAileron);
  drawSlider(600, 325, 25, 200, 50, 30, rightAileron);
  drawSlider(750, 325, 25, 200, 50, 30, elevator);
  drawSlider(450, 625, 25, 200, 50, 30, rudder); 
  drawSlider(750, 625, 25, 200, 50, 30, thrust);
  textAlign(CENTER);
  fill(0xffFFFFFF);
  text("Left Aileron", 450, 590);
  text(leftAileron, 450, 555 - leftAileron);
  text("Right Aileron", 600, 590);
  text(rightAileron, 600, 555 - rightAileron);
  text("Elevator", 750, 590);
  text(elevator, 750, 555 - elevator);
  text("Rudder", 450, 890);
  text(rudder, 450, 855 - rudder);
  text("Thrust", 750, 890);
  text(thrust, 750, 855 - thrust);
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "main" });
  }
}