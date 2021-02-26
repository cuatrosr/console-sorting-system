package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String[] arrayIn;
    private static double avrNum;
    private static String message;

    public static void main(String[] args) throws IOException {
        int iterationNum = Integer.parseInt(br.readLine());

        arrayIn = new String[iterationNum];
        arrayFill(iterationNum);
        setMessage(arrayIn);
        bw.write("-----------------\n");
        bw.write(message);
        
        br.close();
        bw.close();
    }

    public static void arrayFill(int iterationNum) throws IOException {
        for (int i = 0; i < iterationNum; i++) {
            arrayIn[i] = br.readLine();
        }
    }

    public static void setMessage(String[] arrayIn) {
        message = "";
        for (String array : arrayIn) {
            String[] arrayString = array.split(" ");
            double[] arrayDouble = arrayParseDouble(arrayString);
            arrayDouble = bubbleSort(arrayDouble);
            message += avrNum + "-";
            for (int j = 0; j < arrayDouble.length; j++) {
                if (j != arrayDouble.length-1) {
                    message += arrayDouble[j] + " ";
                } else {
                    message += arrayDouble[j];
                }
            }
            message += "\n";
        }
    }

    public static double[] arrayParseDouble(String[] array) {
        double[] arrayInt = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = Double.parseDouble(array[i]);
        }
        return arrayInt;
    }

    public static double[] bubbleSort(double[] arrayDouble) {
        double auxNum = 0;
        double auxAvr = arrayDouble.length-1;
        boolean changed = true;
        for (int i = 1; i < arrayDouble.length && changed; i++) {
            changed = false;
            for (int j = 0; j < arrayDouble.length - i; j++) {
                if (arrayDouble[j] > arrayDouble[j + 1]) {
                    double temp = arrayDouble[j];
                    arrayDouble[j] = arrayDouble[j + 1];
                    arrayDouble[j + 1] = temp;
                    changed = true;
                    auxNum++;
                }
            }
        }
        avrNum = auxNum / auxAvr;
        avrNum = Math.floor(avrNum*100)/100;
        return arrayDouble;
    }
}
