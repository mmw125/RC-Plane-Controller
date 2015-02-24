void serialEvent2(){
  while(Serial2.available()){
    char inData[51];
    char nameA[50];
    char valueA[50];
    char amountOfDataChar[50];

    int numRead = Serial2.readBytesUntil('\n',inData,50);
    inData[numRead] = '\n';
    inData[numRead+1] = 0;
    Serial.print(inData);
  

    String nameS = splitString(inData,':',0);
    nameS.toCharArray(nameA, 50);
    int name = atoi(nameA);
    if(name==1){
      String valueS = splitString(inData,':',1);
      valueS.toCharArray(valueA, 50);
      int value = atoi(valueA);
      
      value = numberModifier(value,3);
      //Serial.print("lef = ");
      //Serial.println(value);
      lef.write(value);
    
//      valueS = splitString(inData,':',2);
//      valueS.toCharArray(valueA, 50);
//      value = atoi(valueA);
//      Serial.print("rig = ");
//      Serial.println(value);
//      
//      rig.write(value);


      valueS = splitString(inData,':',3);
      valueS.toCharArray(valueA, 50);
      value = atoi(valueA);
      //Serial.print("ele = ");
      //Serial.println(value);
      value = numberModifier(value,3);
      ele.write(value);

      valueS = splitString(inData,':',4);
      valueS.toCharArray(valueA, 50);
      value = atoi(valueA);
      //Serial.print("rud = ");
      //Serial.println(value);
      value = numberModifier(value,3.5);
      rud.write(value);

      valueS = splitString(inData,':',5);
      valueS.toCharArray(valueA, 50);
      value = atoi(valueA);
      //Serial.print("thr = ");
      //Serial.println(value);
      value = value*1.5;
      thr.write(value);
      
      thr2.write(value);
      Serial.println();
    
      count++;
      if(count == 2){
        transmit();
        count = 0;
       // balanceRoll();
      }
      
    }   
  }
}
int numberModifier(int in,double modifier){
 in = in-90;
 in = in / modifier;
 in = in+90;
 return in;
}



