package com.game.src.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader
{
  private BufferedImage image;
  
  public BufferedImage loadImage(String path)
    throws IOException
  {
    this.image = ImageIO.read(this.getClass().getResource(path));
    return this.image;
  }
}
