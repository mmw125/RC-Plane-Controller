void drawAxes() {
  fill(255);
  stroke(#000000);
  int tempX = x*300/90;
  int tempY = y*300/90;

  line(tempX+600, 300, tempX+600, height);
  line(300, 600+tempY, width, 600+tempY);

  textAlign(LEFT);
  textSize(20);
  leftAileron = x+90;
  rightAileron = 90-x;
  elevator = 90+y;
  text("Left Aileron "+leftAileron, 5, 320);
  text("Right Aileron "+rightAileron, 5, 345);
  text("Elevator "+elevator, 5, 370);
  text("Rudder "+rudder, 5, 395);
  text("Thrust "+thrust, 5, 420);

  stroke(#424242);
  line(600, 300, 600, height);
  line(300, 600, width, 600);

  //Intersection Box
  fill(#C7C7C7);
  stroke(#424242);
  rect(tempX-5+600, tempY+600-5, 10, 10);
}

