package MojOgrodek;

import javax.swing.*;
import java.util.concurrent.*;

public class Main extends JFrame implements Runnable
{
	City miasto;
	PotatoMan kajtek;
	Pupil pupil;
	Garden ogrodek;
	House dom;
	boolean czynny=true, bowlActive=false;
	int timeCounter=0;
	
	public Main(int cityType)
	{
		int width=1100;
		int height = 763;
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layers = new JLayeredPane();
		add(layers);
		
		miasto = new City(cityType);
		layers.add(miasto);
		layers.setLayer(miasto, JLayeredPane.DEFAULT_LAYER);
		
		pupil = new Pupil();
		layers.add(pupil);
		layers.setLayer(pupil, JLayeredPane.DRAG_LAYER);
		
		kajtek = new PotatoMan();
		layers.add(kajtek);
		layers.setLayer(kajtek, JLayeredPane.DRAG_LAYER);
		
		ogrodek = new Garden();
		layers.add(ogrodek);
		layers.setLayer(ogrodek, JLayeredPane.DRAG_LAYER);
		
		dom = new House();
		layers.add(dom);
		layers.setLayer(dom, JLayeredPane.PALETTE_LAYER);
		
		
		
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				ExecutorService exec = Executors.newFixedThreadPool(4);
				
				exec.execute(kajtek);
				
				exec.execute(pupil);
				
				exec.execute(ogrodek);

				exec.shutdown();
			}
		});
	}

	@Override
	public void run()
	{
		while(czynny)
		{
			if(kajtek.atGarden)ogrodek.active=true;
			else ogrodek.active=false;
			
			/*if(kajtek.atFridge)fridge.active=true;
			else fridge.active=false;*/
			
			if(pupil.pupilTrzymaPilke)
			{
				pupil.xNew = kajtek.xPosition();
				pupil.yNew = kajtek.yPosition();
			}

			if(pupil.xPos-30 <= kajtek.xPos && pupil.xPos+30 >= kajtek.xPos && pupil.yPos-30 <= kajtek.yPos && pupil.yPos+30 >= kajtek.yPos)
			{
				if(kajtek.szczescie < 4 && timeCounter%5 == 0) kajtek.szczescie++;
			}
			
			if(timeCounter > 1000000000)timeCounter = 0;//zabezpieczenie
			timeCounter++;

			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String arg[])
	{       
		Main frame = new Main(1);
	        
		frame.setVisible(true);
	}
}
