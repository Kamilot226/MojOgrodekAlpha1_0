package MojOgrodek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class inGameMenuFrame extends JFrame {

    public inGameMenuFrame()
    {
        int width = 400;
        int height = 500;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        //this.setBackground(new Color(0,0,0,0));
        this.setResizable(false);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel1 =  new GradientPanel();
        add(BorderLayout.CENTER, panel1);

        JLabel label1 = new JLabel("MENU");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("monospaced", Font.BOLD, 40));
        label1.setBounds(145, 10, 150, 100);

        JButton button1 = new RoundRectButton("WZNÓW");
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("monospaced", Font.BOLD, 18));
        button1.setBounds(95,100,200,50);

        JButton button2 = new RoundRectButton("MUZYKA");
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("monospaced", Font.BOLD, 18));
        button2.setBounds(95,160,200,50);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MusicFrame musicFrame = new MusicFrame();
                musicFrame.showMusicFrame();
            }

        });

        JButton button3 = new RoundRectButton("ZAPISZ I WYJDŹ");
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("monospaced", Font.BOLD, 18));
        button3.setBounds(95,280,200,50);

        JButton button4 = new RoundRectButton("MENU GŁÓWNE");
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("monospaced", Font.BOLD, 18));
        button4.setBounds(95,220,200,50);

        JButton button5 = new RoundRectButton("WYJDŹ Z GRY");
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("monospaced", Font.BOLD, 18));
        button5.setBounds(95,340,200,50);

        panel1.setLayout(null);

        panel1.setVisible(true);
        panel1.add(label1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);


    }

    public static void main(String[] args) {
        inGameMenuFrame frame = new inGameMenuFrame();
        frame.setVisible(true);
    }
}
