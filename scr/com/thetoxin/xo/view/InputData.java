package com.thetoxin.xo.view;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputData {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String inputPlayerName() {
        String text = "";
        try {
            text = reader.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static String inputPlayerNameWV(String figure) {
        String text = "";
        text = JOptionPane.showInputDialog(null, "Input player name" + figure);
        return text;
    }

    public static int inputSizeField() {
        int sizeField;
        while(true) {
            try {
                sizeField = Integer.parseInt(reader.readLine());
                if (sizeField < 3 || sizeField > 100) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e ) {
                System.out.println("Try again...");
            } catch (IOException e) {
                System.out.println("Try again...");
            }
        }
        return sizeField;
    }

    public static int inputSizeFieldWV() {
        int sizeField;
        String tmp;
        while(true) {
            try {
                tmp = JOptionPane.showInputDialog(null, "Input size field");
                sizeField = Integer.parseInt(tmp);
                if (sizeField < 3 || sizeField > 100) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e ) {
                JOptionPane.showMessageDialog(null, "Please input try again");
            }
        }
        return sizeField;
    }
}
