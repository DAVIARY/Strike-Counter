import greenfoot.*;

public class P1Counter extends Actor
{
     int P1HP = 5;
    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("P1 HP : " + P1HP, 24, Color.GREEN, Color.BLACK));
    }    
    public void minuscounter()
    {
        P1HP = P1HP - 1;
    }
    public void addcounter()
    {
        P1HP = P1HP + 1;
    }
}

