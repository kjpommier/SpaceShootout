package com.game.src.main;

import com.game.src.libs.Animation;
import com.game.src.main.classes.EntityC;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Items
  extends GameObject
  implements EntityC
{
  Textures tex;
  Game game;
  Controller c;
  Random r = new Random();
  private BufferedImage img = null;
  Animation anim;
  public int type = 0;
  
  public Items(double x, double y, Textures tex, Game game, Controller c)
  {
    super(x, y);
    this.tex = tex;
    this.game = game;
    this.c = c;
    if (this.r.nextInt(3) + 1 == 1)
    {
      this.type = 1;
      this.anim = new Animation(5, tex.Coin[0], tex.Coin[1], tex.Coin[2]);
    }
    else if (this.r.nextInt(3) + 1 == 2)
    {
      this.type = 2;
      this.img = tex.item;
    }
    else
    {
      this.type = 3;
      this.img = tex.HPItem;
    }
  }
  
  public void tick()
  {
    this.y += 5.0D;
    if (this.y >= Game.HEIGHT) {
      this.c.removeEntity(this);
    }
    if (this.type == 1) {
      this.anim.runAnimation();
    }
  }
  
  public void render(Graphics g)
  {
    if (this.type == 1) {
      this.anim.drawAnimation(g, this.x, this.y, 0);
    } else {
      g.drawImage(this.img, (int)this.x, (int)this.y, this.game);
    }
  }
  
  public Rectangle getBounds()
  {
    return new Rectangle((int)this.x, (int)this.y, 32, 32);
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
    return this.type;
  }
}