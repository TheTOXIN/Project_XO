package com.thetoxin.xo.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDate {

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

    public static int inputSizeField() {
        int sizeField;
        while(true) {
            try {
                sizeField = Integer.parseInt(reader.readLine());
                if (sizeField < 3) {
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
}
