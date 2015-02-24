void testMode() {
  drawSlider(450, 325, 25, 200, 50, 30, leftAileron);
  drawSlider(600, 325, 25, 200, 50, 30, rightAileron);
  drawSlider(750, 325, 25, 200, 50, 30, elevator);
  drawSlider(450, 625, 25, 200, 50, 30, rudder); 
  drawSlider(750, 625, 25, 200, 50, 30, thrust);
  textAlign(CENTER);
  fill(#FFFFFF);
  text("Left Aileron", 450, 590);
  text(leftAileron, 450, 555-leftAileron);
  text("Right Aileron", 600, 590);
  text(rightAileron, 600, 555-rightAileron);
  text("Elevator", 750, 590);
  text(elevator, 750, 555-elevator);
  text("Rudder", 450, 890);
  text(rudder, 450, 855-rudder);
  text("Thrust", 750, 890);
  text(thrust, 750, 855-thrust);
}

