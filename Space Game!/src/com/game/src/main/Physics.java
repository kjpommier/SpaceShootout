package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JLabel;

public class Physics
{
  private static Random r = new Random();
  
  public static boolean Collision(EntityA enta, LinkedList<EntityB> entb, Game game)
  {
    for (int i = 0; i < entb.size(); i++) {
      if (enta.getBounds().intersects(((EntityB)entb.get(i)).getBounds()))
      {
        if ((entb.get(i) instanceof Bomb)) {
          entb.remove(i);
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean Collision(EntityB entb, LinkedList<EntityA> enta)
  {
    for (int i = 0; i < enta.size(); i++) {
      if (entb.getBounds().intersects(((EntityA)enta.get(i)).getBounds()))
      {
        if ((enta.get(i) instanceof Bullet)) {
          enta.remove(i);
        } else if ((enta.get(i) instanceof TinyShip)) {
          enta.remove(i);
        } else if ((enta.get(i) instanceof TinyShip2)) {
          enta.remove(i);
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean Collision(EntityA enta, LinkedList<EntityC> entc, Controller c, Game game)
  {
    for (int i = 0; i < entc.size(); i++) {
      if (enta.getBounds().intersects(((EntityC)entc.get(i)).getBounds()))
      {
        if (((EntityC)entc.get(i)).getType() == 1)
        {
          game.setScore(game.getScore() + 1000);
          if ((game.getScore() % 100000 == 0) && (game.getPlayerHP() < 100)) {
            game.setPlayerHP(game.getPlayerHP() + 25);
          }
        }
        else if (((EntityC)entc.get(i)).getType() == 2)
        {
          if (r.nextInt(2) + 1 == 1) {
            game.ammo += 10;
          } else if (game.buddyswitch == 0) {
            game.addBuddy();
          } else if (game.buddyswitch1 == 0) {
            game.addBuddy2();
          } else {
            game.ammo += 10;
          }
        }
        else if (((EntityC)entc.get(i)).getType() == 3)
        {
          if (game.getPlayerHP() < 100)
          {
            game.setPlayerHP(game.getPlayerHP() + 25);
          }
          else
          {
            game.hppots += 1;
            Game.potions.setText("HP POTIONS: " + game.hppots);
          }
        }
        c.removeEntity((EntityC)entc.get(i));
        return true;
      }
    }
    return false;
  }
}