package com.game.src.main;


import com.game.src.libs.Animation;
import com.game.src.main.classes.EntityB;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BossBullet
  extends GameObject
  implements EntityB
{
  protected Textures tex;
  protected Game game;
  protected Controller c;
  Animation anim;
  
  public BossBullet(double x, double y, Textures tex, Controller c, Game game)
  {
    super(x, y);
    this.tex = tex;
    this.c = c;
    this.game = game;
    
    this.anim = new Animation(5, tex.missle2[0], tex.missle2[1], tex.missle2[2]);
  }
  
  public void tick()
  {
    this.y += 10.0D;
    if (this.y >= Game.HEIGHT * 1) {
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
