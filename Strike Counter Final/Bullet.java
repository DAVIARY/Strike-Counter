import greenfoot.*;

public class Bullet extends Animal
{
    public void act()
   {
       Hit();
       move(10);
   }
   public void Hit()
   {
       Actor hit = getOneIntersectingObject(Zombie.class);
       Actor hit2 = getOneIntersectingObject(Zombie2.class);
       Actor hit3 = getOneIntersectingObject(Zombie3.class);
       if (getX() >= getWorld().getWidth() -1)
         getWorld().removeObject(this);
       else if (getX() <= 1)
        getWorld().removeObject(this);
       else if (getY() >= getWorld().getHeight() -1)
        getWorld().removeObject(this);
       else if (getY() <= 1)
        getWorld().removeObject(this);
       
       if (hit != null)
       {
           getWorld().removeObject(this);
       }
   }
}
