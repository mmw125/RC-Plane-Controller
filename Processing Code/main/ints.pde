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

