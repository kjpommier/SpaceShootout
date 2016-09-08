package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller
{
  private LinkedList<EntityA> ea = new LinkedList();
  private LinkedList<EntityB> eb = new LinkedList();
  private LinkedList<Explode> explosions = new LinkedList();
  private LinkedList<EntityC> ec = new LinkedList();
  EntityA enta;
  EntityB entb;
  EntityC entc;
  Explode e;
  private Textures tex;
  Random r = new Random();
  private Game game;
  
  public Controller(Textures tex, Game game)
  {
    this.tex = tex;
    this.game = game;
  }
  
  public void dropItem(Enemy en)
  {
    addEntity(new Items(en.getX(), en.getY(), this.tex, this.game, this));
  }
  
  public void createEnemy(int enemyCount)
  {
    for (int i = 0; i < enemyCount; i++) {
      addEntity(new Enemy(this.r.nextInt(Game.WIDTH - 232), -10.0D, this.tex, this, this.game));
    }
  }
  
  public void createEnemy2(int enemyCount)
  {
    for (int i = 0; i < enemyCount; i++) {
      addEntity(new Enemy2(this.r.nextInt(Game.WIDTH - 232), -10.0D, this.tex, this, this.game));
    }
  }
  
  public void createEnemy3(int enemyCount)
  {
    for (int i = 0; i < enemyCount; i++) {
      addEntity(new Enemy3(this.r.nextInt(Game.WIDTH - 232), -10.0D, this.tex, this, this.game));
    }
  }
  
  public void createEnemy4(int enemyCount)
  {
    for (int i = 0; i < enemyCount; i++) {
      addEntity(new Enemy4(this.r.nextInt(Game.WIDTH - 232), -10.0D, this.tex, this, this.game));
    }
  }
  
  public void createBomb(int enemyCount)
  {
    for (int i = 0; i < enemyCount; i++) {
      addEntity(new Bomb(this.r.nextInt(Game.WIDTH - 232), -10.0D, this.tex, this, this.game));
    }
  }
  
  public void SummonBoss(int enemyCount)
  {
    for (int i = 0; i < enemyCount; i++) {
      addEntity(new Boss(this.r.nextInt(Game.WIDTH - 232), 1.0D, this.tex, this, this.game));
    }
  }
  
  public void SummonBoss2(int enemyCount)
  {
    for (int i = 0; i < enemyCount; i++) {
      addEntity(new Robot(this.r.nextInt(Game.WIDTH - 262), 1.0D, this.tex, this, this.game));
    }
  }
  
  public void tick()
  {
    for (int i = 0; i < this.ea.size(); i++)
    {
      this.enta = ((EntityA)this.ea.get(i));
      
      this.enta.tick();
    }
    for (int i = 0; i < this.eb.size(); i++)
    {
      this.entb = ((EntityB)this.eb.get(i));
      
      this.entb.tick();
    }
    for (int i = 0; i < this.ec.size(); i++)
    {
      this.entc = ((EntityC)this.ec.get(i));
      this.entc.tick();
    }
  }
  
  public void render(Graphics g)
  {
    for (int i = 0; i < this.ea.size(); i++)
    {
      this.enta = ((EntityA)this.ea.get(i));
      
      this.enta.render(g);
    }
    for (int i = 0; i < this.eb.size(); i++)
    {
      this.entb = ((EntityB)this.eb.get(i));
      
      this.entb.render(g);
    }
    for (int i = 0; i < this.ec.size(); i++)
    {
      this.entc = ((EntityC)this.ec.get(i));
      
      this.entc.render(g);
    }
    for (int i = 0; i < this.explosions.size(); i++)
    {
      this.e = ((Explode)this.explosions.get(i));
      if (this.e.getCounter() == 60) {
        this.explosions.remove(i);
      } else {
        this.e.render(g);
      }
    }
  }
  
  public void addEntity(EntityA block)
  {
    this.ea.add(block);
  }
  
  public void removeEntity(EntityA block)
  {
    this.ea.remove(block);
  }
  
  public void addEntity(EntityB block)
  {
    this.eb.add(block);
  }
  
  public void removeEntity(EntityB block)
  {
    this.eb.remove(block);
  }
  
  public void addEntity(EntityC block)
  {
    this.ec.add(block);
  }
  
  public void removeEntity(EntityC block)
  {
    this.ec.remove(block);
  }
  
  public void addExplosion(Explode block)
  {
    this.explosions.add(block);
  }
  
  public LinkedList<EntityA> getEntityA()
  {
    return this.ea;
  }
  
  public LinkedList<EntityB> getEntityB()
  {
    return this.eb;
  }
  
  public LinkedList<EntityC> getEntityC()
  {
    return this.ec;
  }
  
  public Boss getBoss()
  {
    for (int i = 0; i < this.eb.size(); i++) {
      if ((this.eb.get(i) instanceof Boss)) {
        return (Boss)this.eb.get(i);
      }
    }
    return null;
  }
  
  public void clearEnemyList()
  {
    for (int i = 0; i < this.eb.size(); i++) {
      this.eb.remove(i);
    }
  }
}