package MojOgrodek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.util.*;  
import javax.imageio.*;
import java.io.*;

public class Garden extends JPanel implements Runnable
{
	public int progress;
	public boolean czynny=true, active=false;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM HH:mm:ss");
	JLabel imie, pupil, data, hajs;
	int cash=156456;
	public Color dirt = new Color(110, 68, 14);
	
	public Garden()
	{
		int width=1080;
		int height = 720;
		this.setSize(width, height);
		setLayout(null);
		setOpaque(false);
        
        imie = new JLabel("Kajtek");
		imie.setFont(new Font("monospaced", Font.BOLD, 23));
		add(imie);
		imie.setBounds(30,95,90,130);
		
		pupil = new JLabel("Pupilek");
		pupil.setFont(new Font("monospaced", Font.BOLD, 23));
		add(pupil);
		pupil.setBounds(30,217,104,247);
		
		data = new JLabel(formatter.format(new Date()));
		data.setFont(new Font("monospaced", Font.BOLD, 20));
		add(data);
		data.setBounds(15,455,200,474);
		
		hajs = new JLabel("$"+cash);
		hajs.setFont(new Font("monospaced", Font.BOLD, 25));
		add(hajs);
		hajs.setBounds(30,417,200,440);
		
		repaint();
		
		Action activate = new AbstractAction()
		{
	        @Override
	        public void actionPerformed(ActionEvent e)
	        {
	        	if(active)
	        	{
	        		PlantsMenu plantsMenu = new PlantsMenu();
	        		plantsMenu.setVisible(true);
	        	}
	        }
		};
		bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "activate", KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), activate);
	}
	
	protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action)
	{
        InputMap im = getInputMap(condition);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

	public void paintComponent(Graphics g)
    {
		g.setColor(Color.black);
    	g.fillRect(504, 259, 108, 187);
    	g.setColor(dirt);
    	g.fillRect(511, 266, 94, 173);
    }

	@Override
	public void run()
	{
		while(czynny)
		{
			Date date = new Date();
			data.setText(formatter.format(date));
			hajs.setText("$"+cash);
		}
	}
}
