/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmprojekt20161703;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 *
 * @author Marek
 */
public class Wykres extends JPanel{
    
    public Color kolorRysowania;
    
    public Wykres(Color kolorPodany){
        kolorRysowania = kolorPodany;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //tutaj znajduje się kod rysujący
        g.setColor(kolorRysowania);
        for(int i = 0; i < 200;i++){
            g.drawLine(0, i*10, 2000, i*10);
            g.drawLine(i*10, 0, i*10, 2000);
        }
    }
}
