void drawSlider(float a, float b, float c, float d, float e, float f, float g) {
  if (g < 0) {
    g = 0;
  }
  if (g > d) {
    g = d;
  }
  stroke(#FFFFFF);
  fill(#424242);
  line(a, b, a, b+d+2*c);
  rect(a - (.5 * e), b + c + d - g - (.5 * f), e, f);
}

void drawOutputs() {
  //Altimeter
  stroke(#000000);
  textAlign(CENTER);
  textSize(25);
  fill(#C7C7C7);
  ellipse(120, 150, 200, 200);
  fill(#000000);
  text("Altitude= 0", 120, 160);

  //Pitch
  fill(#C7C7C7);
  textSize(12);
  ellipse(340, 150, 200, 200);
  text("Pitch= " + pitch, 340, 45);
  line(340 + 90 * cos(pitch * 3.14 / 180), 150 - 90 * sin(pitch * 3.14 / 180), 340 - 90 * cos(pitch * 3.14 / 180), 150 + 90 * sin(pitch * 3.14 / 180));
  line(340 + 60 * cos((pitch + 15) * 3.14 / 180), 150 - 60 * sin((pitch + 15) * 3.14 / 180), 340 + 90 * cos(pitch * 3.14 / 180), 150 - 90 * sin(pitch * 3.14 / 180));

  //Heading
  ellipse(560, 150, 200, 200);
  text("Heading= "+head, 560, 45);
  int offset = 60;
  line(560 + 90 * cos((head + 90) * 3.14 / 180), 150 - 90 * sin((head + 90) * 3.14 / 180), 560 - 90 * cos((head + 90) * 3.14 / 180), 150 + 90 * sin((head + 90) * 3.14 / 180));
  line(560 + 40 * cos((head + 180) * 3.14 / 180), 150 - 40 * sin((head + 180) * 3.14 / 180), 560 - 40 * cos((head + 180) * 3.14 / 180), 150 + 40 * sin((head + 180) * 3.14 / 180));
  line(560 + 90 * cos((head + 90) * 3.14 / 180), 150 - 90 * sin((head + 90) * 3.14 / 180), 
  560 + 60 * cos((head + 105) * 3.14 / 180), 150 - 60 * sin((head + 105) * 3.14 / 180));
  line(560 + 90 * cos((head + 90) * 3.14 / 180), 150 - 90 * sin((head + 90) * 3.14 / 180), 
  560 + 60 * cos((head + 75) * 3.14 / 180), 150 - 60 * sin((head + 75) * 3.14 / 180));

  //Roll
  text("Roll= " + roll, 780, 45);
  ellipse(780, 150, 200, 200);
  line(780 + 90 * cos(roll * 3.14 / 180), 150 - 90 * sin(roll * 3.14 / 180), 
  780 - 90*cos(roll*3.14/180), 150 + 90 * sin(roll * 3.14 / 180));
  line(780 + 15 * cos((roll + 90) * 3.14 / 180), 150 - 15 * sin((roll + 90) * 3.14 / 180), 
  780 - 30 * cos((roll + 90) * 3.14 / 180), 150 + 30 * sin((roll + 90) * 3.14 / 180));
}

void drawOptions() {
  if(connected){
    fill(#7C7C7C);
    rect(175, 850, 100, 25);
    fill(#000000);
    text("Connected", 225, 870);
  } else {
    fill(#000000);
    rect(175, 850, 100, 25);
	fill(#FFFFFF);
	text("Not Connected", 225, 870);
  }
}
