package com.xmm.design.bridge.bridge;

public abstract class Shape {
    IColor iColor;
    
    public void setIColor(IColor iColor){
        this.iColor = iColor;
    }

    public abstract  void draw();
}
