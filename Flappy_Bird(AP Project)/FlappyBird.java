import greenfoot.*;

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    double dy = 0;
    double g = 1.0; 
    double BOOST_SPEED = -10;
    
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         //If flappy bird touches a pipe, then it's game over. 
        if(getOneIntersectingObject(TopPipe.class) != null || getOneIntersectingObject(Pipe.class) != null)
        {
            displayGameOver();
        }
        
        setLocation( getX(), (int)(getY() + dy) );
        
        //If user presses the UP arrow key, then Flappy Bird is launched upward.
        if (Greenfoot.isKeyDown("up") == true)
        {
            dy = BOOST_SPEED;
        }
        
        if(dy > -10 && dy < 10)
        {
            setRotation(-40);
        }
        else if(dy > -15 && dy < 15)
        {
            setRotation(0);
        }
        else if(dy > -20 && dy < 20)
        {
            setRotation(40);
        }
        else if(dy > -23 && dy < 23)
        {
            setRotation(89);
        }
        //If FlappyBird falls to the ground, then Game Over.
        if (getY() > getWorld().getHeight())
        {
            displayGameOver();
        }
        dy = dy + g;        
    }   
   
    private void displayGameOver()
    {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);            
        Greenfoot.stop();    
    }
}
