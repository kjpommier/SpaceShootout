package com.game.src.main;

import com.game.src.libs.Animation;
import com.game.src.main.classes.EntityB;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy
  extends GameObject
  implements EntityB
{
  Random r = new Random();
  protected Textures tex;
  protected Game game;
  protected Controller c;
  protected int hit = 0;
  protected int speed = this.r.nextInt(5) + 1;
  protected int item = 1;
  protected BufferedImage explode = null;
  Animation anim;
  
  public Enemy(double x, double y, Textures tex, Controller c, Game game)
  {
    super(x, y);
    this.tex = tex;
    this.c = c;
    this.game = game;
    
    this.explode = tex.explode;
    this.anim = new Animation(5, tex.enemy[0], tex.enemy[1], tex.enemy[2]);
  }
  
  public void tick()
  {
    this.y += this.speed;
    if (this.y > Game.HEIGHT * 1)
    {
      this.speed = (this.r.nextInt(5) + 1);
      this.y = -10.0D;
      this.x = this.r.nextInt(Game.WIDTH * 1 - 232);
    }
    if (Physics.Collision(this, this.game.ea))
    {
      Explode explosion = new Explode((int)this.x, (int)this.y, this.c, this.game, this.explode);
      this.c.addExplosion(explosion);
      if (this.r.nextInt(15) == 1) {
        this.c.dropItem(this);
      }
      this.c.removeEntity(this);
      this.game.setEnemyKilled(this.game.getEnemyKilled() + 1);
      this.game.setScore(this.game.getScore() + 1000);
      if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
        this.game.setPlayerHP(this.game.getPlayerHP() + 25);
      }
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
  
  public void setY(double y)
  {
    this.y = y;
  }
  
  public double getX()
  {
    return this.x;
  }
  
  public int getHit()
  {
    return this.hit;
  }
}
