/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmprojekt20161703;
import java.awt.*;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JFrame;
/**
 *
 * @author Marek
 */
public class ProgramMainWindow extends JFrame{
    public ProgramMainWindow(){
        
        //pobierz rozdzielczość ekranu;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension rozmiarEkranu = kit.getScreenSize();
        int heightOfScreen = rozmiarEkranu.height;
        int widthOfScreen = rozmiarEkranu.width;
        
        //umieść ramkę na środku ekranu
        this.setSize(2*widthOfScreen / 3, 2*heightOfScreen / 3);
        this.setLocation(widthOfScreen / 6, heightOfScreen / 6);
        
        //określ tytuł ramki
        this.setTitle("Model Obwodu Elektycznego written by Marek Koszałka");
        // Container for all inside JFrame
        Container powZawartosci = getContentPane();
        // Components inside of Container
        Component WykresLiniowy1 = new WykresLiniowy(Color.BLACK, 00, 00);
                 
        Component WykresLiniowy2 = new WykresLiniowy(Color.gray, 10, 10);
        
        Box BoxHorizontal = Box.createVerticalBox();
        Box BoxVertLeft = Box.createVerticalBox();
        Box BoxVertRight = Box.createVerticalBox();
        
        BoxHorizontal.add(BoxVertLeft);
        BoxHorizontal.add(BoxVertRight);
        
        BoxVertLeft.add(WykresLiniowy1);
        VoltageSource TestoweZrodlo = new VoltageSource("triangular");
        BoxVertRight.add(new WykresLiniowy(TestoweZrodlo.getWartosciWV(), Color.BLUE, 30, 30));
        
        powZawartosci.add(BoxHorizontal, BorderLayout.CENTER);
        //powZawartosci.add(WykresLiniowy2, BorderLayout.CENTER);
        /*
        TO DO: Trzeba będzie BorderLayout podzielić jeszcze na 3 kolejne kawałki prawdopodobnie... 
        A w każdym takim kawałku dodać po jednym wykresie liniowym.
        */
        
        
        Component Wykres1 = new Wykres(Color.GREEN);
        powZawartosci.add(Wykres1, BorderLayout.LINE_START);
        Wykres1.setPreferredSize(new Dimension(200, 200));
                     
        Dimension WymiaryCenter = new Dimension(Wykres1.getSize());
        System.out.println("Wysokość" + WymiaryCenter.height + "Szerekość:" + WymiaryCenter.width);
    }
}
