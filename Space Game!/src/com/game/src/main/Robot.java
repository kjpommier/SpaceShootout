package com.game.src.main;

import com.game.src.libs.Animation;
import java.util.Random;

public class Robot
  extends Boss
{
  public Robot(double x, double y, Textures tex, Controller c, Game game)
  {
    super(x, y, tex, c, game);
    
    this.anim = new Animation(20, tex.robotBoss[0], tex.robotBoss[1], tex.robotBoss[2], tex.robotBoss[3], tex.robotBoss[4], tex.robotBoss[5]);
  }
  
  public void tick()
  {
    if (this.y >= 150.0D) {
      this.speed = (-this.speed);
    } else if (this.y <= 0.0D) {
      this.speed = (-this.speed);
    }
    if (this.x >= Game.WIDTH - 262) {
      this.speedx = (-this.speedx);
    } else if (this.x <= 0.0D) {
      this.speedx = (-this.speedx);
    }
    this.y += this.speed;
    this.x += this.speedx;
    if (this.y > Game.HEIGHT * 1)
    {
      this.speed = (this.r.nextInt(10) + 1);
      this.y = -10.0D;
      this.x = this.r.nextInt(Game.WIDTH * 1);
    }
    if (Physics.Collision(this, this.game.ea))
    {
      this.hp -= 5;
      if (this.hp == 0)
      {
        Explode explosion = new Explode((int)this.x, (int)this.y, this.c, this.game, this.explode);
        this.c.addExplosion(explosion);
        this.c.dropItem(this);
        this.c.removeEntity(this);
        this.game.setEnemyKilled(this.game.getEnemyKilled() + 1);
        this.game.setScore(this.game.getScore() + 10000);
        if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
          this.game.setPlayerHP(this.game.getPlayerHP() + 25);
        }
      }
    }
    this.anim.runAnimation();
  }
  
  public int getHp()
  {
    return this.hp;
  }
}