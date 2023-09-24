import greenfoot.*;

public class Zombie3 extends Animal
{
    private GreenfootImage image1;
    private int life;
    private int Size;
    private int switchCounter;
    Player player = new Player();
   public Zombie3()
   {
      GreenfootImage image = getImage();
      life = 30;
      Size = 2;
   }
   public void act() 
   {
       randomTurn();
       move(4);
       turnAtEdge();
       randomTurn();
       Chase();
       Touched();
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
       turnTowards(Player.PlayerX, Player.PlayerY);
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
}
