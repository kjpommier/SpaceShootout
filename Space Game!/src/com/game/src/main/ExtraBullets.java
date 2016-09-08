package com.game.src.main;

import java.awt.image.BufferedImage;

public class ExtraBullets
{
  private BufferedImage image;
  
  public ExtraBullets(BufferedImage image)
  {
    this.image = image;
  }
  
  public BufferedImage grabImage(int col, int width, int height)
  {
    BufferedImage img = this.image.getSubimage(col * 10 - 10, 1, width, height);
    return img;
  }
}
