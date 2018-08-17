package uptc.softMin.logic;
/**
 *
 * @author Sergio Rojas y Jimmy Plazas
 */
public class ManagementModern {
    private int [] vect5={};
    private double rqd;
    private double jn;
    private double jr;
    private double ja;
    private double jw;
    private double srf;
    
    public ManagementModern(){
        rqd = 0;
        jn = 0;
        jr = 0;
        ja = 0;
        jw = 0;
        srf = 0;
    }
    
    public void calculateA1(double spotCharge,double  compression){
        System.out.println("llego a manegement modern A1");
    }
     public void calculateA2(double rqd){
        System.out.println("llego a manegement modern A2");
    }
      public void calculateA3(double discontinuity){
        System.out.println("llego a manegement modern A3");
    }
       public void calculateA4(int  condition4){
        System.out.println("llego a manegement modern A1");
    }
       public void calculateA5(double flow, double watherPresu, int indexCB){
        System.out.println("llego a manegement modern A1");
    }

    public double calculateRQD(int option){
        switch(option){
            case 0: return 20;
            case 1: return 40;
            case 2: return 60;
            case 3: return 80;
            case 4: return 95;
        }
        return 0;
    }
    
    public double calculateJn(int optionJn, int operationJn){
        double value = 0;
        switch(optionJn){
            case 0: value = 7;
                break;
            case 1: value = 2;
                break;
            case 2: value = 3;
                break;
            case 3: value = 4;
                break;
            case 4: value = 6;
                break;
            case 5: value = 9;
                break;
            case 6: value = 12;
                break;
            case 7: value = 15;
                break;
            case 8: value = 20;
                break;
        }
        switch(operationJn){
            case 0: return value;
            case 1: return (value * 3);
            case 2: return (value * 2);
        }
        return 0;
    }
    
    public double calculateJr(int optionJr){
        switch(optionJr){
            case 0: return 4;
            case 1: return 3;
            case 2: return 2;
            case 3: return 1.5;
            case 4: return 1.5;
            case 5: return 1;
            case 6: return 0.5;
            case 7: return 1;
            case 8: return 1;
        }
        return 0;
    }
    
    public double calculateJa(int classificationJa, int optionJa){
        switch(classificationJa){
            case 0:
                switch(optionJa){
                    case 0: return 0.75;
                    case 1: return 1;
                    case 2: return 2;
                    case 3: return 3;
                    case 4: return 4;
                }
                break;
            case 1:
                switch(optionJa){
                    case 0: return 4;
                    case 1: return 6;
                    case 2: return 8;
                    case 3: return 10;
                }
                break;
            case 2:
                switch(optionJa){
                    case 0: return 6;
                    case 1: return 8;
                    case 2: return 10;
                    case 3: return 3;
                    case 4: return 11.5;
                    case 5: return 16.5;
                }
                break;
        }
        return 0;
    }
    
    public double calculateJw(int optionJw){
        switch(optionJw){
            case 0: return 1;
            case 1: return 0.66;
            case 2: return 0.5;
            case 3: return 0.33;
            case 4: return 0.15;
            case 5: return 0.001;
        }
        return 0;
    }
    
    public double calculateSRF(int tableSRF, int optinSRF){
        switch(tableSRF){
            case 0:
                switch(optinSRF){
                    case 0: return 10;
                    case 1: return 5;
                    case 2: return 2.5;
                    case 3: return 7.5;
                    case 4: return 5;
                    case 5: return 2.5;
                    case 6: return 5;
                }
                break;
            case 1:
                switch(optinSRF){
                    case 0: return 2.5;
                    case 1: return 1;
                    case 2: return 1;
                    case 3: return 25;
                    case 4: return 125;
                    case 5: return 300;
                }
                break;
            case 2:
                switch(optinSRF){
                    case 0: return 7;
                    case 1: return 15;
                    case 2: return 7;
                    case 3: return 15;
                }
                break;
        }
        return 0;
    }
       
    public String calculateQ(int option, int optionJn, int operationJn,
            int optionJr, int classificationJa, int optionJa, int optionJw,
            int tableSRF, int optionSRF){
        rqd = calculateRQD(option);
        jn = calculateJn(optionJn, operationJn);
        jr = calculateJr(optionJr);
        ja = calculateJa(classificationJa, optionJa);
        jw = calculateJw(optionJw);
        return String.valueOf( ( (rqd/jn) * (jr/ja) * (jw/srf) ) );
    }
}
