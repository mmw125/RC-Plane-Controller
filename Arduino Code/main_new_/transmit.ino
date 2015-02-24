void transmit(){
//  double Xg, Yg, Zg;
//  acc.read(&Xg, &Yg, &Zg);
//
//  //Low Pass Filter
//  fXg = Xg * alpha + (fXg * (1.0 - alpha));
//  fYg = Yg * alpha + (fYg * (1.0 - alpha));
//  fZg = Zg * alpha + (fZg * (1.0 - alpha));
//
//  //Roll & Pitch Equations
//  roll  = (atan2(-fYg, fZg)*180.0)/M_PI;
//  pitch = (atan2(fXg, sqrt(fYg*fYg + fZg*fZg))*180.0)/M_PI;
//  
  Serial2.print(0);
  Serial2.print(":");
  Serial2.print(0);
  Serial2.println(":");
}


