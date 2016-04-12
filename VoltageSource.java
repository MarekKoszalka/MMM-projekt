/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmprojekt20161703;
import java.lang.String;
/**
 *
 * @author Marek
 */
public class VoltageSource {
    public double OkresWms;
    public double CzestotliwoscWkHz;
    public double AmplitudaWV;
    public double SkladowaStalaWV;
    public double[] WartosciWV;
    public double[] KrokCzasuModelowaniaWms;
    public double a, b1, b2;
    
    public VoltageSource(String WaveForm){   // KONSTRUKTOR --- KONSTRUKTOR --- KONSTRUKTOR
        this.OkresWms = 95;
        this.CzestotliwoscWkHz = 1 / OkresWms;
        this.AmplitudaWV = 60;
        this.SkladowaStalaWV = 70;
        this.WartosciWV = new double[300];
        this.a = this.wspolczynnikProstej(0, -AmplitudaWV, 0.5 * OkresWms, AmplitudaWV);
        this.b1 = SkladowaStalaWV - AmplitudaWV + a * 0;
        this.b2 = SkladowaStalaWV + AmplitudaWV - a * 0.5 * OkresWms;
        //TWORZENIE SYGNAŁU W TABLICY

        for(int i = 0; i < 300; i++){
            switch(WaveForm.toLowerCase()){
                case "square":{
                    if(i % OkresWms <= 0.5 * OkresWms){
                        WartosciWV[i] = SkladowaStalaWV + AmplitudaWV;
                    }else{ 
                        WartosciWV[i] = SkladowaStalaWV - AmplitudaWV;
                    }
                    break;
                }
                case "sinus":{ // Twoje zadanie Komor. Pokaż co potrafisz.
                    break;
                }
                case "triangular":{
                    if(i % OkresWms <= 0.5 * OkresWms){
                        WartosciWV[i] = SkladowaStalaWV - AmplitudaWV + a * (i % OkresWms) ;//b zle
                    }else WartosciWV[i] = SkladowaStalaWV + 3*AmplitudaWV - a * (i % OkresWms); // b zle poprawic
                    break;
                }
            }
        }
    }
    private double wspolczynnikProstej(double x1, double y1, double x2, double y2){
        double a = (y2 - y1)/(x2 - x1);
        double b = y1 - a*x1;
        return a;
    }
    public double[] getWartosciWV(){
        return WartosciWV;
    }
}
