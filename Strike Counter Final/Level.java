import greenfoot.*;

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Level extends Actor
{
    private int Level = 1;
    Counter counter = new Counter();
    public void act() 
    {
        setImage(new GreenfootImage("Level : " + Level, 24, Color.GREEN, Color.BLACK));
    }
    public Level()
    {
        int Level = 1;
    }
    public void addcounter()
    {
         Level = Level + 1;
    }
}
