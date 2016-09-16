
void serialEvent(Serial myPort) {
  connected = true;
  if(myPort.available() > 0) {
    String inString = myPort.readStringUntil('\n');
    if (inString != null) {
      String[] list = split(inString, ':');
      pitch = ((int)float(list[0]));
      roll = ((int)float(list[1]));
    }
  }
}