/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.logic;

/**
 *
 * @author Sergio Rojas y Jimmy Plazas
 */
public class ManagementModern {

    private int[] vet5c = {15, 10, 7, 4, 0};
    private int[][] matB = {};

    public ManagementModern() {

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

    public double calculateSum_A(double point1, double point2, double point3, double point4, double point5c) {

        System.out.println("llegue a suma con "
                + "\n1: " + point1
                + "\n2: " + point2
                + "\n3: " + point3
                + "\n4: " + point4
                + "\n5: " + point5c);
        double sum = 0;
        sum = point1 + point2 + point3 + point4 + point5c;

        return sum;
    }

}
