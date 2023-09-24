import greenfoot.*;


public class Vector

{
    double dx = 0;
    double dy = 0;
    int direction = 0;
    double length;
    public Vector()
    {
    }
    public Vector(int direction, double length)
    {
       this.length = length;
       this.direction = direction;
       dx = length * Math.cos(Math.toRadians(direction));
       dy = length * Math.sin(Math.toRadians(direction));    
    }
    public void setDirection(int direction) 
    {
        this.direction = direction;
        dx = length * Math.cos(Math.toRadians(direction));
        dy = length * Math.sin(Math.toRadians(direction));   
    }
    public void add(Vector other) 
    {
        dx += other.dx;
        dy += other.dy;    
        this.direction = (int) Math.toDegrees(Math.atan2(dy, dx));
        this.length = Math.sqrt(dx*dx+dy*dy);
    }
    public double getX() 
    {
        return dx;
    }
    public double getY() 
    {
        return  dy;
    }
    public int getDirection() 
    {
        return direction;
    }
    public double getLength() 
    {
        return length;
    }
    public Vector copy() 
    {
        Vector copy = new Vector();
        copy.dx = dx;
        copy.dy = dy;
        copy.direction = direction;
        copy.length = length;
        return copy;
    }    
}