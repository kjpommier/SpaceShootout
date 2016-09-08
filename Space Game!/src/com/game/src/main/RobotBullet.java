package com.game.src.main;

import com.game.src.libs.Animation;
import java.awt.Graphics;

public class RobotBullet
  extends BossBullet
{
  public RobotBullet(double x, double y, Textures tex, Controller c, Game game)
  {
    super(x, y, tex, c, game);
    
    this.anim = new Animation(5, tex.robotBullet[0], tex.robotBullet[1], tex.robotBullet[2], tex.robotBullet[3], 
      tex.robotBullet[4], tex.robotBullet[5], tex.robotBullet[6], tex.robotBullet[7]);
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
}
