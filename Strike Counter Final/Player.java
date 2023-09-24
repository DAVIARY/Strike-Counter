import greenfoot.*;

public class Player extends Animal
{
   private int HP;
   private GreenfootImage image1;
   private GreenfootImage image2;
   private GreenfootImage image3;
   private GreenfootImage image4;
   private int speed;
   private int counter; 
   private int counter2;
   private int firerate;
   private int delay;
   public int Charge;
   public static int PlayerX, PlayerY;
   public Player()
   {
       HP = 5;
       setRotation(90);
       image1 = new GreenfootImage("down.png");
       image2 = new GreenfootImage("right.png");
       image3 = new GreenfootImage("up.png");
       image4 = new GreenfootImage("left.png");
       speed = 5;
       counter = 0;
       firerate = 5;
       delay = 0;
       Charge = 0;
    }
   public void act() 
   {
      checkKeys();
      lookForHealth();
      PlayerX = getX();
      PlayerY = getY();
      takeDamage();
      Powerups();
      spawnP2();
      delay = delay + 1;
   }    
   public void checkKeys() 
   {
       if (Greenfoot.isKeyDown("up"))
       {
           setRotation(270);
           move(speed);
           setImage(image3);
       }
       if(Greenfoot.isKeyDown("left")) 
       {
           setRotation(180);
           move(speed);
           setImage(image4);
       }        
       if(Greenfoot.isKeyDown("right")) 
       {
           setRotation(0);
           move(speed);
           setImage(image2);
       } 
       if(Greenfoot.isKeyDown("down")) 
       {
           setRotation(90);
           move(speed);
           setImage(image1);
       } 
       if(Greenfoot.isKeyDown("space"))
       {
           fire();
       } 
    }
   public void lookForHealth()
   {
        if ( canSee(Health.class) )
        {
           eat(Health.class);
           HP = HP + 1;
           World myWorld = getWorld();
           Floor floor = (Floor)myWorld;
           P1Counter p1counter = floor.getP1Counter();
           p1counter.addcounter();
        }
   }
   public void spawnP2()
   {
       if (Greenfoot.mouseClicked(this))
       {
          getWorld().addObject(new Player2(), 550, 400);
          getWorld().addObject(new Zombie2(), (Greenfoot.getRandomNumber(1000)), (Greenfoot.getRandomNumber(800)));
          getWorld().addObject(new Zombie2(), (Greenfoot.getRandomNumber(1000)), (Greenfoot.getRandomNumber(800)));
          getWorld().addObject(new Zombie2(), (Greenfoot.getRandomNumber(1000)), (Greenfoot.getRandomNumber(800)));
          getWorld().addObject(new Zombie2(), (Greenfoot.getRandomNumber(1000)), (Greenfoot.getRandomNumber(800)));
          getWorld().addObject(new Zombie2(), (Greenfoot.getRandomNumber(1000)), (Greenfoot.getRandomNumber(800)));
        }
   }
   public void takeDamage()
   {
        if (isTouching(Zombie.class) )
        {
           move(-150);
           World myWorld = getWorld();
           Floor floor = (Floor)myWorld;
           P1Counter p1counter = floor.getP1Counter();
           p1counter.minuscounter();
           HP = HP - 1;
        }
        if (isTouching(Zombie2.class) )
        {
           move(-150);
           World myWorld = getWorld();
           Floor floor = (Floor)myWorld;
           P1Counter p1counter = floor.getP1Counter();
           p1counter.minuscounter();
           HP = HP - 1;
        }
        if (isTouching(Zombie3.class) )
        {
           move(-150);
           World myWorld = getWorld();
           Floor floor = (Floor)myWorld;
           P1Counter p1counter = floor.getP1Counter();
           p1counter.minuscounter();
           HP = HP - 1;
        }
   }
   public void Powerups()
   {
       if(isTouching(Sonic.class))
       {
           getWorld().removeObjects(getWorld().getObjects(Sonic.class));
           speed = speed + 5;
       }    
       if(speed == 10)
       {
           counter = counter + 1;
       }
       if(counter == 320)
       {
           speed = 5;
           counter = 0;
       }
       if(isTouching(HardBullets.class))
       {
           getWorld().removeObjects(getWorld().getObjects(HardBullets.class));
           Charge = Charge + 1;
       }
       if (Charge == 1)
       {
           counter2 = counter2 + 1;
       }
       if (counter2 == 320)
       {
           counter2 = 0;
           Charge = 0;
       }
    }
   private void fire() 
    {
      if(delay >= firerate)
      {
           Bullet bullet = new Bullet();
           getWorld().addObject(bullet, getX(), getY());
           bullet.setRotation(getRotation());
           delay = 0;
      }
    }
}
