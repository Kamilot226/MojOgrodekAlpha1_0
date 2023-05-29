package MojOgrodek;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import static MojOgrodek.Music.setVolume;
import static MojOgrodek.openingFrame.music;

public class MusicFrame extends JFrame {

    static final int SLIDER_MIN = 0;
    static final int SLIDER_MAX = 100;
    static final int SLIDER_INIT = 40;

    Color color;

    MusicFrame() {

        int width = 400;
        int height = 500;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        //getContentPane().setBackground(Color.black);
        this.setResizable(false);
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel mainPanel = new GradientPanel();

        add(BorderLayout.CENTER, mainPanel);

        JLabel label2 = new JLabel("OPCJE MUZYKI", SwingConstants.CENTER);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("monospaced", Font.BOLD, 30));
        Dimension size = label2.getPreferredSize();
        label2.setBounds(0, 80, 380, size.height);
        mainPanel.setLayout(null);


        JLabel label3 = new JLabel("POZIOM GŁOŚNOŚCI", SwingConstants.CENTER);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("monospaced", Font.BOLD, 18));
        Dimension size2 = label3.getPreferredSize();
        label3.setBounds(0, 140, 380, size2.height);

        JSlider volslider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        volslider.setMajorTickSpacing(10);
        volslider.setPaintLabels(true);
        volslider.setForeground(Color.WHITE);
        volslider.setOpaque(false);
        Dimension size3 = volslider.getPreferredSize();
        volslider.setBounds(20, 180, 350 , size3.height);
        volslider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setVolume((float)volslider.getValue()/100);
            } });

        JLabel label4 = new JLabel("WŁĄCZ/WYŁĄCZ DŹWIĘK", SwingConstants.CENTER);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("monospaced", Font.BOLD, 18));
        Dimension size4 = label4.getPreferredSize();
        label4.setBounds(0, 250, 380, size4.height);

        JToggleButton toggleButton = new JToggleButton("", true);
        toggleButton.setBackground(Color.RED);
        ImageIcon img = new ImageIcon("src/MojOgrodek/equalizer.png");
        toggleButton.setIcon(img);
        //toggleButton.setOpaque(true);

        Dimension size5 = toggleButton.getPreferredSize();
        toggleButton.setBounds(164, 280, 64, 64);

        ItemListener itemListener = new ItemListener() {

            public void itemStateChanged(ItemEvent itemEvent)
            {
                int state = itemEvent.getStateChange();

                if (state == ItemEvent.SELECTED) {
                    toggleButton.setBackground(Color.GREEN);
                    toggleButton.revalidate();
                    toggleButton.repaint();
                    try {
                        music.play();
                    } catch (IOException e) {

                    }
                }
                else {
                    toggleButton.setBackground(Color.RED);
                    toggleButton.repaint();
                    try {
                        music.stop();
                    } catch (IOException e) {

                    }
                }
            }
        };

        JButton button1  = new RoundRectButton("POWRÓT");
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("monospaced", Font.BOLD, 18));
        button1.setBounds(100,380,200,40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusicFrame.this.dispose();
            }
        });


        mainPanel.add(label2);
        mainPanel.add(label3);
        mainPanel.add(volslider);
        mainPanel.add(label4);
        mainPanel.add(toggleButton);
        toggleButton.addItemListener(itemListener);
        toggleButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return Color.GREEN;
            }
        });
        mainPanel.add(button1);


        mainPanel.setVisible(true);

    }

    public static void main(String[] args) {
        MusicFrame frame = new MusicFrame();
        frame.setVisible(true);
    }

    public void showMusicFrame() {
        this.setVisible(true);
    }


}

