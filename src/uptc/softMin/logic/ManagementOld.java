package uptc.softMin.logic;
/**
 *
 * @author Sergio Rojas y Jimmy Plazas
 * terminacion de codigo logica para terminar clases de clasification
 */
public class ManagementOld {
    
    private int[][] matA1 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 3, 4, 4}};
    private int[][] matA2 = {{30, 22, 15, 9}, {27, 20, 13, 8}, 
        {24, 18, 12, 7}, {19, 15, 10, 6}};
    private int[] vecB = {9, 13, 23, 30, 36, 40};
    private int[][] matB1 = {{11, 13}, {16, 19}, {24, 28}, {32, 36}, {38, 40},
        {43, 45}};
    private int[][] matB2 = {{10, 12}, {15, 17}, {19, 22}, {25, 28}, {33, 35},
        {37, 40}};
    private int[][] matB3 = {{9, 9, 7}, {14, 14, 11}, {23, 23, 19}, {30, 28, 24},
        {36, 34, 28}, {40, 38, 34}};
    private int[][] matC1 = {{22, 18, 12}, {19, 15, 9}, {15, 11, 7}, {10, 8, 6}};
    private int[][] matC2 = {{25, 22, 18}, {23, 19, 14}, {21, 16, 12}, {18, 14, 10}};
    private double parameterA;
    private double parameterB;
    private double parameterC;
   
    public ManagementOld(){
        begin();
    }    
    
    private void begin(){
        parameterA = 0;
        parameterB = 0;
        parameterC = 0;
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
    
    //RSR Classification
    public void calculateParameterA(int typeOfRock, int hardness, int structure){
        int type = matA1[typeOfRock][hardness] - 1;
        parameterA = matA2[type][structure];
    }
    
    public void calculateParameterB(boolean dataType, double fracture, int direction, int level){
        int row = 0;
        if(!dataType){
            fracture = fracture * 12;
        }        
        if(fracture < 2){
            row = 0;
        }
        if(fracture == 2 || fracture < 6){
            row = 1;
        }
        if(fracture == 6 || fracture < 12){
            row = 2;
        }
        if(fracture == 12 || fracture < 24){
            row = 3;
        }
        if(fracture == 24 || fracture < 48){
            row = 4;
        }
        if(fracture >= 48){
            row = 5;
        }
        switch(direction){
            case 0:
                parameterB = vecB[row];
                break;
            case 1:
                if(level == 1){
                    parameterB = matB1[row][0];
                }
                if(level == 2){
                    parameterB = matB1[row][1];
                }
                break;
            case 2:
                if(level == 1){
                    parameterB = matB2[row][0];
                }
                if(level == 2){
                    parameterB = matB2[row][1];
                }
                break;
            case 3:
                if(level == 0){
                    parameterB = matB3[row][0];
                }
                if(level == 1){
                    parameterB = matB3[row][1];
                }
                if(level == 2){
                    parameterB = matB3[row][2];
                }
                break;    
        }
    }
    
    public double calculateRSR(int infiltration, int discontiunity){
        double sum = parameterA + parameterB;
        if( sum >= 13 && sum < 44){
            parameterC = matC1[infiltration][discontiunity];
        }
        if( sum >= 45 && sum < 75){
            parameterC = matC2[infiltration][discontiunity];
        }
        return sum + parameterC;
    }
    
}
