package uptc.softMin.logic;

/**
 *
 * @author Sergio Rojas y Jimmy Plazas
 */
public class ManagementModern {
<<<<<<< HEAD
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
=======

    private int[] vet5c = {15, 10, 7, 4, 0};
    private int[][] matB = {{0, 2, 5, 10, 12}, {0, 2, 7, 15, 25}, {0, 5, 25, 50, 60}};
    private int[][] matE = {{6, 5, 3, 1, 0}, {6, 4, 2, 2, 0}, {6, 5, 3, 1, 0}};

    public ManagementModern() {

>>>>>>> 8afff712f69ea5e256a11e0dd5890222dca15d5a
    }

    public double calculateA1(double spotCharge, double compression) {
        double point1 = 0;
        if (spotCharge > 0 && compression == 0) {
            if (spotCharge >= 10 && spotCharge != 0) {
                point1 = 15;
            } else if (spotCharge >= 4 && spotCharge < 10) {
                point1 = 12;
            } else if (spotCharge >= 2 && spotCharge < 4) {
                point1 = 7;
            } else if (spotCharge >= 1 && spotCharge < 2) {
                point1 = 4;
            }
        } else {
            if (compression >= 250 && compression != 0) {
                point1 = 15;
            } else if (compression >= 100 && compression < 250) {
                point1 = 12;
            } else if (compression >= 50 && compression < 100) {
                point1 = 7;
            } else if (compression >= 25 && compression < 50) {
                point1 = 4;
            } else if (compression >= 5 && compression < 25) {
                point1 = 2;
            } else if (compression >= 1 && compression < 5) {
                point1 = 1;
            } else if (compression < 1) {
                point1 = 0;
            }

        }
        return point1;
    }

    public double calculateA2(double rqd) {
        double point2 = 0;
        if (rqd >= 90 && rqd <= 100) {
            point2 = 20;
        } else if (rqd >= 75 && rqd < 90) {
            point2 = 17;
        } else if (rqd >= 50 && rqd < 75) {
            point2 = 13;
        } else if (rqd >= 25 && rqd < 50) {
            point2 = 8;
        } else if (rqd < 25) {
            point2 = 3;
        }
        return point2;
    }

    public double calculateA3(double discontinuity) {
        //se maneja solo en metros
        double point3 = 0;

        if (discontinuity >= 2 && discontinuity != 0) {
            point3 = 20;
        } else if (discontinuity >= 0.6 && discontinuity < 2) {
            point3 = 15;
        } else if (discontinuity >= 0.2 && discontinuity < 0.6) {
            point3 = 10;
        } else if (discontinuity >= 0.06 && discontinuity < 0.2) {
            point3 = 8;
        } else if (discontinuity < 0.06) {
            point3 = 5;
        }
        return point3;
    }

    public double calculateA4(int condition4) {
        double point4 = 0;
        point4 = condition4;

        return point4;
    }

    public double calculateA5(double flow, double watherPresu, int indexCB) {
        double point5a = 0;
        double point5b = 0;
        double point5c = 0;

        if (flow == 0) {
            point5a = 15;
        } else if (flow < 10) {
            point5a = 10;
        } else if (flow >= 10 && flow < 25) {
            point5a = 7;
        } else if (flow >= 25 && flow < 125) {
            point5a = 4;
        } else if (flow >= 125) {
            point5a = 0;
        }

        if (watherPresu == 0) {
            point5b = 15;
        } else if (watherPresu < 0.1) {
            point5b = 10;
        } else if (watherPresu >= 0.1 && watherPresu < 0.2) {
            point5b = 7;
        } else if (watherPresu >= 0.2 && watherPresu < 0.5) {
            point5b = 4;
        } else if (watherPresu >= 0.5) {
            point5b = 0;
        }

        point5c = point5a + point5b + vet5c[indexCB];

        return point5c;
    }

<<<<<<< HEAD
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
=======
    public double calculateSum_A(double point1, double point2, double point3, double point4, double point5c) {
        double sum = 0;
        sum = point1 + point2 + point3 + point4 + point5c;
        return sum;
    }

    public double calculate_B(int indexROW, int indexCOLUMN) {
        int rest = matB[indexROW][indexCOLUMN];
        return rest;
    }

