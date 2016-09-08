package com.game.src.main;

import com.game.src.libs.Animation;
import java.util.Random;

public class Enemy4
  extends Enemy
{
  private int hp = 2;
  private int speedx = 8;
  
  public Enemy4(double x, double y, Textures tex, Controller c, Game game)
  {
    super(x, y, tex, c, game);
    x = this.r.nextInt(Game.WIDTH * 1 - 232);
    this.anim = new Animation(5, tex.enemy4[0], tex.enemy4[1], tex.enemy4[2]);
  }
  
  public void tick()
  {
    this.y += this.speed;
    if (this.x >= Game.WIDTH * 1 - 232) {
      this.speedx = (-this.speedx);
    } else if (this.x <= 0.0D) {
      this.speedx = (-this.speedx);
    }
    this.x += this.speedx;
    if (this.y >= 730.0D)
    {
      this.speed = (this.r.nextInt(10) + 2);
      this.speedx = (this.r.nextInt(10) + 3);
      this.x = this.r.nextInt(Game.WIDTH * 1 - 232);
      this.y = -10.0D;
    }
    if (Physics.Collision(this, this.game.ea))
    {
      this.hp -= 1;
      if (this.hp == 0)
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
        this.game.setScore(this.game.getScore() + 1000);
        if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
          this.game.setPlayerHP(this.game.getPlayerHP() + 25);
        }
        this.game.setScore(this.game.getScore() + 1000);
        if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
          this.game.setPlayerHP(this.game.getPlayerHP() + 25);
        }
        this.game.setScore(this.game.getScore() + 1000);
        if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
          this.game.setPlayerHP(this.game.getPlayerHP() + 25);
        }
        this.game.setScore(this.game.getScore() + 1000);
        if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
          this.game.setPlayerHP(this.game.getPlayerHP() + 25);
        }
        this.game.setScore(this.game.getScore() + 1000);
        if ((this.game.getScore() % 100000 == 0) && (this.game.getPlayerHP() < 100)) {
          this.game.setPlayerHP(this.game.getPlayerHP() + 25);
        }
      }
    }
    this.anim.runAnimation();
  }
}