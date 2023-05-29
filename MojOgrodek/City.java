package MojOgrodek;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class City extends JPanel
{
	public BufferedImage miasto1, miasto2, miasto3, kajtek, pupil, sklep, image;
	
	public City(int rodzaj)
	{
		int width=1080;
		int height = 720;
		this.setSize(width, height);
		setBackground(new Color(0,255,0));
		
		try{
			miasto1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Grafika/miasto1.png")));
			miasto2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Grafika/miasto2.png")));
			miasto3 = ImageIO.read(getClass().getResourceAsStream("/Grafika/miasto3.png"));
			kajtek = ImageIO.read(getClass().getResourceAsStream("/Grafika/kajtek1.png"));
			pupil = ImageIO.read(getClass().getResourceAsStream("/Grafika/pupil.png"));
			sklep = ImageIO.read(getClass().getResourceAsStream("/Grafika/budowa.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(rodzaj==1)image=miasto1;
		if(rodzaj==2)image=miasto2;
		if(rodzaj==3)image=miasto3;
		
		repaint();
	}
	
	public void paintComponent(Graphics g)
    {       
    	  Graphics2D g2d = (Graphics2D) g;
    	  g2d.drawImage(image, 0, 0, 1080, 720, (ImageObserver) this);
    	  g2d.drawImage(kajtek, 45, 30, 65, 90, (ImageObserver) this);
    	  g2d.drawImage(pupil, 40, 220, 75, 75, (ImageObserver) this);
    	  g2d.drawImage(sklep, 502, 30, 76, 76, (ImageObserver) this);
    }
}
