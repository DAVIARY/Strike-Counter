import greenfoot.*;
public class Zombie2 extends Animal
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int life;
    private int Size;
    private int switchCounter;
    Player player = new Player();
   public Zombie2()
   {
      GreenfootImage image = getImage();
      image1 = new GreenfootImage("ant2.png");
      image2 = new GreenfootImage("ant3.png");
      life = 10;
      Size = 0;
   }
   public void act() 
   {
       move(2);
       turnAtEdge();
       randomTurn();
       Chase();
       Touched();
       imageCounter();
   }
   public void randomTurn()
   {
       if ( Greenfoot.getRandomNumber(100) < 96)
       {
             turn(Greenfoot.getRandomNumber(30) -15);
       }
   }   
   public void turnAtEdge()
   {
      if (isAtEdge() )
      {
          turn(17);
      } 
   }
   public void Chase()
   {
       turnTowards(Player2.PlayerX, Player2.PlayerY);
   }
   public void Touched()
   {   
        Actor touched = getOneIntersectingObject(Bullet.class);
        if (touched != null)
        {
            life--;
        }
        if (player.Charge == 1)
        {
            if (touched != null)
            {
                life--;
                life--;
            }
        }
        if (life == 0)
        {
           World myWorld = getWorld();
           Floor floor = (Floor)myWorld;
           Counter counter = floor.getCounter();
           counter.addcounter();
           getWorld().removeObject(this);
        }
   }
   public void imageCounter()
   {
       if (switchCounter == 0)
       {
           setImage(image1);
       }
       if (switchCounter == 5)
       {
           setImage(image2);
           switchCounter = -5;
       }
       switchCounter = switchCounter + 1;
   }
}