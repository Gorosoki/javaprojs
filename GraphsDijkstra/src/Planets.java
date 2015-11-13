/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gavin Goroski & Aaron Mead
 */
public class Planets
{
    private int x;
    private int y;
 

Planets(int x, int y)
{
    
    this.x = x;
    this.y = y;

}
//public void setStuff(boolean hast)
//{
//    has = hast;
//}
//public boolean hasStuff()
//{
//    return has;
//}

public int getX(){
    return x;
}

public int getY(){
    return y;
}

public void setX(int content)
{
    x = content;
}
public void setY(int contentY)
{
    y = contentY;
}
        
}