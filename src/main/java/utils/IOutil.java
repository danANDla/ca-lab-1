package utils;

import calculator.Matrix;

import java.util.Scanner;

public class IOutil{
    private boolean errsInOut = true;
    private final Scanner scanner;

    public IOutil(){
        scanner = new Scanner(System.in);
    }

    public void setErrsInOut(boolean errsInOut) {
        this.errsInOut = errsInOut;
    }

    public void printText(String text){
        System.out.println(text);
    }
    public void printText(String text, int mode){
        switch (mode){
            case 1:
                System.out.print(text);
                break;
            default:
                printText(text);
        }
    }
    public void printWarning(String text){
        System.out.println( "\u001B[33m" + text + "\u001B[0m");
    }
    public void printError(String text){
        if(errsInOut) System.out.println("\u001B[31m" + "Error: " + text + "\u001B[0m");
        else System.err.println(text);
    }
    public String readLine(){
        return scanner.nextLine();
    }
    public double readDouble(){
        double a = scanner.nextDouble();
        return a;
    }

    public void printTable(int rows, int columns, double[][] table){
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < columns-1; ++j){
                printDouble(table[i][j]);
            }
            System.out.printf("| %5.4f\n", table[i][columns-1]);
        }
    }

    public void printDouble(double num){
        if(num == 0) System.out.printf("%10d ", 0);
        else System.out.printf("%10.4f ", num);
    }

    public void printlnDouble(double num){
        if(num == 0) System.out.printf("%10d\n", 0);
        else System.out.printf("%10.4f\n", num);
    }

    public void printDivider(){
        System.out.println("------------------------------------------");
    }

    public void printArrow(){
        System.out.print("> ");
    }
}
