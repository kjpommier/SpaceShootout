package com.game.src.main;

import com.game.src.libs.Animation;
import com.game.src.main.classes.EntityB;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Bomb
  extends Enemy
  implements EntityB
{
  private Animation anim;
  private Random r = new Random();
  private BufferedImage img = null;
  private int delay;
  private int count;
  private int count1 = 2;
  private int hit = 3;
  
  public Bomb(double x, double y, Textures tex, Controller c, Game game)
  {
    super(x, y, tex, c, game);
    
    this.count = 0;
    this.speed = 2;
    this.img = tex.bomb[0];
  }
  
  public void tick()
  {
    this.y += this.speed;
    if (this.y > Game.HEIGHT * 1) {
      if (this.count1 == 0)
      {
        this.c.removeEntity(this);
        if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
          this.game.setPlayerHP(this.game.getPlayerHP() + 25);
        }
      }
      else
      {
        this.speed += 2;
        this.y = -10.0D;
        this.x = this.r.nextInt(Game.WIDTH * 1 - 232);
        this.count1 -= 1;
      }
    }
    if (Physics.Collision(this, this.game.ea)) {
      if (this.hit == 1)
      {
        Explode explosion = new Explode((int)this.x, (int)this.y, this.c, this.game, this.explode);
        this.c.addExplosion(explosion);
        this.c.removeEntity(this);
        
        this.game.setPlayerHP(this.game.getPlayerHP() - 25);
      }
      else
      {
        this.hit -= 1;
      }
    }
  }
  
  public void render(Graphics g)
  {
    if (this.hit == 2) {
      this.img = this.tex.bomb[1];
    } else if (this.hit == 1) {
      this.img = this.tex.bomb[2];
    }
    g.drawImage(this.img, (int)this.x, (int)this.y, this.game);
  }
}
