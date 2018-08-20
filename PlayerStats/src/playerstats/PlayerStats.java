/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerstats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marku
 */
public class PlayerStats 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] names = new String[80];
        int[] scores = new int[80];
        
        /*declaration, instatiation (new), and initialization
        = new (instatiation)
        
        */
        readData(names, scores, args[0]);
    }
    public static void readData(String[] names, int[] scores, String filename)
    {
        
        try 
        {
            Scanner reader= new Scanner(new File(filename)); //make a scanner to read file
            
            int currentIndex=0;
            while(reader.hasNext())
            {
                String[] line = reader.nextLine().split(" ");                
               
                names[currentIndex]=line[0];
                
                scores[currentIndex]=Integer.parseInt(line[1]);
                
                
                currentIndex++;
            }
            
        }
        catch (FileNotFoundException ex) {
           System.err.println("Unable to read file");
        }
        displayData(names, scores);
        System.out.println(average(scores));
        
        
    }
    public static void displayData(String []names, int[] scores)
    {
        for (int i=0;i<names.length+1;i++)
        {
            String str1=String.format("%10s ",names[i]);
            String str2=String.format("%10d ",scores[i]);
            System.out.println(str1+ " " +str2);
        }
    }
    public static double average(int[] scores)
    {
        double ave;
        int total = 0;
        for (int i=0; i<scores.length+1;i++)
        {
            total=scores[i]++;
        }
        ave= total/scores.length;
        return ave;
    }
    
}
