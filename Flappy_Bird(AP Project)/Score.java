import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
   public Score() 
   {
       GreenfootImage newImage = new GreenfootImage(100, 50);
       setImage(newImage);
   }
   
   public void setScore(int score)
   {
       GreenfootImage newImage = getImage();
       newImage.clear();
       
       Font f = new Font("Comic Sans MS", Font.BOLD, 35);
       newImage.setFont(f);
       
       Color t = new Color(0, 255, 0, 127);
       
       newImage.setColor(t);
       newImage.fill();
       newImage.setColor(Color.black);
       newImage.drawString("" + score, 40, 40);
       setImage(newImage);
   }
}
