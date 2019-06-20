package logic.old;

import java.text.DecimalFormat;

public class Terzaghi {

    private double c;
    private DecimalFormat df = new DecimalFormat("#.###");

    public Terzaghi(){
        c = 0;
    }

    public String calculate(String option, double width, double height){
        c = (width + height);
        switch (option){
            case "1": return "0,0";
            case "2": return "0," + String.valueOf( df.format(0.25 * width) );
            case "3": return "0," + String.valueOf( df.format(0.5 * width) );
            case "4": return "0," + String.valueOf( df.format(0.25 * width)) + " - " + String.valueOf( df.format(0.35 * c));
            case "5": return "0 - " + String.valueOf( df.format(0.6 * c) ) + ","
                    + String.valueOf( df.format(0.35 * width)) + " - " + String.valueOf( df.format(1.1 * c) );
            case "6": return "," + String.valueOf( df.format(1.1 * c ) );
            case "7": return String.valueOf( df.format(0.54 * c)) + " - " + String.valueOf( df.format(1.2 * c) ) + ","
                    + String.valueOf( df.format(0.62 * c) ) + " - " + String.valueOf( df.format(1.38 * c) );
            case "7.1": return String.valueOf( df.format(0.94 * c) ) + " - " + String.valueOf( df.format(1.2 * c) ) + ","
                    + String.valueOf( df.format(1.08 * c)) + " - " + String.valueOf( df.format(1.38 * c) );
            case "8": return "," + String.valueOf( c ) + " - " + String.valueOf( df.format(2.1 * c) );
            case "9": return "," + String.valueOf( df.format(2.1 * c) ) + " - " + String.valueOf( df.format(4.5 * c) );
        }
        return "";
    }

    public String getObservation(String option){
        switch (option){
            case "1": return "Desprendimiento solo si hay desprendimiento o chasquido.";
            case "2": return "Desprendimiento general.";
            case "3": return "Presión lateral si los estratos están inclinados, algún desprendimiento.";
            case "4": return "Generalmente sin presión lateral, la carga cambia erráticamente de punto a punto.";
            case "5": return "Sin o pequeña presión lateral.";
            case "6": return "Considerable presión lateral, soporte contínuo si hay infiltraciones.";
            case "7": return "Presión lateral Ph = 0.3y(0.5Ht+Hp).";
            case "7.1": return "Presión lateral Ph = 0.3y(0.5Ht+Hp).";
            case "8": return "Alta presión lateral, requiere soporte contínuo.";
            case "9": return "Alta presión lateral, requiere soporte contínuo.";
        }
        return "Nada";
    }

    public String calculateWeight(double weight){

        return "";
    }
}
