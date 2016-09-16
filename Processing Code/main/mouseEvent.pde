void mouseDragged() {
  if (controllerConnected == false) {
    if (mouseY > (520-leftAileron) && mouseY < (600 - leftAileron) && mouseX < 500 && mouseX > 400) {
      leftAileron = leftAileron + (pmouseY - mouseY);
      if (leftAileron > 200) {
        leftAileron = 200;
      }
      else if (leftAileron < 0) {
        leftAileron = 0;
      }
    }
    else if (mouseY > (520 - rightAileron) && mouseY < (600 - rightAileron) && mouseX<650 && mouseX>550) {
      rightAileron = rightAileron+(pmouseY-mouseY);
      if (rightAileron>200) {
        rightAileron=200;
      }
      else if (rightAileron<0) {
        rightAileron=0;
      }
    }
    else if (mouseY > (520 - elevator) && mouseY < (600 - elevator) && mouseX < 800 && mouseX > 700) {
      elevator = elevator + (pmouseY - mouseY);
      if (elevator > 200) {
        elevator = 200;
      }
      else if (elevator < 0) {
        elevator=0;
      }
    }
    else if (mouseY > (820 - thrust) && mouseY < (900 - thrust) && mouseX < 800 && mouseX > 700) {
      thrust = thrust + (pmouseY - mouseY);
      if (thrust > 200) {
        thrust = 200;
      }
      else if (thrust < 0) {
        thrust = 0;
      }
    }
    else if (mouseY > (820 - rudder) && mouseY < (900 - rudder) && mouseX < 500 && mouseX > 400) {
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