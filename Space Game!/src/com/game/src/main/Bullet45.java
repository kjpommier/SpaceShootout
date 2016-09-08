package com.game.src.main;

import com.game.src.libs.Animation;
import java.awt.Graphics;

public class Bullet45
  extends Bullet
{
  private int speedx = 0;
  
  public Bullet45(double x, double y, Textures tex, Game game, Controller c)
  {
    super(x, y, tex, game, c);
    this.speedx = Game.bulang;
    
    this.anim = new Animation(3, tex.bullet45[0], tex.bullet45[1], tex.bullet45[2]);
  }
  
  public void tick()
  {
    this.x -= this.speedx;
    this.y -= 4.0D;
    if (this.y <= 0.0D) {
      this.c.removeEntity(this);
    }
    if (this.x <= 0.0D) {
      this.c.removeEntity(this);
    }
    if (this.x >= Game.WIDTH - 232) {
      this.c.removeEntity(this);
    }
    this.anim.runAnimation();
  }
  
  public void render(Graphics g)
  {
    this.anim.drawAnimation(g, this.x, this.y, 0);
  }
}
