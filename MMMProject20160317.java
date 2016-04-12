/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmprojekt20161703;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Marek
 */
public class MMMProjekt20161703 {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        ProgramMainWindow MainFrame = new ProgramMainWindow();      //Tworzymy nowe główne okno programu.
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Wyjdź z programy przy wyłączeniu okna.
        MainFrame.setVisible(true);                                 //Ustawiamy je widocznym na ekranie komputera.
        
        System.out.print("ELOOO NAPIS");
    }
}
