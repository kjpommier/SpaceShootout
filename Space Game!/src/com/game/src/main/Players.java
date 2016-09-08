package com.game.src.main;

import com.game.src.libs.Animation;
import com.game.src.main.classes.EntityA;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.PrintStream;
import javax.swing.JLabel;

public class Players
  extends GameObject
  implements EntityA
{
  private double velX = 0.0D;
  private double velY = 0.0D;
  protected Textures tex;
  protected Game game;
  protected Controller c;
  private int invincible = 0;
  private int count = 0;
  private int ticksinvis = 60;
  Animation anim;
  private Shield shield;
  
  public Players(double x, double y, Textures tex, Controller c, Game game)
  {
    super(x, y);
    this.tex = tex;
    this.game = game;
    this.c = c;
    
    this.shield = new Shield(x, y, game, this, tex);
    
    this.anim = new Animation(5, tex.player[0], tex.player[1], tex.player[2]);
  }
  
  public void tick()
  {
    this.shield.tick();
    this.x += this.velX;
    this.y += this.velY;
    if (this.x <= 0.0D) {
      this.x = 0.0D;
    }
    if (this.x >= Game.WIDTH - 232) {
      this.x = (Game.WIDTH - 232);
    }
    if (this.y <= 0.0D) {
      this.y = 0.0D;
    }
    if (this.y >= Game.HEIGHT - 34) {
      this.y = (Game.HEIGHT - 34);
    }
    if (this.invincible == 0)
    {
      if (Physics.Collision(this, this.game.eb, this.game))
      {
        this.game.buddyswitch = 0;
        this.game.buddyswitch1 = 0;
        
        this.game.setPlayerHP(this.game.getPlayerHP() - 25);
        
        setX((Game.WIDTH - 232) / 2);
        setY(Game.HEIGHT + 32);
        if (this.game.getPlayerHP() <= 0)
        {
          System.out.println("GAME OVER YOU DIED...");
          Graphics g = this.game.getGraphics();
          g.drawImage(this.game.getHit4(), 0, 0, null);
          System.out.println("Your score was: " + this.game.getScore());
          System.out.println("You died on round " + this.game.getRound());
          this.game.makeStop();
        }
        this.count = 0;
        this.invincible = 1;
      }
      if (Physics.Collision(this, this.game.ec, this.c, this.game))
      {
        Game.ItemNot.setVisible(true);
        Game.ItemCounter = 0;
      }
    }
    if ((this.invincible == 1) && (this.count >= this.ticksinvis)) {
      this.invincible = 0;
    }
    this.count += 1;
    
    this.anim.runAnimation();
  }
  
  public void render(Graphics g)
  {
    this.anim.drawAnimation(g, this.x, this.y, 0);
    this.shield.render(g);
  }
  
  public void setTicksInvi(int e)
  {
    this.ticksinvis = e;
  }
  
  public void setInvincible()
  {
    this.invincible = 1;
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
  
  public void setX(double x)
  {
    this.x = x;
  }
  
  public void setY(double y)
  {
    this.y = y;
  }
  
  public void setVelX(double velX)
  {
    this.velX = velX;
  }
  
  public void setVelY(double velY)
  {
    this.velY = velY;
  }
  
  public Shield getShield()
  {
    return this.shield;
  }
}