import procontroll.*;
import net.java.games.input.*;
ControllIO controllIO;
ControllDevice joypad;
ControllStick stick2;
ControllStick stick1;
import processing.serial.*;
Serial myPort;

void setup() {
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
    stick1.setTolerance(.06);
    stick1.setMultiplier(90);
    controllerConnected = true;
  }
  catch(Exception e) {
  }
}


void draw() {
  thrust = thrust - 70;
  myPort.write("1:"+leftAileron+":"+rightAileron+":"+elevator+":"+rudder+":"+thrust+":\n");
  println("1:"+leftAileron+":"+rightAileron+":"+elevator+":"+rudder+":"+thrust+":\n");
  delay(20);
  strokeWeight(2);
  stroke(#7C7C7C);
  fill(#7C7C7C);
  rect(0, 0, width, height);

  drawOutputs();
  drawOptions();

  if (keyPressed) {
    //keyEvent();
  }
  if (controllerConnected) {
    x = (int)stick2.getY();
    y = (int)stick2.getX();
    thrust = 90 - (int)stick1.getY();
    rudder = 90 + (int)stick1.getX();
  }
  //head = roll;
  //Dividing Line
  stroke(#FFFFFF);
  line(300, 300, 300, height);
  line(300, 300, width, 300);
  //pitch=roll;
  if (controllerConnected) {
    drawAxes();
  } 
  else {
    testMode();
  }
}

