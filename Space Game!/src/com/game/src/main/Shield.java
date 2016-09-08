package com.game.src.main;

import java.awt.Graphics;

public class Shield
{
  private Game game;
  private Players p;
  private Textures tex;
  private double x;
  private double y;
  private boolean isActive = false;
  
  public Shield(double x, double y, Game game, Players p, Textures tex)
  {
    x = p.getX();
    y = p.getY();
    this.game = game;
    this.p = p;
    this.tex = tex;
  }
  
  public void tick()
  {
    if (this.isActive)
    {
      this.x = this.p.getX();
      this.y = this.p.getY();
    }
  }
  
  public void render(Graphics g)
  {
    if (this.isActive) {
      g.drawImage(this.tex.shield, (int)this.x, (int)this.y, this.game);
    }
  }
  
  public void makeShield()
  {
    this.p.setInvincible();
    this.p.setTicksInvi(600);
  }
  
  public boolean getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(boolean r)
  {
    this.isActive = r;
  }
}
