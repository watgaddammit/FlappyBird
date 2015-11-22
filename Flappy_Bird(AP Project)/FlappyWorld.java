import greenfoot.*;

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author Brandon Rodriguez 
 * @version v1.0
 */
public class FlappyWorld extends World
{
    int pipeCounter = 0;
    int PIPE_SPACING = 120;
    int score = 0;
    int FIRST_POINT = 240;
    int flappyCounter = 0;
    Score scoreObject = null;
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        //Set paint order.
        setPaintOrder(GameOver.class, Score.class, FlappyBird.class, Pipe.class, TopPipe.class);
        
        //Create a flappy bird object
        FlappyBird flappy = new FlappyBird();
        
        //Add flappy to world
        addObject(flappy, 100, getHeight()/2);
        
        //Create a score object
        scoreObject = new Score();
        scoreObject.setScore(0);
        
        //Add the score object to world
        addObject(scoreObject, 550, 20);
    }

    public void act()
    {
        pipeCounter++;
        if (pipeCounter % 100 == 0)
        {
            //Create a pipe object
            createPipes();
        }
        
        if(pipeCounter >= FIRST_POINT)
        {
            if(flappyCounter % 100 == 0)
            {
                score++;
                scoreObject.setScore(score);
            }
            flappyCounter++;
        }
    }
    
    public void createPipes()
    {
        Pipe bottomPipe = new Pipe();
        TopPipe topPipe = new TopPipe();
        GreenfootImage imageTwo = topPipe.getImage();
        GreenfootImage image = bottomPipe.getImage();
        addObject(topPipe, getWidth(), getHeight());
        addObject(bottomPipe, getWidth(), getHeight()/2 + image.getHeight()/2 + Greenfoot.getRandomNumber(image.getHeight()/2));
        topPipe.setLocation( bottomPipe.getX(), bottomPipe.getY() - bottomPipe.getImage().getHeight() - PIPE_SPACING );
    }
}

