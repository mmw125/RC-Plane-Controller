void balanceRoll(){
  if(controllerRoll != roll){

    double offset = abs(controllerRoll - roll);
    offset = sqrt(offset);
    if(controllerRoll > roll){
      rig.write(90-offset);
      lef.write(90+offset);
    }else{
      rig.write(90+offset);
      lef.write(90-offset);
    }
  }
}




