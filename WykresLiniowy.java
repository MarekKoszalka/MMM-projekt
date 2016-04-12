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
 * @author Marek
 */
public class WykresLiniowy extends JPanel {
    
// zmienne dotyczące 'modelu' - przechowujące dane (MVC)
    public double[] XVector;
    public double[] YVector;
    public double random;
    
// zmienne dotyczące 'widoku' - do wyświatlania danych (MVC)   
    public Color kolorRysowania;
    public int heightOfGraph;
    public int widthOfGraph;
    public int startingPosX;
    public int startingPosY;
    
//zmienne dotyczące 'sterownika' - obsługujące te dane (MVC)
// w tej klasie to np. animacja wykresu.
    public WykresLiniowy(Color kolorPodany, int startingPosX, int startingPosY){  // KONSTRUKTOR
        
        //inicjalizacja zmiennych w konstruktorze, które są dobrze zdefiniowane.
        // ' this. '   <--- dodaję to tylko we fragmencie który nadaje wartość początkową zmiennych klasy.
        this.kolorRysowania = kolorPodany;
        this.heightOfGraph = 200;
        this.widthOfGraph = 300;
        this.startingPosX = startingPosX;
        this.startingPosY = startingPosY;
        this.XVector = new double[widthOfGraph];
        this.YVector = new double[heightOfGraph];
        
        //inicjalizacja wartości X i Y --- TESTOWANIE
        for(int i = 0; i < widthOfGraph ; i++){
            random = Math.round((Math.random() * 150));
            System.out.println((int)random);
            XVector[i] = (int)random;  // niech wartości będę zapisane sensownie, a wyświtlanie będzie przkombinowane
            //XVector[i] = (int)((heightOfGraph - 0.5*i));
        }
    }
    
        public WykresLiniowy(double[] getXVector, Color kolorPodany, int startingPosX, int startingPosY){  // KONSTRUKTOR
        
        //inicjalizacja zmiennych w konstruktorze, które są dobrze zdefiniowane.
        // ' this. '   <--- dodaję to tylko we fragmencie który nadaje wartość początkową zmiennych klasy.
        this.kolorRysowania = kolorPodany;
        this.heightOfGraph = 200;
        this.widthOfGraph = 300;
        this.startingPosX = startingPosX;
        this.startingPosY = startingPosY;
        this.XVector = new double[widthOfGraph];
        this.YVector = new double[heightOfGraph];
        
        //inicjalizacja wartości X i Y --- TESTOWANIE
        for(int i = 0; i < widthOfGraph ; i++){
            XVector[i] = getXVector[i];  // niech wartości będę zapisane sensownie, a wyświtlanie będzie przkombinowane
            //XVector[i] = (int)((heightOfGraph - 0.5*i));
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //tutaj znajduje się kod rysujący
        g.setColor(Color.BLACK);
        //Rysowanie Osi X:
        g.drawLine(startingPosX, heightOfGraph + startingPosY, startingPosX + widthOfGraph, heightOfGraph + startingPosY);
        //Rysowanie Osi Y:
        g.drawLine(startingPosX, startingPosY + heightOfGraph, startingPosX, startingPosY);
        //Rysowanie Wykresu jako wiele lini od punktu do punktu;
        g.setColor(kolorRysowania);
        for(int i = 0; i < widthOfGraph - 1; i++){
            g.drawLine(startingPosX + (i), heightOfGraph + startingPosY - (int)XVector[i], startingPosX + (i + 1), heightOfGraph + startingPosY - (int)XVector[i+1]);
            //System.out.println("Y1=" + startingPosY + (XVector[i]) + "Y2=" + startingPosY + (XVector[i+1]));
        }
    }
}
