package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class Game
  extends Canvas
  implements Runnable, MouseListener
{
  //static Toolkit tk;
  static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  private static final long serialVersionUID = 1L;
  public static final int WIDTH = (int) screenSize.getWidth();
  public static final int HEIGHT = (int) screenSize.getHeight();
  public static final int SCALE = 1;
  public final String TITLE = "SPACE SHOOTOUT!";
  private boolean running = false;
  private Thread thread;
  private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, 1);
  private BufferedImage spriteSheet = null;
  private BufferedImage background = null;
  private BufferedImage background2 = null;
  private BufferedImage hit2 = null;
  private BufferedImage hit3 = null;
  private BufferedImage hit4 = null;
  public BufferedImage[] bossHP = new BufferedImage[11];
  public BufferedImage startscreen = null;
  private BufferedImage extraBullets = null;
  private BufferedImage robot = null;
  private Random r = new Random();
  private boolean isShooting = false;
  private int enemyCount = 5;
  private int enemyKilled = 0;
  private static int round = 1;
  private int sec = 59;
  private static int min = 2;
  private static int seconds = 0;
  private int BossTrigger = 0;
  private int playerHP = 100;
  private static int Score = 0;
  private int bossCounter = 1;
  private int BossDead = 0;
  private int once = 0;
  public static int ItemCounter = 0;
  public static int bulang = -4;
  public static int itemgot = 0;
  public int ammo = 0;
  public int hppots = 0;
  private int toggle = 0;
  private static int Pause = 0;
  public int buddyswitch = 0;
  public int buddyswitch1 = 0;
  public int wormholecount = 0;
  private static boolean start = false;
  private Players p;
  private Controller c;
  private Textures tex;
  public LinkedList<EntityA> ea;
  public LinkedList<EntityB> eb;
  public LinkedList<EntityC> ec;
  public static Game game = new Game();
  
  static
  {
    game.getClass();
  }
  
  public static JFrame frame = new JFrame("SPACE SHOOTOUT!");
  public static JLabel label1 = new JLabel("Score: " + Score);
  public static JLabel Clock = new JLabel(min + "min : " + seconds + "sec");
  public static JLabel Roundlbl = new JLabel("Round: " + round);
  public static JFrame StartMenu = new JFrame("SPACE SHOOTOUT!");
  public static JFrame frame2 = new JFrame("Extras");
  public static JFrame pauseMenu = new JFrame("Menu");
  public static JButton StBut = new JButton("START");
  public static JLabel ItemNot = new JLabel("You Got an Item");
  public static JLabel fpsl = new JLabel(" Ticks, FPS ");
  public static JLabel ammoLbl = new JLabel("Special Ammo: ");
  public static JLabel ammoTog = new JLabel("Toggle: OFF");
  public static JLabel paused = new JLabel("PAUSED");
  public static JLabel potions = new JLabel("HP POTIONS: ");
  private static String[] songs = { "res/01-main-theme-overworld.wav", "res/skrillex_bangarang.wav", "res/03. Dont Kill.wav", "res/YouDaBoss.wav", 
    "res/mario.wav", "res/PeanutButter Jelly.wav", "res/27. Fuckin Problems.wav", "res/28. Feds Watching.wav", "res/21. FuckWitMeYouKnowIGotIt.wav", 
    "res/22. UOENO.wav" };
  private static JTextField textfield1 = new JTextField(
    "Choose a song to play: ");
  private static JTextField textfield2 = new JTextField(15);
  private static JComboBox comboBox = new JComboBox();
  private static JLabel combLbl = new JLabel("Select the song you want to play:");
  private static JLabel pauseMenuLbl = new JLabel("MENU");
  public static AudioPlayer02 music = new AudioPlayer02();
  private static JButton playb = music.playBtn;
  private static JButton stopb = music.stopBtn;
  public static TinyShip ship1 = null;
  private int toggle2 = 0;
  
  private void init()
  {
    requestFocus();
    BufferedImageLoader loader = new BufferedImageLoader();
    try
    {
      this.spriteSheet = loader.loadImage("/SpriteSheet.png");
      this.extraBullets = loader.loadImage("/Extra_Bullets.png");
      this.robot = loader.loadImage("/RobotBoss.png");
      this.background = loader.loadImage("/BackGround.png");
      this.background2 = loader.loadImage("/BackGround2.png");
      
      this.hit3 = loader.loadImage("/BackGround2hit4.png");
      this.hit4 = loader.loadImage("/BackGroundhit4.png");
      this.bossHP[0] = loader.loadImage("/BossHP.png");
      this.bossHP[1] = loader.loadImage("/BossHPhit1.png");
      this.bossHP[2] = loader.loadImage("/BossHPhit2.png");
      this.bossHP[3] = loader.loadImage("/BossHPhit3.png");
      this.bossHP[4] = loader.loadImage("/BossHPhit4.png");
      this.bossHP[5] = loader.loadImage("/BossHPhit5.png");
      this.bossHP[6] = loader.loadImage("/BossHPhit6.png");
      this.bossHP[7] = loader.loadImage("/BossHPhit7.png");
      this.bossHP[8] = loader.loadImage("/BossHPhit8.png");
      this.bossHP[9] = loader.loadImage("/BossHPhit9.png");
      this.bossHP[10] = loader.loadImage("/BossHPdead.png");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    this.tex = new Textures(this);
    
    this.c = new Controller(this.tex, this);
    this.p = new Players((WIDTH - 232) / 2, HEIGHT + 32, this.tex, this.c, this);
    
    this.ea = this.c.getEntityA();
    this.eb = this.c.getEntityB();
    this.ec = this.c.getEntityC();
    
    addKeyListener(new KeyInput(this));
    addMouseListener(this);
    
    this.c.createEnemy(this.enemyCount);
  }
  
  public void mousePressed(MouseEvent e)
  {
    int butt = e.getButton();
    if ((butt == 1) && (!this.isShooting))
    {
      this.isShooting = true;
      if ((this.ammo > 0) && (this.toggle == 1))
      {
        this.c.addEntity(new Bullet(this.p.getX(), this.p.getY(), this.tex, this, this.c));
        bulang = -4;
        this.c.addEntity(new Bullet45(this.p.getX(), this.p.getY(), this.tex, this, this.c));
        bulang = 4;
        this.c.addEntity(new Bullet45(this.p.getX(), this.p.getY(), this.tex, this, this.c));
        this.ammo -= 1;
      }
      else
      {
        this.c.addEntity(new Bullet(this.p.getX(), this.p.getY(), this.tex, this, this.c));
      }
      ammoLbl.setText("Special Ammo: " + this.ammo);
    }
  }
  
  public void mouseReleased(MouseEvent e)
  {
    int butt = e.getButton();
    if (butt == 1) {
      this.isShooting = false;
    }
  }
  
  private synchronized void start()
  {
    if (this.running) {
      return;
    }
    this.running = true;
    this.thread = new Thread(this);
    this.thread.start();
  }
  
  private synchronized void stop()
  {
    if (!this.running) {
      return;
    }
    this.running = false;
    try
    {
      this.thread.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.exit(1);
  }
  
  public void makeStop()
  {
    stop();
  }
  
  public void run()
  {
    init();
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0D;
    double ms = 1.6666666666666666E7D;
    double delta = 0.0D;
    int updates = 0;
    int frames = 0;
    long timer = System.currentTimeMillis();
    while (this.running)
    {
      long now = System.nanoTime();
      delta += (now - lastTime) / ms;
      lastTime = now;
      if (delta >= 1.0D)
      {
        if ((Pause == 0) && (start))
        {
          if (this.once == 0)
          {
            frame.setVisible(true);
            frame2.setVisible(true);
            
            this.once = 1;
          }
          if (frame.isActive()) {
            tick();
          }
        }
        delta -= 1.0D;
        updates++;
      }
      if ((Pause == 0) && (start) && (frame.isActive())) {
        render();
      }
      frames++;
      if (System.currentTimeMillis() - timer > 1000L)
      {
        timer += 1000L;
        fpsl.setText(updates + " Ticks, FPS " + frames);
        
        updates = 0;
        ItemCounter += 1;
        if (ItemCounter == 2) {
          ItemNot.setVisible(false);
        }
        frames = 0;
        if ((Pause == 0) && (start) && (frame.isActive())) {
          tickClock();
        }
      }
    }
    stop();
  }
  
  private void tick()
  {
    this.p.tick();
    this.c.tick();
    if (this.r.nextInt(1000) == 1) {
      this.c.createBomb(1);
    }
    if (this.BossTrigger == 1)
    {
      if (this.BossDead < 60) {
        this.BossDead += 1;
      }
      if (this.BossDead == 60) {
        this.BossTrigger = 0;
      }
    }
    else if (this.enemyKilled >= this.enemyCount)
    {
      if (round >= 30)
      {
        if (round == 30) {
          this.enemyCount = 4;
        } else {
          this.enemyCount += 16;
        }
        this.enemyKilled = 0;
        round += 1;
        
        this.c.createEnemy(this.enemyCount / 4);
        this.c.createEnemy2(this.enemyCount / 4);
        this.c.createEnemy3(this.enemyCount / 4);
        this.c.createEnemy4(this.enemyCount / 4);
        
        resetClock();
        updateRound();
      }
      else if (round == 29)
      {
        this.enemyCount = 1;
        this.enemyKilled = 0;
        round += 1;
        this.c.SummonBoss2(1);
        resetClock();
        updateRound();
      }
      else if (round >= 23)
      {
        if (round == 23) {
          this.enemyCount = 5;
        } else {
          this.enemyCount += 6;
        }
        this.enemyKilled = 0;
        round += 1;
        
        this.c.createEnemy4(this.enemyCount);
        
        resetClock();
        updateRound();
      }
      else if (round >= 20)
      {
        if (round == 20) {
          this.enemyCount = 6;
        } else {
          this.enemyCount += 18;
        }
        this.enemyKilled = 0;
        round += 1;
        
        this.c.createEnemy(this.enemyCount / 3);
        this.c.createEnemy2(this.enemyCount / 3);
        this.c.createEnemy3(this.enemyCount / 3);
        
        resetClock();
        updateRound();
      }
      else if (round == 19)
      {
        this.enemyCount = 1;
        this.enemyKilled = 0;
        round += 1;
        
        this.c.SummonBoss(1);
        resetClock();
        updateRound();
      }
      else if (round >= 14)
      {
        if (round == 14) {
          this.enemyCount = 5;
        } else {
          this.enemyCount += 20;
        }
        this.enemyKilled = 0;
        round += 1;
        
        this.c.createEnemy3(this.enemyCount);
        
        resetClock();
        updateRound();
      }
      else if (round >= 7)
      {
        if (round == 7) {
          this.enemyCount = 5;
        } else {
          this.enemyCount += 12;
        }
        this.enemyKilled = 0;
        round += 1;
        
        this.c.createEnemy2(this.enemyCount);
        
        resetClock();
        updateRound();
      }
      else
      {
        this.enemyCount += 10;
        this.enemyKilled = 0;
        round += 1;
        
        this.c.createEnemy(this.enemyCount);
        
        resetClock();
        updateRound();
      }
    }
  }
  
  private void updateRound()
  {
    Roundlbl.setText("Round: " + round);
  }
  
  private void resetClock()
  {
    min = 2;
    this.sec = 59;
    seconds = 59 - this.sec;
    Clock.setText(min + "min : " + seconds + "sec");
  }
  
  private void tickClock()
  {
    this.sec += 1;
    seconds = 59 - this.sec;
    if (seconds == -1)
    {
      min -= 1;
      this.sec = 0;
      seconds = 59 - this.sec;
    }
    Clock.setText(min + "min : " + seconds + "sec");
    if ((min == 0) && (seconds == 0))
    {
      System.out.println("You ran out of time... You Lose....");
      game.makeStop();
    }
  }
  
  public void keyPressed(KeyEvent e)
  {
    int key = e.getKeyCode();
    if ((key == 39) || (key == 68))
    {
      this.p.setVelX(6.0D);
    }
    else if ((key == 37) || (key == 65))
    {
      this.p.setVelX(-6.0D);
    }
    else if ((key == 38) || (key == 87))
    {
      this.p.setVelY(-6.0D);
    }
    else if ((key == 40) || (key == 83))
    {
      this.p.setVelY(6.0D);
    }
    else if ((key == 90) && (!this.isShooting))
    {
      this.isShooting = true;
      if ((this.ammo > 0) && (this.toggle == 1))
      {
        this.c.addEntity(new Bullet(this.p.getX(), this.p.getY(), this.tex, this, this.c));
        bulang = -4;
        this.c.addEntity(new Bullet45(this.p.getX(), this.p.getY(), this.tex, this, this.c));
        bulang = 4;
        this.c.addEntity(new Bullet45(this.p.getX(), this.p.getY(), this.tex, this, this.c));
        this.ammo -= 1;
      }
      else
      {
        this.c.addEntity(new Bullet(this.p.getX(), this.p.getY(), this.tex, this, this.c));
      }
      if (this.buddyswitch == 1) {
        this.c.addEntity(new TinyBullets(this.p.getX() - 52.0D, this.p.getY() + 16.0D, this.tex, this, this.c));
      }
      if (this.buddyswitch1 == 1) {
        this.c.addEntity(new TinyBullets(this.p.getX() + 74.0D, this.p.getY() + 16.0D, this.tex, this, this.c));
      }
      ammoLbl.setText("Special Ammo: " + this.ammo);
    }
    else if ((key == 80) && (Pause == 0))
    {
      paused.setVisible(true);
      Pause = 1;
    }
    else if ((key == 80) && (Pause == 1))
    {
      paused.setVisible(false);
      Pause = 0;
    }
    else if ((key == 32) && (this.toggle == 0))
    {
      ammoTog.setText("Toggle: ON");
      this.toggle = 1;
    }
    else if ((key == 32) && (this.toggle == 1))
    {
      ammoTog.setText("Toggle: OFF");
      this.toggle = 0;
    }
    /*else if ((key == 77) && (this.toggle2 == 0))
    {
      music.playAudio();
      this.toggle2 = 1;
    }
    else if ((key == 77) && (this.toggle2 == 1))
    {
      music.stopAudio();
      this.toggle2 = 0;
    }*/
    else if ((key == 67) && (this.hppots > 0) && (getPlayerHP() < 100))
    {
      setPlayerHP(getPlayerHP() + 25);
      this.hppots -= 1;
      potions.setText("HP POTIONS: " + game.hppots);
    }
    else if ((key == 27) && (Pause == 0))
    {
      paused.setVisible(true);
      pauseMenu.setVisible(true);
      Pause = 1;
    }
    else if ((key == 27) && (Pause == 1))
    {
      paused.setVisible(false);
      pauseMenu.setVisible(false);
      Pause = 0;
    }
  }
  
  public void keyReleased(KeyEvent e)
  {
    int key = e.getKeyCode();
    if ((key == 39) || (key == 68)) {
      this.p.setVelX(0.0D);
    } else if ((key == 37) || (key == 65)) {
      this.p.setVelX(0.0D);
    } else if ((key == 38) || (key == 87)) {
      this.p.setVelY(0.0D);
    } else if ((key == 40) || (key == 83)) {
      this.p.setVelY(0.0D);
    } else if (key == 90) {
      this.isShooting = false;
    }
  }
  
  private void render()
  {
    BufferStrategy bs = getBufferStrategy();
    if (bs == null)
    {
      createBufferStrategy(3);
      return;
    }
    Graphics g = bs.getDrawGraphics();
    if (round == 40)
    {
      System.out.println("GAME OVER! YOU WIN!");
      stop();
    }
    else
    {
      g.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);
      if (round <= 20) {
        g.drawImage(this.background, 0, 0, null);
      } else {
        g.drawImage(this.background2, 0, 0, null);
      }
      if (this.playerHP == 100)
      {
        g.drawRect(190, 35, 300, 30);
        g.setColor(Color.RED);
        g.fillRect(190, 35, 300, 30);
      }
      else if (this.playerHP == 75)
      {
        g.drawRect(190, 35, 300, 30);
        g.setColor(Color.RED);
        g.fillRect(190, 35, 225, 30);
      }
      else if (this.playerHP == 50)
      {
        g.drawRect(190, 35, 300, 30);
        g.setColor(Color.RED);
        g.fillRect(190, 35, 150, 30);
      }
      else if (this.playerHP == 25)
      {
        g.drawRect(190, 35, 300, 30);
        g.setColor(Color.RED);
        g.fillRect(190, 35, 75, 30);
      }
      else if (this.playerHP == 0)
      {
        g.drawImage(this.hit4, 0, 0, null);
      }
    }
    if (this.c.getBoss() != null)
    {
      this.BossTrigger = 1;
      if ((this.c.getBoss().getHp() == 100) || (this.c.getBoss().getHp() == 95)) {
        g.drawImage(this.bossHP[0], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 90) || (this.c.getBoss().getHp() == 85)) {
        g.drawImage(this.bossHP[1], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 80) || (this.c.getBoss().getHp() == 75)) {
        g.drawImage(this.bossHP[2], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 70) || (this.c.getBoss().getHp() == 65)) {
        g.drawImage(this.bossHP[3], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 60) || (this.c.getBoss().getHp() == 55)) {
        g.drawImage(this.bossHP[4], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 50) || (this.c.getBoss().getHp() == 45)) {
        g.drawImage(this.bossHP[5], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 40) || (this.c.getBoss().getHp() == 35)) {
        g.drawImage(this.bossHP[6], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 30) || (this.c.getBoss().getHp() == 25)) {
        g.drawImage(this.bossHP[7], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 20) || (this.c.getBoss().getHp() == 15)) {
        g.drawImage(this.bossHP[8], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 10) || (this.c.getBoss().getHp() == 5)) {
        g.drawImage(this.bossHP[9], 0, 100, null);
      }
      if ((this.c.getBoss().getHp() == 0) || ((this.BossDead >= 1) && (this.BossDead <= 59))) {
        g.drawImage(this.bossHP[10], 0, 100, null);
      }
      if ((this.bossCounter % 100 == 0) && ((this.c.getBoss() instanceof Robot)))
      {
        this.c.addEntity(new RobotBullet(this.c.getBoss().getX(), this.c.getBoss().getY(), this.tex, this.c, this));
        this.bossCounter = 1;
      }
      else if (this.bossCounter % 100 == 0)
      {
        this.c.addEntity(new BossBullet(this.c.getBoss().getX(), this.c.getBoss().getY(), this.tex, this.c, this));
        this.bossCounter = 1;
      }
      this.bossCounter += 1;
    }
    this.p.render(g);
    this.c.render(g);
    
    g.dispose();
    bs.show();
  }
  
  public int getRound()
  {
    return round;
  }
  
  public static void main(String[] args)
  {
    game.setPreferredSize(new Dimension(WIDTH * 1, HEIGHT * 1));
    game.setMaximumSize(new Dimension(WIDTH * 1, HEIGHT * 1));
    game.setMinimumSize(new Dimension(WIDTH * 1, HEIGHT * 1));
    
    Font myFont = new Font("Arial", 1, 20);
    
    StartMenu.add(game);
    StartMenu.pack();
    StartMenu.setSize(640, 480);
    StartMenu.setDefaultCloseOperation(3);
    StartMenu.setResizable(false);
    StartMenu.setLocationRelativeTo(null);
    pauseMenu.setSize(275, 450);
    pauseMenu.setDefaultCloseOperation(1);
    pauseMenu.setResizable(false);
    pauseMenu.setLocationRelativeTo(null);
    JPanel StartPanel = new JPanel();
    JPanel MenuPanel = new JPanel();
    MenuPanel.setLayout(null);
    StartPanel.setLayout(null);
    JLabel STitle = new JLabel("WELCOME TO SPACE SHOOTOUT!! LEFT CLICK TO START!");
    JLabel STitle2 = new JLabel("Choose an option from below.");
    JLabel Controls = new JLabel("<html> CONTROLS: <BR>MOVE: UP ARROW / W, DOWN ARROW / S, LEFT ARROW / A, RIGHT ARROW / D <BR> SHOOT: Z OR LEFT MOUSE BUTTON <BR>PAUSE: P <BR>TOGGLE SPECIAL AMMO: SPACE  </html>");
    
    StBut.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Game.start = true;
        Game.StartMenu.setVisible(false);
        Game.frame2.setAlwaysOnTop(true);
      }
    });
    JButton Exit = new JButton("EXIT");
    
    Exit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Game.StartMenu.dispose();
        Game.game.makeStop();
      }
    });
    Controls.setBounds(180, 100, 200, 200);
    Controls.setForeground(Color.CYAN);
    StBut.setBounds(275, 400, 100, 50);
    Exit.setBounds(550, 425, 75, 25);
    StBut.setForeground(Color.RED);
    Exit.setForeground(Color.RED);
    Exit.setBackground(Color.BLACK);
    
    STitle.setBounds(150, 0, 400, 50);
    STitle.setForeground(Color.WHITE);
    STitle.setFont(myFont);
    
    STitle2.setBounds(180, 50, 400, 50);
    STitle2.setForeground(Color.GRAY);
    STitle2.setFont(myFont);
    
    StartPanel.add(Controls);
    StartPanel.add(STitle);
    StartPanel.add(STitle2);
    StartPanel.add(StBut);
    StartPanel.add(Exit);
    
    StartPanel.setBackground(Color.BLACK);
    
    StartMenu.add(StartPanel);
    StartMenu.setVisible(true);
    MenuPanel.setBackground(Color.BLACK);
    
    JButton Exit2 = new JButton("EXIT GAME");
    
    Exit2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Game.frame.dispose();
        Game.frame2.dispose();
        Game.pauseMenu.dispose();
        Game.music.stopAudio();
        Game.game.makeStop();
      }
    });
    JButton Resume = new JButton("RESUME GAME");
    
    Resume.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Game.pauseMenu.dispose();
        Game.Pause = 0;
        Game.paused.setVisible(false);
      }
    });
    Resume.setBounds(75, 335, 125, 25);
    Resume.setForeground(Color.WHITE);
    Resume.setBackground(Color.BLACK);
    
    pauseMenuLbl.setBounds(125, 0, 75, 25);
    pauseMenuLbl.setForeground(Color.YELLOW);
    
    Exit2.setBounds(0, 425, 100, 25);
    Exit2.setForeground(Color.RED);
    Exit2.setBackground(Color.BLACK);
    
    //playb.setBounds(10, 70, 100, 25);
    //playb.setForeground(Color.GREEN);
    
    //stopb.setBounds(160, 70, 100, 25);
    //stopb.setForeground(Color.GREEN);
    
    //comboBox.setBounds(10, 35, 250, 25);
    /*comboBox.setForeground(Color.RED);
    
    combLbl.setBounds(10, 15, 250, 25);
    combLbl.setForeground(Color.RED);
    for (int i = 0; i < songs.length; i++) {
      comboBox.addItem(songs[i]);
    }
    textfield1.setEditable(false);
    
    comboBox.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Game.music.changeSong((String)Game.comboBox.getSelectedItem());
      }
    });
    MenuPanel.add(comboBox);
    MenuPanel.add(combLbl);
    MenuPanel.add(stopb);*/
    MenuPanel.add(pauseMenuLbl);
   //MenuPanel.add(playb);
    MenuPanel.add(Resume);
    MenuPanel.add(Exit2);
    pauseMenu.add(MenuPanel);
    pauseMenu.setUndecorated(true);
    
    pauseMenu.setVisible(false);
    
    frame.add(game);
    frame.setUndecorated(true);
    frame.pack();
    frame.setDefaultCloseOperation(3);
    frame.setResizable(false);
    frame.setLocation(0, 0);
    
    frame.setVisible(false);
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
    JLabel Tit = new JLabel("EXTRA INFO!");
    JLabel TimeTit = new JLabel("TIME:");
    
    TimeTit.setBounds(80, 30, 100, 50);
    TimeTit.setForeground(Color.GREEN);
    
    Clock.setBounds(60, 50, 100, 50);
    Clock.setForeground(Color.YELLOW);
    
    label1.setBounds(80, 705, 100, 50);
    label1.setForeground(Color.RED);
    
    paused.setBounds(80, 680, 100, 50);
    paused.setForeground(Color.MAGENTA);
    paused.setVisible(false);
    
    Tit.setBounds(60, 0, 100, 50);
    Tit.setForeground(Color.RED);
    
    Roundlbl.setBounds(70, 70, 100, 50);
    Roundlbl.setForeground(Color.BLUE);
    
    fpsl.setBounds(60, 725, 150, 75);
    fpsl.setForeground(Color.PINK);
    
    ItemNot.setBounds(50, 90, 100, 50);
    ItemNot.setForeground(Color.WHITE);
    ItemNot.setVisible(false);
    
    ammoLbl.setBounds(50, 110, 150, 50);
    ammoLbl.setForeground(Color.CYAN);
    
    potions.setBounds(55, 150, 150, 50);
    potions.setForeground(Color.LIGHT_GRAY);
    
    ammoTog.setBounds(60, 130, 100, 50);
    ammoTog.setForeground(Color.ORANGE);
    
    panel.add(paused);
    panel.add(ammoTog);
    panel.add(ammoLbl);
    panel.add(potions);
    panel.add(Roundlbl);
    panel.add(fpsl);
    panel.add(label1);
    panel.add(Tit);
    panel.add(Clock);
    panel.add(TimeTit);
    panel.add(ItemNot);
    panel.setBackground(Color.BLACK);
    
    frame2.add(panel);
    frame2.setFocusable(false);
    frame2.setSize(200, HEIGHT);
    frame2.setUndecorated(true);
    frame2.getRootPane().setWindowDecorationStyle(0);
    frame2.setLocation(frame.getX() + WIDTH - 200, frame.getY());
    frame2.setVisible(false);
    
    game.start();
  }
  
  public BufferedImage getSpriteSheet()
  {
    return this.spriteSheet;
  }
  
  public BufferedImage getExtraBullets()
  {
    return this.extraBullets;
  }
  
  public BufferedImage getRobot()
  {
    return this.robot;
  }
  
  public int getEnemyCount()
  {
    return this.enemyCount;
  }
  
  public void setEnemyCount(int enemyCount)
  {
    this.enemyCount = enemyCount;
  }
  
  public int getEnemyKilled()
  {
    return this.enemyKilled;
  }
  
  public void setEnemyKilled(int enemyKilled)
  {
    this.enemyKilled = enemyKilled;
  }
  
  public int getPlayerHP()
  {
    return this.playerHP;
  }
  
  public void setPlayerHP(int playerHP)
  {
    this.playerHP = playerHP;
  }
  
  public int getScore()
  {
    return Score;
  }
  
  public void setScore(int score)
  {
    Score = score;
    updateScore(score);
  }
  
  public BufferedImage getHit4()
  {
    return this.hit4;
  }
  
  public void setHit4(BufferedImage hit4)
  {
    this.hit4 = hit4;
  }
  
  public void updateScore(int score)
  {
    label1.setText("Score: " + score);
  }
  
  public void addBuddy()
  {
    TinyShip ship1 = new TinyShip(this.p.getX(), this.p.getY(), this.tex, this.c, this, this.p);
    this.c.addEntity(ship1);
    this.buddyswitch = 1;
  }
  
  public void addBuddy2()
  {
    this.c.addEntity(new TinyShip2(this.p.getX(), this.p.getY(), this.tex, this.c, this, this.p));
    this.buddyswitch1 = 1;
  }
  
  public void mouseClicked(MouseEvent e) {}
  
  public void mouseEntered(MouseEvent e) {}
  
  public void mouseExited(MouseEvent e) {}
}
