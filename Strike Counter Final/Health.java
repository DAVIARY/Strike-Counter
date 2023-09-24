import greenfoot.*;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
   public Health()
   {
       GreenfootImage image = getImage();
       image.scale(image.getWidth() - 10, image.getHeight() - 10);
       setImage(image);
   }   
}
