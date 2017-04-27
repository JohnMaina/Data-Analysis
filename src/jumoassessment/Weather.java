/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumoassessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Maina
 */
public class Weather {

    private final String fileName;

    //constructor
    public Weather(String filename) {
        this.fileName = filename;
    }

    /**
     * Read the needed content of the file.
     */
    public void readDataFromFile() {

        //Using bufferedReader to enhance performance
        BufferedReader br = null;
        InputStream inputstream = null;

        // integer arrays to store the readings
        int[] maximumTemperatureInt = new int[30];
        int[] minimumTemperatureInt = new int[30];

        try {
            String sCurrentLine;
            inputstream = new FileInputStream(new File(fileName));

            //Specify UTF-8 encoding since some platforms might have other default encoding
            br = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));

            //read each line from the file and process it
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                //don't process the first two lines since we don't need them
                if (i >= 2) {
                    //To get each cell, split the current line to an array of strings.
                    //This will enable us to get the columns
                    String[] arr = sCurrentLine.split(" ");
                    // System.out.println("line " + (i + 1) + ": " + Arrays.toString(arr));
                    /**
                     * Extracting the max and min temperature columns and putting them in a temporay string variable,
                     * then convert them to integer values
                     * The min and max cells are not at the same position in each row,
                     * so we need to vary the position.
                     */
                    //Temporay strings to store the current reading 
                    String maximumTemperatureS="";
                     String minimumTemperatureS="";
                    if (i <= 10) {
                        maximumTemperatureS=arr[5];
                        minimumTemperatureS=arr[9];

                    } else if (i >= 11 && i <= 31) {
                          maximumTemperatureS=arr[4];
                        if (i == 27) {
                             minimumTemperatureS=arr[7];
                        } else {
                             minimumTemperatureS=arr[8];
                        }
                    }
                    
                    //Now convert the arrays to integer arrays
                    //some cells contain * in adition to the integer, so we use a reqular expression to take numbers only.
                    if (i<31){                   
                     maximumTemperatureS =maximumTemperatureS.replaceAll("[^0-9]", "");
                    maximumTemperatureInt[i - 2] = Integer.parseInt(maximumTemperatureS);
                    minimumTemperatureS = minimumTemperatureS.replaceAll("[^0-9]", "");
                    minimumTemperatureInt[i - 2] = Integer.parseInt(minimumTemperatureS);
                    }
                }
                i++;
            }
//            System.out.println("MAX = " + Arrays.toString(maximumTemperature));
//            System.out.println("MIN = " + Arrays.toString(minimumTemperature));
//            System.out.println("Max Int = " + Arrays.toString(maximumTemperatureInt));
//            System.out.println("Min Int = " + Arrays.toString(minimumTemperatureInt));

            //now pass the two arrays to a method that calculates the largest spread
            getLargestSpread(minimumTemperatureInt, maximumTemperatureInt);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (inputstream != null) {
                    inputstream.close();
                }
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    /**
     * @param minT- Minimum temperature array
     * @param maxT- Maximum temperature array 
     * calculates the largest spread,
     * where spread=maximumTemperature-minimumTemperature
     */
    public void getLargestSpread(int minT[], int maxT[]) {
        int largestSpread = 0;
        int dayWithLargestSpread = 1;

        //minT and maxT have equal length
        for (int i = 0; i < minT.length; i++) {
            int spread = maxT[i] - minT[i];
            if (spread > largestSpread) {
                largestSpread = spread;

                /**
                 * The arrays have 30 items each corresponding to it's day, and
                 * i starts from zero; so item[i] belongs to day i+1
                 */
                dayWithLargestSpread = i + 1;
            }
        }

        //print the result
        System.out.println(dayWithLargestSpread + "\t" + largestSpread);
    }

}
