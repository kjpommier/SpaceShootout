package com.game.src.main;


import java.awt.image.BufferedImage;

public class RobotBoss
{
  private BufferedImage image;
  
  public RobotBoss(BufferedImage image)
  {
    this.image = image;
  }
  
  public BufferedImage grabImage(int col)
  {
    BufferedImage img = this.image.getSubimage(col * 62 - 62, 0, 62, 93);
    return img;
  }
}