    public String calulate_C(double sumA, double restB) {
        double result = sumA - restB;
        String rta = "";

        if (result <= 100 && result >= 81) {
            rta = "Puntaje: " + result + "--- Tipo de Roca: I --- Descripción: Muy Buena";
        } else if (result <= 80 && result >= 61) {
            rta = "Puntaje: " + result + "--- Tipo de Roca: II --- Descripción: Buena";

        } else if (result <= 60 && result >= 41) {
            rta = "Puntaje: " + result + "--- Tipo de Roca: III --- Descripción: Regular";

        } else if (result <= 40 && result >= 21) {
            rta = "Puntaje: " + result + "--- Tipo de Roca: IV --- Descripción: Mala";

        } else if (result <= 20) {
            rta = "Puntaje: " + result + "--- Tipo de Roca: V --- Descripción: Muy Mala";

        }

        return "°- " + rta;
    }

    public String calculate_D(double sumA, double restB) {
        double result = sumA - restB;
        String answ = "";
        if (result <= 100 && result >= 81) {
            //Tipo de roca 1
            answ = "<HTML>Tipo de Roca: I<br>"
                    + "Tiempo medio de sostén: 20 años, claro de 15m <br>"
                    + "Cohesión del macizo rocoso (KPa): > 400 <br>"
                    + "Ángulo de fricción del macizo rocoso (°): > 45°.</HTML>";
        } else if (result <= 80 && result >= 61) {
            //Tipo de roca 2
            answ = "<HTML>Tipo de Roca: II<br>"
                    + "Tiempo medio de sostén: 1 año claro de 10m <br>"
                    + "Cohesión del macizo rocoso (KPa): 300 a 400 <br>"
                    + "Ángulo de fricción del macizo rocoso (°): 30° a 45°.</HTML>";

        } else if (result <= 60 && result >= 41) {
            //Tipo de roca 3
            answ = "<HTML>Tipo de Roca: III<br>"
                    + "Tiempo medio de sostén: 1 semana, claro de 5m <br>"
                    + "Cohesión del macizo rocoso (KPa): > 100 a 300 <br>"
                    + "Ángulo de fricción del macizo rocoso (°): > 25° a 35°.</HTML>";

        } else if (result <= 40 && result >= 21) {
            //Tipo de roca 4
            answ = "<HTML>Tipo de Roca: IV<br>"
                    + "Tiempo medio de sostén: 10 horas, claro 2.5m <br>"
                    + "Cohesión del macizo rocoso (KPa): > 100 a 200 <br>"
                    + "Angulo de fricción del macizo rocoso (°): > 15° a 25°.</HTML>";

        } else if (result <= 20) {
            //Tipo de roca 5
            answ = "<HTML>Tipo de Roca: V<br>"
                    + "Tiempo medio de sostén: 30min, claro de 1m <br>"
                    + "Cohesión del macizo rocoso (KPa): < 100 <br>"
                    + "Angulo de fricción del macizo rocoso (°): < 15°.</HTML>";

        }
        return answ;
    }

    public int calculate_E(double lenght, String separation, int indexR, int indexF, int indexW) {
        System.out.println("llegue al metodo logica");
        int point6 = 0;
        int point7 = 0;

        System.out.println("llega: "
                + "\n" + lenght
                + "\n" + separation
                + "\n" + indexR
                + "\n" + indexF
                + "\n" + indexW
        );

        if (lenght <= 1) {
            point6 = 6;
        } else if (lenght > 1 && lenght <= 3) {
            point6 = 4;
        } else if (lenght > 3 && lenght <= 10) {
            point6 = 2;
        } else if (lenght > 10 && lenght <= 20) {
            point6 = 1;
        } else if (lenght > 20) {
            point6 = 0;
        }
        if (separation.isEmpty()) {
            point7 = 6;
        } else {
            double separ = Double.parseDouble(separation);
            if (separ <= 0.1) {
                point7 = 5;
            } else if (separ > 0.1 && separ <= 1.0) {
                point7 = 3;
            } else if (separ > 1 && separ <= 5) {
                point7 = 1;
            } else if (separ > 5) {
                point7 = 1;
            }
        }

        //matE = {{6, 5, 3, 1, 0}, {6, 4, 2, 2, 0}, {6, 5, 3, 1, 0}};
        int point8 = matE[0][indexR];
        int point9 = matE[1][indexF];
        int point10 = matE[2][indexW];
        int result = point6 + point7 + point8 + point9 + point10;

        System.out.println("salio cb1:"+point8
                + "\nsalio cb2: "+point9
                + "\nsalio cb3: "+point10
                + "\nsali con total " + result);
        return result;

    }

>>>>>>> 8afff712f69ea5e256a11e0dd5890222dca15d5a
}
