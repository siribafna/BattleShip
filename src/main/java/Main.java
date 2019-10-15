import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] battleField = new char[8][8];
        battleField = createLargestShip();
        battleField = createSecondLargestShip(battleField);
        battleField = createThirdShip(battleField);
        battleField = createSecondShip(battleField);

        Scanner input = new Scanner(System.in);
        System.out.println("X Coordinates: ");
        int xChoice = input.nextInt();
        System.out.println("Y Coordinates: ");
        int yChoice = input.nextInt();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
             if (battleField[xChoice][yChoice] == '0') {
                 System.out.println("You hit");
                 battleField[xChoice][yChoice] = '*';
             }
             else
                 continue;
            }
        }



        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(battleField[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static char[][] createArray() {

        char[][] battleField = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                battleField[i][j] = '-';
            }
        }
        return battleField;

    }

    public static char[][] createLargestShip() {

        char[][] battleField = createArray();
        int xCoord = 7; //createRandomSize5();
        int yCoord = 6; //createRandomSize5();
        List<Integer> myFiveList = new ArrayList<>();
        myFiveList.add(xCoord);
        myFiveList.add(yCoord);

        System.out.println("5 Ship @ " + xCoord + ", " + yCoord);
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (xCoord - 4 >= 0){ // tests for big ship going UP
                    for(int k = 0; k < 5; k++) {
                        battleField[xCoord - k][yCoord] = '0';
                    }
                }
                else if (yCoord - 4 >= 0){ // tests for big ship going left
                    for(int k = 0; k < 5; k++) {
                        battleField[xCoord][yCoord - k] = '0';
                    }
                }
                else if (xCoord + 4 < 8){ // tests for big ship going down
                    for(int k = 0; k < 5; k++) {
                        battleField[xCoord + k][yCoord] = '0';
                    }
                }
                else if (yCoord + 4 < 8){ // tests for big ship going right
                    for(int k = 0; k < 5; k++) {
                        battleField[xCoord][yCoord + k] = '0';
                    }
                }
            }
        }
        createRandomSize4(myFiveList);
        return battleField;
    }

    public static char[][] createSecondLargestShip(char[][] battleField) {

        int xCoord = 2; //createRandomSize4();
        int yCoord = 7; // createRandomSize4();
        System.out.println("4 Ship @ " + xCoord + ", " + yCoord);
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (battleField[xCoord][yCoord] != '0') {
                    if (xCoord - 3 >= 0) { // tests for big ship going UP
                        if (battleField[xCoord - 3][yCoord] != '0' && battleField[xCoord - 2][yCoord] != '0' && battleField[xCoord - 1][yCoord] != '0') {
                            for (int k = 0; k < 4; k++) {
                                battleField[xCoord - k][yCoord] = '0';
                            }
                        }
                    } else if (yCoord - 3 >= 0) { // tests for big ship going left
                        if (battleField[xCoord][yCoord - 3] != '0' && battleField[xCoord][yCoord - 2] != '0' && battleField[xCoord][yCoord - 1] != '0') {
                            for (int k = 0; k < 4; k++) {
                                battleField[xCoord][yCoord - k] = '0';
                            }
                        }
                    } else if (xCoord + 3 < 8) { // tests for big ship going down
                        if (battleField[xCoord + 3][yCoord] != '0' && battleField[xCoord + 2][yCoord] != '0' && battleField[xCoord + 1][yCoord] != '0') {
                            for (int k = 0; k < 4; k++) {
                                battleField[xCoord + k][yCoord] = '0';
                            }
                        }
                    } else  if (yCoord + 3 < 8){ // tests for big ship going right
                        if (battleField[xCoord][yCoord + 3] != '0' && battleField[xCoord][yCoord + 2] != '0' && battleField[xCoord][yCoord + 1] != '0') {

                            for (int k = 0; k < 4; k++) {
                                battleField[xCoord][yCoord + k] = '0';
                            }
                        }
                    }
                }
            }
        }
        return battleField;
    }

    public static char[][] createThirdShip(char[][] battleField) {

        int xCoord = 0; //createRandomSize3();
        int yCoord = 6; // createRandomSize3();
        System.out.println("3 Ship @ " + xCoord + ", " + yCoord);
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (battleField[xCoord][yCoord] != '0') {
                    if (xCoord - 2 >= 0) { // tests for big ship going UP
                        if (battleField[xCoord - 2][yCoord] != '0' && battleField[xCoord - 1][yCoord] != '0') {
                            for (int k = 0; k < 3; k++) {
                                battleField[xCoord - k][yCoord] = '0';
                            }
                        }
                    } else if (yCoord - 2 >= 0) { // tests for big ship going left
                        if (battleField[xCoord][yCoord - 2] != '0' && battleField[xCoord][yCoord - 1] != '0') {
                            for (int k = 0; k < 3; k++) {
                                battleField[xCoord][yCoord - k] = '0';
                            }
                        }
                    } else if (xCoord + 2 < 8) { // tests for big ship going down
                        if (battleField[xCoord + 2][yCoord] != '0' && battleField[xCoord + 1][yCoord] != '0') {
                            for (int k = 0; k < 3; k++) {
                                battleField[xCoord + k][yCoord] = '0';
                            }
                        }
                    } else  if (yCoord + 2 < 8){ // tests for big ship going right
                        if (battleField[xCoord][yCoord + 2] != '0' && battleField[xCoord][yCoord + 1] != '0') {

                            for (int k = 0; k < 3; k++) {
                                battleField[xCoord][yCoord + k] = '0';
                            }
                        }
                    }
                }
            }
        }
        return battleField;
    }

    public static char[][] createSecondShip(char[][] battleField) {

        int xCoord = 4; // createRandomSize2();
        int yCoord = 5; // createRandomSize2();
        System.out.println("2 Ship @ " + xCoord + ", " + yCoord);
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (battleField[xCoord][yCoord] != '0') {
                    if (xCoord - 1 >= 0) { // tests for big ship going UP
                        if (battleField[xCoord - 1][yCoord] != '0') {
                            for (int k = 0; k < 2; k++) {
                                battleField[xCoord - k][yCoord] = '0';
                            }
                        }
                    } else if (yCoord - 2 >= 0) { // tests for big ship going left
                        if (battleField[xCoord][yCoord - 1] != '0') {
                            for (int k = 0; k < 2; k++) {
                                battleField[xCoord][yCoord - k] = '0';
                            }
                        }
                    } else if (xCoord + 2 < 8) { // tests for big ship going down
                        if (battleField[xCoord + 1][yCoord] != '0') {
                            for (int k = 0; k < 2; k++) {
                                battleField[xCoord + k][yCoord] = '0';
                            }
                        }
                    } else  if (yCoord + 2 < 8){ // tests for big ship going right
                        if (battleField[xCoord][yCoord + 1] != '0') {

                            for (int k = 0; k < 2; k++) {
                                battleField[xCoord][yCoord + k] = '0';
                            }
                        }
                    }
                }
            }
        }
        return battleField;
    }



    public static int createRandomSize5() {
        int max = 7;
        int min = 0;
        int range = max - min + 1;
        int randX = (int)(Math.random() * range) + min;
        return randX;
    }

    public static int createRandomSize4(List<Integer> myFiveList) {
        int xCoord = myFiveList.get(0);
        int yCoord = myFiveList.get(1);

        int max = 7;
        int min = 0;
        int range = max - min + 1;
        int randX = (int)(Math.random() * range) + min;

        return randX;

    }
    public static int createRandomSize3() {
        int max = 7;
        int min = 0;
        int range = max - min + 1;
        int randX = (int) (Math.random() * range) + min;
        return randX;

    }

    public static int createRandomSize2() {
        int max = 7;
        int min = 0;
        int range = max - min + 1;
        int randX = (int) (Math.random() * range) + min;
        return randX;

    }
}
