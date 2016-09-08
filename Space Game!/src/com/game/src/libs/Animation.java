package com.game.src.libs;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation
{
  private int speed;
  private int frames;
  private int index = 0;
  private int count = 0;
  private BufferedImage img1;
  private BufferedImage img2;
  private BufferedImage img3;
  private BufferedImage img4;
  private BufferedImage img5;
  private BufferedImage img6;
  private BufferedImage img7;
  private BufferedImage img8;
  private BufferedImage img9;
  private BufferedImage img10;
  private BufferedImage img11;
  private BufferedImage img12;
  private BufferedImage img13;
  private BufferedImage img14;
  private BufferedImage currentImg;
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9, BufferedImage img10, BufferedImage img11, BufferedImage img12, BufferedImage img13, BufferedImage img14)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.img8 = img8;
    this.img9 = img9;
    this.img10 = img10;
    this.img11 = img11;
    this.img12 = img12;
    this.img13 = img13;
    this.img14 = img14;
    this.frames = 14;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9, BufferedImage img10, BufferedImage img11, BufferedImage img12, BufferedImage img13)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.img8 = img8;
    this.img9 = img9;
    this.img10 = img10;
    this.img11 = img11;
    this.img12 = img12;
    this.img13 = img13;
    this.frames = 13;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9, BufferedImage img10, BufferedImage img11, BufferedImage img12)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.img8 = img8;
    this.img9 = img9;
    this.img10 = img10;
    this.img11 = img11;
    this.img12 = img12;
    this.frames = 12;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9, BufferedImage img10, BufferedImage img11)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.img8 = img8;
    this.img9 = img9;
    this.img10 = img10;
    this.img11 = img11;
    this.frames = 11;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9, BufferedImage img10)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.img8 = img8;
    this.img9 = img9;
    this.img10 = img10;
    this.frames = 10;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.img8 = img8;
    this.img9 = img9;
    this.frames = 9;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.img8 = img8;
    this.frames = 8;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6, BufferedImage img7)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.img7 = img7;
    this.frames = 7;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5, BufferedImage img6)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.img6 = img6;
    this.frames = 6;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.img5 = img5;
    this.frames = 5;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.img4 = img4;
    this.frames = 4;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.frames = 3;
  }
  
  public Animation(int speed, BufferedImage img1, BufferedImage img2)
  {
    this.speed = speed;
    this.img1 = img1;
    this.img2 = img2;
    this.frames = 2;
  }
  
  public void runAnimation()
  {
    this.index += 1;
    if (this.index > this.speed)
    {
      this.index = 0;
      nextFrame();
    }
  }
  
  public void nextFrame()
  {
    switch (this.frames)
    {
    case 2: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 3: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 4: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 5: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 6: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 7: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 8: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      if (this.count == 7) {
        this.currentImg = this.img8;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 9: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      if (this.count == 7) {
        this.currentImg = this.img8;
      }
      if (this.count == 8) {
        this.currentImg = this.img9;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 10: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      if (this.count == 7) {
        this.currentImg = this.img8;
      }
      if (this.count == 8) {
        this.currentImg = this.img9;
      }
      if (this.count == 9) {
        this.currentImg = this.img10;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 11: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      if (this.count == 7) {
        this.currentImg = this.img8;
      }
      if (this.count == 8) {
        this.currentImg = this.img9;
      }
      if (this.count == 9) {
        this.currentImg = this.img10;
      }
      if (this.count == 10) {
        this.currentImg = this.img11;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 12: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      if (this.count == 7) {
        this.currentImg = this.img8;
      }
      if (this.count == 8) {
        this.currentImg = this.img9;
      }
      if (this.count == 9) {
        this.currentImg = this.img10;
      }
      if (this.count == 10) {
        this.currentImg = this.img11;
      }
      if (this.count == 11) {
        this.currentImg = this.img12;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 13: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      if (this.count == 7) {
        this.currentImg = this.img8;
      }
      if (this.count == 8) {
        this.currentImg = this.img9;
      }
      if (this.count == 9) {
        this.currentImg = this.img10;
      }
      if (this.count == 10) {
        this.currentImg = this.img11;
      }
      if (this.count == 11) {
        this.currentImg = this.img12;
      }
      if (this.count == 12) {
        this.currentImg = this.img13;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    case 14: 
      if (this.count == 0) {
        this.currentImg = this.img1;
      }
      if (this.count == 1) {
        this.currentImg = this.img2;
      }
      if (this.count == 2) {
        this.currentImg = this.img3;
      }
      if (this.count == 3) {
        this.currentImg = this.img4;
      }
      if (this.count == 4) {
        this.currentImg = this.img5;
      }
      if (this.count == 5) {
        this.currentImg = this.img6;
      }
      if (this.count == 6) {
        this.currentImg = this.img7;
      }
      if (this.count == 7) {
        this.currentImg = this.img8;
      }
      if (this.count == 8) {
        this.currentImg = this.img9;
      }
      if (this.count == 9) {
        this.currentImg = this.img10;
      }
      if (this.count == 10) {
        this.currentImg = this.img11;
      }
      if (this.count == 11) {
        this.currentImg = this.img12;
      }
      if (this.count == 12) {
        this.currentImg = this.img13;
      }
      if (this.count == 13) {
        this.currentImg = this.img14;
      }
      this.count += 1;
      if (this.count > this.frames) {
        this.count = 0;
      }
      break;
    }
  }
  
  public void drawAnimation(Graphics g, double x, double y, int offset)
  {
    g.drawImage(this.currentImg, (int)x - offset, (int)y, null);
  }
  
  public void setCount(int count)
  {
    this.count = count;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getSpeed()
  {
    return this.speed;
  }
  
  public void setSpeed(int speed)
  {
    this.speed = speed;
  }
}