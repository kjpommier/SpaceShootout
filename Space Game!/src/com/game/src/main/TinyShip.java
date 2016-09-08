package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;

public class TinyShip
  extends Players
{
  private BufferedImage img = null;
  private Players p = null;
  protected int lasthp;
  private BufferedImage explode = null;
  
  public TinyShip(double x, double y, Textures tex, Controller c, Game game, Players p)
  {
    super(x, y, tex, c, game);
    this.p = p;
    this.explode = tex.explode;
    this.lasthp = game.getPlayerHP();
    this.img = tex.buddy;
  }
  
  public void tick()
  {
    this.x = (this.p.getX() - 64.0D);
    this.y = (this.p.getY() + 16.0D);
    if (this.lasthp > this.game.getPlayerHP())
    {
      this.c.removeEntity(this);
      this.game.buddyswitch = 0;
    }
    this.lasthp = this.game.getPlayerHP();
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
    if (Physics.Collision(this, this.game.eb, this.game))
    {
      Explode explosion = new Explode((int)this.x, (int)this.y, this.c, this.game, this.explode);
      this.c.addExplosion(explosion);
      this.game.buddyswitch = 0;
      this.c.removeEntity(this);
    }
    if (Physics.Collision(this, this.game.ec, this.c, this.game))
    {
      Game.ItemNot.setVisible(true);
      Game.ItemCounter = 0;
    }
  }
  
  public void render(Graphics g)
  {
    g.drawImage(this.img, (int)this.x, (int)this.y, this.game);
  }
}