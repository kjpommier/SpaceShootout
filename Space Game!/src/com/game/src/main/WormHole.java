package com.game.src.main;

import com.game.src.libs.Animation;
import com.game.src.main.classes.EntityC;
import java.awt.Graphics;
import java.awt.Rectangle;

public class WormHole
  extends GameObject
  implements EntityC
{
  Game game;
  Textures tex;
  Controller c;
  Animation anim;
  
  public WormHole(double x, double y, Game game, Textures tex, Controller c)
  {
    super(x, y);
    x = (Game.WIDTH - 232) / 2;
    y = 150.0D;
    this.game = game;
    this.tex = tex;
    this.c = c;
    
    this.anim = new Animation(5, tex.wormhole[0], tex.wormhole[1], tex.wormhole[2]);
  }
  
  public void tick()
  {
    this.anim.runAnimation();
  }
  
  public void render(Graphics g)
  {
    this.anim.drawAnimation(g, this.x, this.y, 0);
  }
  
  public double getX()
  {
    return this.x;
  }
  
  public double getY()
  {
    return this.y;
  }
  
  public int getType()
  {
    return 4;
  }
  
  public Rectangle getBounds()
  {
    return new Rectangle((int)this.x, (int)this.y, 32, 32);
  }
}
