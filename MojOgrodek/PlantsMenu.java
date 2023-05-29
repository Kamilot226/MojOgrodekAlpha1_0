package MojOgrodek;

import javax.swing.*;
import java.awt.*;

public class PlantsMenu extends JFrame {

   public PlantsMenu() {
       int width = 600;
       int height = 500;
       this.setSize(width, height);
       this.setLocationRelativeTo(null);
       //this.setBackground(new Color(0,0,0,0));
       this.setResizable(false);
       //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BorderLayout());

       JPanel panel1 = new JPanel();
       panel1.setBackground(Color.GREEN.darker().darker());
       add(BorderLayout.CENTER, panel1);

       JLabel labeltytulowy = new JLabel("SKLEPIK Z KWIATKAMI");
       labeltytulowy.setForeground(Color.WHITE);
       labeltytulowy.setFont(new Font("monospaced", Font.BOLD, 35));
       labeltytulowy.setBounds(100, 10, 400, 70);

       JButton bkwiatek1 = new JButton("");
       ImageIcon img1 = new ImageIcon("src/Grafika/kwiatek1.png");
       Image imgg = img1.getImage() ;
       Image newimg = imgg.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
       img1 = new ImageIcon( newimg );
       bkwiatek1.setIcon(img1);
       bkwiatek1.setBounds(50, 100, 80, 80);
       bkwiatek1.setBorder(null);
       bkwiatek1.setFocusPainted(true);
       bkwiatek1.setContentAreaFilled(false);

       JButton bkwiatek2 = new JButton("");
       ImageIcon img2 = new ImageIcon("src/Grafika/kwiatek2.png");
       Image imgg2 = img2.getImage() ;
       Image newimg2 = imgg2.getScaledInstance( 65, 65,  java.awt.Image.SCALE_SMOOTH ) ;
       img2 = new ImageIcon( newimg2 );
       bkwiatek2.setIcon(img2);
       bkwiatek2.setBounds(150, 100, 80, 80);
       bkwiatek2.setBorder(null);
       bkwiatek2.setFocusPainted(true);
       bkwiatek2.setContentAreaFilled(false);

       JButton bkwiatek3 = new JButton("");
       ImageIcon img3 = new ImageIcon("src/Grafika/kwiatek4.png");
       Image imgg3 = img3.getImage() ;
       Image newimg3 = imgg3.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;
       img3 = new ImageIcon( newimg3 );
       bkwiatek3.setIcon(img3);
       bkwiatek3.setBounds(250, 100, 80, 80);
       bkwiatek3.setBorder(null);
       bkwiatek3.setFocusPainted(true);
       bkwiatek3.setContentAreaFilled(false);

       JButton bkwiatek4 = new JButton("");
       ImageIcon img4 = new ImageIcon("src/Grafika/kwiatek3.png");
       Image imgg4 = img4.getImage() ;
       Image newimg4 = imgg4.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;
       img4 = new ImageIcon( newimg4 );
       bkwiatek4.setIcon(img4);
       bkwiatek4.setBounds(350, 100, 80, 80);
       bkwiatek4.setBorder(null);
       bkwiatek4.setFocusPainted(true);
       bkwiatek4.setContentAreaFilled(false);

       JButton bkwiatek5 = new JButton("");
       ImageIcon img5 = new ImageIcon("src/Grafika/kwiatek5.png");
       Image imgg5 = img5.getImage() ;
       Image newimg5 = imgg5.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;
       img5 = new ImageIcon( newimg5 );
       bkwiatek5.setIcon(img5);
       bkwiatek5.setBounds(450, 100, 80, 80);
       bkwiatek5.setBorder(null);
       bkwiatek5.setFocusPainted(true);
       bkwiatek5.setContentAreaFilled(false);

       JButton bkwiatek6 = new JButton("");
       ImageIcon img6 = new ImageIcon("src/Grafika/kwiatek6.png");
       Image imgg6 = img6.getImage() ;
       Image newimg6 = imgg6.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
       img6 = new ImageIcon( newimg6 );
       bkwiatek6.setIcon(img6);
       bkwiatek6.setBounds(50, 200, 80, 80);
       bkwiatek6.setBorder(null);
       bkwiatek6.setFocusPainted(true);
       bkwiatek6.setContentAreaFilled(false);

       JButton bkwiatek7 = new JButton("");
       ImageIcon img7 = new ImageIcon("src/Grafika/kwiatek7.png");
       Image imgg7 = img7.getImage() ;
       Image newimg7 = imgg7.getScaledInstance( 85, 85,  java.awt.Image.SCALE_SMOOTH ) ;
       img7 = new ImageIcon( newimg7 );
       bkwiatek7.setIcon(img7);
       bkwiatek7.setBounds(150, 200, 80, 80);
       bkwiatek7.setBorder(null);
       bkwiatek7.setFocusPainted(true);
       bkwiatek7.setContentAreaFilled(false);

       JButton bkwiatek8 = new JButton("");
       ImageIcon img8 = new ImageIcon("src/Grafika/kwiatek8.png");
       Image imgg8 = img8.getImage() ;
       Image newimg8 = imgg8.getScaledInstance( 85, 85,  java.awt.Image.SCALE_SMOOTH ) ;
       img8 = new ImageIcon( newimg8 );
       bkwiatek8.setIcon(img8);
       bkwiatek8.setBounds(250, 200, 80, 80);
       bkwiatek8.setBorder(null);
       bkwiatek8.setFocusPainted(true);
       bkwiatek8.setContentAreaFilled(false);

       JButton bkwiatek9 = new JButton("");
       ImageIcon img9 = new ImageIcon("src/Grafika/kwiatek9.png");
       Image imgg9 = img9.getImage() ;
       Image newimg9 = imgg9.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;
       img9 = new ImageIcon( newimg9 );
       bkwiatek9.setIcon(img9);
       bkwiatek9.setBounds(350, 200, 80, 80);
       bkwiatek9.setBorder(null);
       bkwiatek9.setFocusPainted(true);
       bkwiatek9.setContentAreaFilled(false);

       JButton bkwiatek10 = new JButton("");
       ImageIcon img10 = new ImageIcon("src/Grafika/kwiatek10.png");
       Image imgg10 = img10.getImage() ;
       Image newimg10 = imgg10.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;
       img10 = new ImageIcon( newimg10 );
       bkwiatek10.setIcon(img10);
       bkwiatek10.setBounds(450, 200, 80, 80);
       bkwiatek10.setBorder(null);
       bkwiatek10.setFocusPainted(true);
       bkwiatek10.setContentAreaFilled(false);

       JButton bkwiatek11 = new JButton("");
       ImageIcon img11 = new ImageIcon("src/Grafika/kwiatek11.png");
       Image imgg11 = img11.getImage() ;
       Image newimg11 = imgg11.getScaledInstance( 90, 90,  java.awt.Image.SCALE_SMOOTH ) ;
       img11 = new ImageIcon( newimg11 );
       bkwiatek11.setIcon(img11);
       bkwiatek11.setBounds(50, 300, 80, 80);
       bkwiatek11.setBorder(null);
       bkwiatek11.setFocusPainted(true);
       bkwiatek11.setContentAreaFilled(false);

       JButton bkwiatek12 = new JButton("");
       ImageIcon img12 = new ImageIcon("src/Grafika/kwiatek12.png");
       Image imgg12 = img12.getImage() ;
       Image newimg12 = imgg12.getScaledInstance( 85, 85,  java.awt.Image.SCALE_SMOOTH ) ;
       img12 = new ImageIcon( newimg12 );
       bkwiatek12.setIcon(img12);
       bkwiatek12.setBounds(150, 300, 80, 80);
       bkwiatek12.setBorder(null);
       bkwiatek12.setFocusPainted(true);
       bkwiatek12.setContentAreaFilled(false);

       JButton bkwiatek13 = new JButton("");
       ImageIcon img13 = new ImageIcon("src/Grafika/kwiatek13.png");
       Image imgg13 = img13.getImage() ;
       Image newimg13 = imgg13.getScaledInstance( 85, 85,  java.awt.Image.SCALE_SMOOTH ) ;
       img13 = new ImageIcon( newimg13 );
       bkwiatek13.setIcon(img13);
       bkwiatek13.setBounds(250, 300, 80, 80);
       bkwiatek13.setBorder(null);
       bkwiatek13.setFocusPainted(true);
       bkwiatek13.setContentAreaFilled(false);

       JButton bkwiatek14 = new JButton("");
       ImageIcon img14 = new ImageIcon("src/Grafika/kwiatek14.png");
       Image imgg14 = img14.getImage() ;
       Image newimg14 = imgg14.getScaledInstance( 90, 90,  java.awt.Image.SCALE_SMOOTH ) ;
       img14 = new ImageIcon( newimg14 );
       bkwiatek14.setIcon(img14);
       bkwiatek14.setBounds(350, 300, 80, 80);
       bkwiatek14.setBorder(null);
       bkwiatek14.setFocusPainted(true);
       bkwiatek14.setContentAreaFilled(false);

       JButton bkwiatek15 = new JButton("");
       ImageIcon img15 = new ImageIcon("src/Grafika/kwiatek15.png");
       Image imgg15 = img15.getImage() ;
       Image newimg15 = imgg15.getScaledInstance( 90, 90,  java.awt.Image.SCALE_SMOOTH ) ;
       img15 = new ImageIcon( newimg15 );
       bkwiatek15.setIcon(img15);
       bkwiatek15.setBounds(450, 300, 80, 80);
       bkwiatek15.setBorder(null);
       bkwiatek15.setFocusPainted(true);
       bkwiatek15.setContentAreaFilled(false);
       
       panel1.setLayout(null);

       panel1.setVisible(true);
       panel1.add(labeltytulowy);
       panel1.add(bkwiatek1);
       panel1.add(bkwiatek2);
       panel1.add(bkwiatek3);
       panel1.add(bkwiatek4);
       panel1.add(bkwiatek5);
       panel1.add(bkwiatek6);
       panel1.add(bkwiatek7);
       panel1.add(bkwiatek8);
       panel1.add(bkwiatek9);
       panel1.add(bkwiatek10);
       panel1.add(bkwiatek11);
       panel1.add(bkwiatek12);
       panel1.add(bkwiatek13);
       panel1.add(bkwiatek14);
       panel1.add(bkwiatek15);
   }

    public static void main(String[] args) {
        PlantsMenu frame = new PlantsMenu();
        frame.setVisible(true);
    }
}