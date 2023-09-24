import greenfoot.*;

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends World
{
    Counter counter = new Counter();
    P1Counter p1counter = new P1Counter();
    Level level = new Level();
    public Floor()
    {    
        // Create a new world with 1000X800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        addObject(new Player(), (450), (400));
        randomZombie(5);
        addObject(new Sonic(), (500), (600));
        addObject(new HardBullets(), (267), (432));
        randomHealth(4);
    }
    public void act()
    {
        respawn();
        lose();
    }
    public void lose()
    {
        if(p1counter.P1HP == 0)
        {
            Greenfoot.stop();
        }
    }
    public void respawn()
    {
        if (counter.Score == 5)
        {
          randomZombie(3);
          randomHealth(3);
          randomFly(2);
          addObject(new Sonic(), (500), (600));
          counter.Score = 0;
          level.addcounter();
        }
    }
    public Counter getCounter()
    {
        return counter;
    }
    public P1Counter getP1Counter()
    {
        return p1counter;
    }
    public Level getLevel()
    {
        return level;
    }
    public void randomHealth(int howMany)
    {
        addObject(counter, 50, 40);
        addObject(p1counter, 150, 40);
        addObject(level, 250, 40);
        for (int i=0; i<howMany; i++) 
        {
            Health health = new Health();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(health, x, y);
        }
    }
    public void randomZombie(int howMany)
    {
        for (int i=0; i<howMany; i++) 
        {
            Zombie zombie = new Zombie();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(zombie, x, y);
        }
    }
    public void randomFly(int howMany)
    {
        for (int i=0; i<howMany; i++) 
        {
            Zombie3 fly = new Zombie3();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(fly, x, y);
        }
    }
}