package uptc.softMin.logic;
/**
 *
 * @author Sergio Rojas y Jimmy Plazas
 */
public class ManagementOld {
   
    public ManagementOld(){
        
    }
    
    /*Terzaghi clasification
     Se calcula Hp*/
    public double calculateHp(double k,double b, double h,
            double phi, double a){
        return k*(b+h);
    }
    // Se calcula A3
    public double calculateA3(double b, double h){
        return b * h;
    }
    // Se calcula L con c
    public double calculateL(double b, double h, double phi){
        double c = h * Math.tan(45 - (phi/2));
        return b + (2*c);
    } 
    // Se calcula A2
    public double calculateA2(double k,double b, double h,
            double phi, double a){
        double l = calculateL(b, h, phi);
        double hp = calculateHp(k, b, h, phi, a);
        double h2 = calculateH2(h, b, phi);
        return ( hp * (l/2) * Math.cos( b/l ) - h2 * (b/2) );
    }
    //Calcula A1
    public double calculateA1(double h, double phi){
        double c = h * Math.tan(45 - (phi/2));
        return (h*c)/2;
    }
    //Calcula H2
    public double calculateH2(double h, double b, double phi){
        double l = calculateL(b, h, phi);
        return ( (h/l)*Math.sqrt( (l*l)-(b*b) ) );
    }
    
    //RQD Deere Classification
    public double calculateEquation1(double numerator, double denominator){
        return (numerator/denominator) * 100;
    }
    
    public double calculateEquation2(double value){
        value = 1/value;
        return ( 100 * Math.exp(-1 * 0.1 * value) * (0.1 * value + 1) );
    }
    
    public double calculateEquation3(double value){
        return 115 - 3.3 * value;
    }
    
}
