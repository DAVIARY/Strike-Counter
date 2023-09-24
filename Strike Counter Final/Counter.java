import greenfoot.*;

public class Counter extends Actor
{
    int Score = 0;
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + Score, 24, Color.GREEN, Color.BLACK));
    }    
    public void addcounter()
    {
        Score = Score + 1;
    }
}

