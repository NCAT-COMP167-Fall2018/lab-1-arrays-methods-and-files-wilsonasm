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
        String file="playerData2.txt";
        
        /*declaration, instatiation (new), and initialization
        = new (instatiation)
        
        */
        readData(names, scores, file);
        averageHS(scores);
        selectionSort(names,scores,scores.length);
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
    }
    public static void displayData(String []names, int[] scores)
    {
        for (int i=0;i<names.length;i++)
        {
            String str1=String.format("%10s ",names[i]);
            String str2=String.format("%10d ",scores[i]);
            System.out.println(str1+ " " +str2);
        }
    }
        public static void displayData(String []names, int[] scores,int sizes)
        {
            for (int i=0;i<sizes;i++)
            {
                String str1=String.format("%10s ",names[i]);
                String str2=String.format("%10d ",scores[i]);
                System.out.println(str1+ " " +str2);
            }
        }
    public static void averageHS(int[] scores)
    {
        double avg;
        double total = 0;
        for (int i=0; i<scores.length;i++)
        {
            total+=scores[i];
        }
        avg= total/scores.length;
        System.out.println(" average is: "+avg);
    }
    public static void selectionSort(String[] names,int[] scores, int n)
    {
        int tempScores=scores[0];
        String tempNames=names[0];

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIdx=i;
            for (int j = i+1; j < n; j++)
            {
              if (scores[j] > scores[minIdx])
              {
                minIdx = j;
              }
              tempScores=scores[minIdx];
              tempNames=names[minIdx];
              scores[minIdx]=scores[i];
              names[minIdx]=names[i];
              scores[i]=tempScores;
              names[i]=tempNames;
            }
            

        }
        System.out.println("Sorted List: ");
        displayData(names,scores,10);
    }
}
