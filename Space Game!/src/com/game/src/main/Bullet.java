package com.game.src.main;

import com.game.src.libs.Animation;
import com.game.src.main.classes.EntityA;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet
  extends GameObject
  implements EntityA
{
  private Textures tex;
  private Game game;
  Animation anim;
  Controller c;
  
  public Bullet(double x, double y, Textures tex, Game game, Controller c)
  {
    super(x, y);
    this.tex = tex;
    this.game = game;
    this.c = c;
    
    this.anim = new Animation(5, tex.missle[0], tex.missle[1], tex.missle[2]);
  }
  
  public void tick()
  {
    this.y -= 12.0D;
    if (this.y <= 0.0D) {
      this.c.removeEntity(this);
    }
    this.anim.runAnimation();
  }
  
  public void render(Graphics g)
  {
    this.anim.drawAnimation(g, this.x, this.y, 0);
  }
  
  public Rectangle getBounds()
  {
    return new Rectangle((int)this.x, (int)this.y, 32, 32);
  }
  
  public double getY()
  {
    return this.y;
  }
  
  public double getX()
  {
    return this.x;
  }
}
