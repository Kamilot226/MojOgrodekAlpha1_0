package MojOgrodek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class ChooseCity extends JFrame {

    ChooseCity()
    {
        int width = 600;
        int height = 400;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        //this.setBackground(new Color(0,0,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel1 =  new GradientPanel();
        add(BorderLayout.CENTER, panel1);

        JLabel label1 = new JLabel("WYBIERZ MIASTO", SwingConstants.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("monospaced", Font.BOLD, 40));
        label1.setBounds(0, 20, 600, 100);

        JButton button1 = new RoundRectButton("ZIEMNIAKOWO");
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("monospaced", Font.BOLD, 18));
        button1.setBounds(10,120,180,80);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main city1 = new Main(1);
                city1.setVisible(true);
                setVisible(false);
                SwingUtilities.invokeLater(new Runnable()
                {
        			@Override
        			public void run()
        			{
        				ExecutorService exec = Executors.newFixedThreadPool(4);
        				exec.execute(city1);
        				exec.shutdown();
        			}
        		});
            }
        });

        JButton button2 = new RoundRectButton("PYRKOWO");
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("monospaced", Font.BOLD, 18));
        button2.setBounds(200,120,180,80);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main city2 = new Main(2);
                city2.setVisible(true);
                setVisible(false);
                SwingUtilities.invokeLater(new Runnable()
                {
        			@Override
        			public void run()
        			{
        				ExecutorService exec = Executors.newFixedThreadPool(4);
        				exec.execute(city2);
        				exec.shutdown();
        			}
        		});
            }
        });

        JButton button3 = new RoundRectButton("KARTOFLOWO");
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("monospaced", Font.BOLD, 18));
        button3.setBounds(390,120,180,80);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main city3 = new Main(3);
                city3.setVisible(true);
                setVisible(false);
                SwingUtilities.invokeLater(new Runnable()
                {
        			@Override
        			public void run()
        			{
        				ExecutorService exec = Executors.newFixedThreadPool(4);
        				exec.execute(city3);
        				exec.shutdown();
        			}
        		});
            }
        });

        JButton button4 = new RoundRectButton("POWRÓT");
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("monospaced", Font.BOLD, 18));
        button4.setBounds(210,260,180,50);

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseCity.this.dispose();
                openingFrame openFrame = new openingFrame();
                openFrame.setVisible(true);
                setVisible(false);
            }
        });

        panel1.setLayout(null);

        panel1.setVisible(true);
        panel1.add(label1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

    }

    public static void main(String[] args) {
        ChooseCity frame = new ChooseCity();
        frame.setVisible(true);
    }
}
