package com.game.src.main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AudioPlayer02
  extends JFrame
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
AudioFormat audioFormat;
  AudioInputStream audioInputStream;
  SourceDataLine sourceDataLine;
  boolean stopPlayback = false;
  final JButton stopBtn = new JButton("Stop");
  final JButton playBtn = new JButton("Play");
  final JTextField textField = new JTextField("res/01-main-theme-overworld.wav");
  
  public static void main(String[] args)
  {
    new AudioPlayer02();
  }
  
  public void changeSong(String song)
  {
    this.textField.setText(song);
  }
  
  public AudioPlayer02()
  {
    this.stopBtn.setEnabled(false);
    this.playBtn.setEnabled(true);
    
    this.playBtn.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          AudioPlayer02.this.stopBtn.setEnabled(true);
          AudioPlayer02.this.playBtn.setEnabled(false);
          AudioPlayer02.this.playAudio();
        }
      });
    this.stopBtn.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          AudioPlayer02.this.stopPlayback = true;
        }
      });
    getContentPane().add(this.playBtn, "West");
    getContentPane().add(this.stopBtn, "East");
    getContentPane().add(this.textField, "North");
    
    setTitle("");
    setUndecorated(true);
    setDefaultCloseOperation(3);
    setSize(250, 70);
    setVisible(false);
  }
  
  public void stopAudio()
  {
    this.stopPlayback = true;
    System.exit(0);
  }
  
  public void playAudio()
  {
    try
    {
      File soundFile = 
        new File(this.textField.getText());
      this.audioInputStream = 
        AudioSystem.getAudioInputStream(soundFile);
      this.audioFormat = this.audioInputStream.getFormat();
      System.out.println(this.audioFormat);
      
      DataLine.Info dataLineInfo = 
        new DataLine.Info(
        SourceDataLine.class, 
        this.audioFormat);
      
      this.sourceDataLine = 
        ((SourceDataLine)AudioSystem.getLine(
        dataLineInfo));
      
      new PlayThread().start();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.exit(0);
    }
  }
  
  class PlayThread
    extends Thread
  {
    byte[] tempBuffer = new byte['?'];
    
    PlayThread() {}
    
    public void run()
    {
      try
      {
        AudioPlayer02.this.sourceDataLine.open(AudioPlayer02.this.audioFormat);
        AudioPlayer02.this.sourceDataLine.start();
        int cnt;
        while (((cnt = AudioPlayer02.this.audioInputStream.read(
          this.tempBuffer, 0, this.tempBuffer.length)) != -1) && 
          (!AudioPlayer02.this.stopPlayback))
        {
          int cnt1 = 1;
          if (cnt1 > 0) {
            AudioPlayer02.this.sourceDataLine.write(
              this.tempBuffer, 0, cnt1);
          }
        }
        AudioPlayer02.this.sourceDataLine.drain();
        AudioPlayer02.this.sourceDataLine.close();
        
        AudioPlayer02.this.stopBtn.setEnabled(false);
        AudioPlayer02.this.playBtn.setEnabled(true);
        AudioPlayer02.this.stopPlayback = false;
      }
      catch (Exception e)
      {
        e.printStackTrace();
        System.exit(0);
      }
    }
  }
}
