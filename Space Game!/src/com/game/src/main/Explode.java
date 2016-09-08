package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Explode
{
  private int x;
  private int y;
  Controller c;
  Game game;
  private BufferedImage explode = null;
  private int counter = 0;
  
  public Explode(int x, int y, Controller c, Game game, BufferedImage img)
  {
    this.x = x;
    this.y = y;
    this.c = c;
    this.game = game;
    
    this.explode = img;
  }
  
  public void render(Graphics g)
  {
    g.drawImage(this.explode, this.x, this.y, this.game);
    this.counter += 1;
  }
  
  public int getCounter()
  {
    return this.counter;
  }
}
