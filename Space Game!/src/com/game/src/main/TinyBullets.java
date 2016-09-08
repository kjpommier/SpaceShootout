package com.game.src.main;

import com.game.src.libs.Animation;
import java.awt.Rectangle;

public class TinyBullets
  extends Bullet
{
  public TinyBullets(double x, double y, Textures tex, Game game, Controller c)
  {
    super(x, y, tex, game, c);
    this.anim = new Animation(3, tex.tinyBullets[0], tex.tinyBullets[1], tex.tinyBullets[2]);
    if (x <= 0.0D) {
      x = 0.0D;
    } else if (x >= Game.WIDTH - 232) {
      x = Game.WIDTH - 232;
    }
  }
  
  public Rectangle getBounds()
  {
    return new Rectangle((int)this.x, (int)this.y, 10, 10);
  }
}
