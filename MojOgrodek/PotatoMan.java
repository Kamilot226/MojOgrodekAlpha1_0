package MojOgrodek;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class PotatoMan extends JPanel implements Runnable
{
	public int glod, energia, szczescie, timeCounter=0;
	public boolean czynny = true, atGarden = false, atFridge=false;
	public int xPos, yPos;
	public int xVel, yVel;
	public int screenWidth, screenHeight;
	public int potatoWidth, potatoHeight;
	public BufferedImage kajtek1, kajtek2, kajtek3, kajtek4, kajtekSleep, image;
	public int move;
	public Color stat1 = new Color(0,255,0),
			stat2 = new Color(255, 255, 0),
			stat3 = new Color(255, 128,0),
			stat4 = new Color(255,0,0);
	
	public PotatoMan()
	{
		screenWidth=1080;
		screenHeight = 720;
		this.setSize(screenWidth, screenHeight);
		glod = 4;
		energia = 4;
		szczescie = 4;
		potatoWidth = 65;
		potatoHeight = 90;
		xPos=200;
		yPos=200;
		xVel=4;
		yVel=4;
		move=0;
		setOpaque(false);
		
		getPotatoImage();
		image = kajtek1;
		
		Action leftAction = new AbstractAction()
		{
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	move=1;
                xPos-=xVel;
                if (xPos < potatoWidth/2)
                {
                	xPos = potatoWidth/2;
                }
                if ((xPos - potatoWidth/2 < 658 && ((yPos > 79 && yPos < 446) || (yPos > 540)) && (yPos < 109 || yPos > 229)) && xPos - potatoWidth/2 > 648)
                {
                    xPos = 658 + potatoWidth/2;
                }
                if (xPos - potatoWidth/2 < 1015 && yPos > 79 && yPos < 446 && xPos - potatoWidth/2 > 1005)
                {
                    xPos = 1015 + potatoWidth/2;
                }
                if(xPos - potatoWidth/2 < 158 && (yPos < 367 || yPos > 605))
                {
                	xPos = 158 + potatoWidth/2;
                }
                if(xPos - potatoWidth/2 < 223 && yPos > 662)
                {
                	xPos = 223 + potatoWidth/2;
                }
                repaint();
            }
        };
        Action rightAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	move=1;
                xPos+=xVel;
                if (xPos + potatoWidth/2 > getWidth())
                {
                    xPos = getWidth() - potatoWidth/2;
                }
                if ((xPos + potatoWidth/2 > 648 && ((yPos > 79 && yPos < 446) || (yPos > 540)) && (yPos < 109 || yPos > 229)) && xPos + potatoWidth/2 < 658)
                {
                    xPos = 648 - potatoWidth/2;
                }
                if (xPos + potatoWidth/2 > 1005 && yPos > 79 && yPos < 446 && xPos + potatoWidth/2 < 1015)
                {
                    xPos = 1005 - potatoWidth/2;
                }
                repaint();
            }
        };
        Action upAction = new AbstractAction()
		{
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	move=1;
                yPos-=yVel;
                if (yPos < potatoHeight/8)
                {
                    yPos = (int)potatoHeight/8;
                }
                if(yPos < 447 && xPos + potatoWidth/2 > 648 && xPos - potatoWidth/2 < 1015 && yPos > 436)
                {
                	yPos = 447;
                }
                if(yPos < 367 && xPos - potatoWidth/2 < 158)
                {
                	yPos = 368;
                }
                repaint();
            }
        };
        Action downAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	move=1;
                yPos+=yVel;
                if (yPos + potatoHeight > getHeight()+potatoHeight)
                {
                    yPos = getHeight();
                }
                if(yPos > 79 && xPos + potatoWidth/2 > 648 && xPos - potatoWidth/2 < 1015 && yPos < 89)
                {
                	yPos = 79;
                }
                if(yPos > 436 && xPos + potatoWidth/2 > 648 && xPos - potatoWidth/2 < 1015 && yPos < 446)
                {
                	yPos = 436;
                }
                if(yPos > 540 && xPos + potatoWidth/2 > 648)
                {
                	yPos = 540;
                }
                if(yPos > 605 && xPos - potatoWidth/2 < 158)
                {
                	yPos = 605;
                }
                if(yPos > 662 && xPos - potatoWidth/2 < 223)
                {
                	yPos = 662;
                }
                repaint();
            }
        };
        
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), leftAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, 0), leftAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), leftAction);

        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), rightAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, 0), rightAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), rightAction);
        
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), upAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, 0), upAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), upAction);

        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), downAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, 0), downAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), downAction);
	}
	
	public void getPotatoImage()
	{
		try {
			kajtek1 = ImageIO.read(getClass().getResourceAsStream("/Grafika/kajtek1.png"));
			kajtek2 = ImageIO.read(getClass().getResourceAsStream("/Grafika/kajtek2.png"));
			kajtek3 = ImageIO.read(getClass().getResourceAsStream("/Grafika/kajtek3.png"));
			kajtek4 = ImageIO.read(getClass().getResourceAsStream("/Grafika/kajtek4.png"));
			kajtekSleep = ImageIO.read(getClass().getResourceAsStream("/Grafika/kajtekSleep.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action)
	{
        InputMap im = getInputMap(condition);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

	@Override
	public void run()
	{
		while(czynny)
		{
			switch(move)
			{
				case 0:
					image=kajtek1;
					potatoWidth = 65;
					potatoHeight = 90;
					break;
				case 1:
					image=kajtek4;
					atGarden=false;
					potatoWidth = 75;
					potatoHeight = 80;
					move=0;
					break;
			}
			
			if(xPos + potatoWidth/2 > 905 && xPos - potatoWidth/2 < 985 && yPos > 100 && yPos < 220)
			{
				image=kajtekSleep;
				if(energia<4 && timeCounter%10 == 0)energia++;
			}
			
			if(xPos + potatoWidth/2 > 504 && xPos - potatoWidth/2 < 612 && yPos > 259 && yPos < 446)
			{
				atGarden=true;
			}
			
			if(xPos + potatoWidth/2 > 660 && xPos - potatoWidth/2 < 800 && yPos > 360 && yPos < 440)
			{
				atFridge=true;
			}
			
			if(timeCounter > 1000000000)timeCounter = 0;//zabezpieczenie
			timeCounter++;
			if(timeCounter%100 == 0)
			{
				if(glod > 0)glod--;
			}
			if(timeCounter%75 == 0)
			{
				if(energia > 0)energia--;
			}
			if(timeCounter%50 == 0)
			{
				if(szczescie > 0)szczescie--;
			}
			
			try
			{
				Thread.sleep(75);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			repaint();
		}
	}
	
	public int xPosition()
	{
		return xPos;
	}
	
	public int yPosition()
	{
		return yPos;
	}
	
	public void paintComponent(Graphics g)
    {       
		Graphics2D g2d = (Graphics2D) g;
    	g2d.drawImage(image, xPos-(potatoWidth/2), yPos-potatoHeight, potatoWidth, potatoHeight, (ImageObserver) this);
    		if(glod == 4)
    		{
    			g.setColor(stat1);
    			g.fillRect(698, 610, 167, 19);
    		}
    		else if(glod == 3)
    		{
    			g.setColor(stat2);
    			g.fillRect(698, 610, 125, 19);
    		}
    		else if(glod == 2)
    		{
    			g.setColor(stat3);
    			g.fillRect(698, 610, 83, 19);
    		}
    		else if(glod == 1)
    		{
    			g.setColor(stat4);
    			g.fillRect(698, 610, 40, 19);
    		}
    		else if(glod == 0)
    		{
    			g.setColor(stat4);
    			g.fillRect(698, 610, 5, 19);
    		}
    		
    		if(energia == 4)
    		{
    			g.setColor(stat1);
    			g.fillRect(698, 682, 167, 19);
    		}
    		else if(energia == 3)
    		{
    			g.setColor(stat2);
    			g.fillRect(698, 682, 125, 19);
    		}
    		else if(energia == 2)
    		{
    			g.setColor(stat3);
    			g.fillRect(698, 682, 83, 19);
    		}
    		else if(energia == 1)
    		{
    			g.setColor(stat4);
    			g.fillRect(698, 682, 40, 19);
    		}
    		else if(energia == 0)
    		{
    			g.setColor(stat4);
    			g.fillRect(698, 682, 5, 19);
    		}
    		
    		if(szczescie == 4)
    		{
    			g.setColor(stat1);
    			g.fillRect(886, 646, 173, 19);
    		}
    		else if(szczescie == 3)
    		{
    			g.setColor(stat2);
    			g.fillRect(886, 646, 130, 19);
    		}
    		else if(szczescie == 2)
    		{
    			g.setColor(stat3);
    			g.fillRect(886, 646, 87, 19);
    		}
    		else if(szczescie == 1)
    		{
    			g.setColor(stat4);
    			g.fillRect(886, 646, 43, 19);
    		}
    		else if(szczescie == 0)
    		{
    			g.setColor(stat4);
    			g.fillRect(886, 646, 6, 19);
    		}
    }
}
