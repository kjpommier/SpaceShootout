package com.game.src.main.classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract interface EntityC
{

  public abstract void tick();
  
  public abstract void render(Graphics paramGraphics);
  
  public abstract Rectangle getBounds();
  
  public abstract double getX();
  
  public abstract double getY();
  
  public abstract int getType();
}
