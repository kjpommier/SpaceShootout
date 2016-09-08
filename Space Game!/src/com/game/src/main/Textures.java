package com.game.src.main;


import java.awt.image.BufferedImage;

public class Textures
{
  private SpriteSheet ss;
  private ExtraBullets Eb;
  private RobotBoss rb;
  public BufferedImage[] player = new BufferedImage[3];
  public BufferedImage[] enemy = new BufferedImage[3];
  public BufferedImage[] enemy2 = new BufferedImage[3];
  public BufferedImage[] enemy3 = new BufferedImage[3];
  public BufferedImage[] boss = new BufferedImage[3];
  public BufferedImage[] missle = new BufferedImage[3];
  public BufferedImage[] missle2 = new BufferedImage[3];
  public BufferedImage explode = null;
  public BufferedImage item = null;
  public BufferedImage HPItem = null;
  public BufferedImage[] bullet45 = new BufferedImage[3];
  public BufferedImage[] Coin = new BufferedImage[3];
  public BufferedImage[] enemy4 = new BufferedImage[3];
  public BufferedImage[] tinyBullets = new BufferedImage[3];
  public BufferedImage[] robotBoss = new BufferedImage[6];
  public BufferedImage shield = null;
  public BufferedImage cake = null;
  public BufferedImage[] bomb = new BufferedImage[3];
  public BufferedImage buddy = null;
  public BufferedImage[] wormhole = new BufferedImage[3];
  public BufferedImage[] robotBullet = new BufferedImage[8];
  
  public Textures(Game game)
  {
    this.ss = new SpriteSheet(game.getSpriteSheet());
    this.Eb = new ExtraBullets(game.getExtraBullets());
    this.rb = new RobotBoss(game.getRobot());
    getTextures();
  }
  
  private void getTextures()
  {
    this.player[0] = this.ss.grabImage(1, 1, 32, 32);
    this.player[1] = this.ss.grabImage(1, 2, 32, 32);
    this.player[2] = this.ss.grabImage(1, 3, 32, 32);
    
    this.missle[0] = this.ss.grabImage(2, 1, 32, 32);
    this.missle[1] = this.ss.grabImage(2, 2, 32, 32);
    this.missle[2] = this.ss.grabImage(2, 3, 32, 32);
    
    this.enemy[0] = this.ss.grabImage(3, 1, 32, 32);
    this.enemy[1] = this.ss.grabImage(3, 2, 32, 32);
    this.enemy[2] = this.ss.grabImage(3, 3, 32, 32);
    
    this.enemy2[0] = this.ss.grabImage(4, 1, 32, 32);
    this.enemy2[1] = this.ss.grabImage(4, 2, 32, 32);
    this.enemy2[2] = this.ss.grabImage(4, 3, 32, 32);
    
    this.enemy3[0] = this.ss.grabImage(5, 1, 32, 32);
    this.enemy3[1] = this.ss.grabImage(5, 2, 32, 32);
    this.enemy3[2] = this.ss.grabImage(5, 3, 32, 32);
    
    this.enemy4[0] = this.ss.grabImage(9, 1, 32, 32);
    this.enemy4[1] = this.ss.grabImage(9, 2, 32, 32);
    this.enemy4[2] = this.ss.grabImage(9, 3, 32, 32);
    
    this.boss[0] = this.ss.grabImage(6, 1, 32, 32);
    this.boss[1] = this.ss.grabImage(6, 2, 32, 32);
    this.boss[2] = this.ss.grabImage(6, 3, 32, 32);
    
    this.missle2[0] = this.ss.grabImage(7, 1, 32, 32);
    this.missle2[1] = this.ss.grabImage(7, 2, 32, 32);
    this.missle2[2] = this.ss.grabImage(7, 3, 32, 32);
    
    this.explode = this.ss.grabImage(8, 1, 32, 32);
    
    this.item = this.ss.grabImage(8, 2, 32, 32);
    
    this.HPItem = this.ss.grabImage(8, 3, 32, 32);
    
    this.Coin[0] = this.ss.grabImage(10, 1, 32, 32);
    this.Coin[1] = this.ss.grabImage(10, 2, 32, 32);
    this.Coin[2] = this.ss.grabImage(10, 3, 32, 32);
    
    this.bullet45[0] = this.ss.grabImage(1, 4, 32, 32);
    this.bullet45[1] = this.ss.grabImage(1, 5, 32, 32);
    this.bullet45[2] = this.ss.grabImage(2, 4, 32, 32);
    
    this.tinyBullets[0] = this.Eb.grabImage(1, 10, 10);
    this.tinyBullets[1] = this.Eb.grabImage(2, 10, 10);
    this.tinyBullets[2] = this.Eb.grabImage(3, 10, 10);
    
    this.shield = this.ss.grabImage(4, 4, 32, 32);
    
    this.cake = this.ss.grabImage(5, 4, 32, 32);
    
    this.buddy = this.ss.grabImage(6, 4, 32, 32);
    
    this.bomb[0] = this.ss.grabImage(2, 5, 32, 32);
    this.bomb[1] = this.ss.grabImage(3, 4, 32, 32);
    this.bomb[2] = this.ss.grabImage(3, 5, 32, 32);
    
    this.wormhole[0] = this.ss.grabImage(4, 5, 32, 32);
    this.wormhole[1] = this.ss.grabImage(5, 5, 32, 32);
    this.wormhole[2] = this.ss.grabImage(6, 5, 32, 32);
    
    this.robotBoss[0] = this.rb.grabImage(1);
    this.robotBoss[1] = this.rb.grabImage(2);
    this.robotBoss[2] = this.rb.grabImage(3);
    this.robotBoss[3] = this.rb.grabImage(4);
    this.robotBoss[4] = this.rb.grabImage(5);
    this.robotBoss[5] = this.rb.grabImage(6);
    
    this.robotBullet[0] = this.ss.grabImage(7, 4, 32, 32);
    this.robotBullet[1] = this.ss.grabImage(7, 5, 32, 32);
    this.robotBullet[2] = this.ss.grabImage(8, 4, 32, 32);
    this.robotBullet[3] = this.ss.grabImage(8, 5, 32, 32);
    this.robotBullet[4] = this.ss.grabImage(9, 4, 32, 32);
    this.robotBullet[5] = this.ss.grabImage(9, 5, 32, 32);
    this.robotBullet[6] = this.ss.grabImage(10, 4, 32, 32);
    this.robotBullet[7] = this.ss.grabImage(10, 5, 32, 32);
  }
}