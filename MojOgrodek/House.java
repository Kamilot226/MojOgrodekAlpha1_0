package MojOgrodek;

import javax.swing.*;
import java.awt.*;

public class House extends JPanel
{
	public Color houseColor, carpetColor1, carpetColor2, bedColor,
	house1 = new Color(133, 81, 181), 
	house2 = new Color(87, 64, 15), 
	house3 = new Color(110, 110, 110),
	carpet11 = new Color(235, 75, 47), 
	carpet12 = new Color(171, 55, 34), 
	carpet21 = new Color(247, 144, 0),
	carpet22 = new Color(194, 113, 0), 
	carpet31 = new Color(119, 201, 52), 
	carpet32 = new Color(55, 122, 0),
	bed1 = new Color(232, 56, 56), 
	bed2 = new Color(201, 107, 171), 
	bed3 = new Color(58, 54, 186),
	floorColor = new Color(201, 162, 113),
	doorColor = new Color (61, 34, 0),
	windowColor = new Color(149, 230, 224),
	bowlColor = new Color(145, 0, 0),
	foodColor = new Color(207, 145, 0),
	fridgeColor = new Color(150, 150, 150);
	
	boolean foodInBowl = false;
	
	public House()
	{
		int width=1080;
		int height = 720;
		this.setSize(width, height);
		setOpaque(false);
		
		houseColor=house1;
		carpetColor1=carpet11;
		carpetColor2=carpet12;
		bedColor=bed1;
		
		repaint();
	}
	
	public void paintComponent(Graphics g)
    {
		g.setColor(houseColor);
    	g.fillRect(648, 79, 367, 367);
    	//g.fillRect(648, 540, 50, 50);
    	g.setColor(doorColor);
    	g.fillRect(648, 109, 10, 120);
    	g.setColor(windowColor);
    	g.fillRect(708, 79, 120, 10);
    	g.fillRect(848, 436, 120, 10);
    	g.setColor(floorColor);
    	g.fillRect(658, 89, 347, 347);
    	g.setColor(carpetColor2);
    	g.fillRect(728, 159, 207, 207);
    	g.setColor(carpetColor1);
    	g.fillRect(743, 174, 177, 177);
    	g.setColor(Color.black);
    	g.fillRect(905, 100, 80, 120);
    	g.setColor(Color.white);
    	g.fillRect(910, 105, 70, 40);
    	g.setColor(bedColor);
    	g.fillRect(910, 150, 70, 65);
    	g.setColor(Color.black);
    	g.fillOval(745, 100, 50, 50);
    	g.setColor(bowlColor);
    	g.fillOval(750, 105, 40, 40);
    	if(foodInBowl)
    	{
    		g.setColor(foodColor);
    		g.fillOval(760, 113, 8, 8);
        	g.fillOval(765, 120, 7, 7);
        	g.fillOval(773, 131, 9, 9);
        	g.fillOval(763, 130, 8, 8);
        	g.fillOval(777, 118, 6, 6);
        	g.fillOval(755, 122, 7, 7);
    	}
    	g.setColor(Color.black);
    	g.fillRect(675, 385, 110, 50);
    	g.setColor(fridgeColor);
    	g.fillRect(680, 390, 100, 40);
    }
}
