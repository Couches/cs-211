// Robert De Lappe, CS211, January 12, 2022
// Processes skyscraper boards

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Skyscraper
{
    public static int[][] skyscrapers;

    public static void main(String[] args) throws FileNotFoundException
    {
        // Send file from command line to scanner
        Scanner sc = new Scanner(new File(args[0]));
        
        // Parse, print, and validate each Skyscraper board in the file
        while (sc.hasNextLine())
        {
            skyscrapers = getSkyscrapers(sc);
            printSkyscrapers(skyscrapers);
            System.out.println((validateSkyscrapers(skyscrapers)) ? "VALID" : "NOT VALID");
        }

        System.out.println("COMPLETED PROCESSING SKYSCRAPERS");
    }

    // Print Skyscrapers
    // prints values of skyscrapers to console
    public static void printSkyscrapers(int[][] skyscrapers)
    {
        for (int[] row : skyscrapers)
        {
            for (int n : row)
            {
                // If the slot is 0, print nothing instead
                System.out.print((n == 0) ? " " : n);
            }

            System.out.println();
        }
    }

    // Get Skyscrapers
    // returns scanner input as a 6x6 array of integers
    public static int[][] getSkyscrapers(Scanner sc)
    {
        int[][] skyscrapers = new int[6][6];

        for (int i = 0; i < 6; i++)
        {
            char[] line = sc.nextLine().replaceAll("\\s+", "").toCharArray();

            for (int j = 0; j < Math.min(line.length, 6); j++)
            {
                int offset = (line.length == 4) ? 1 : 0;
                skyscrapers[i][j + offset] = line[j] - 48;
            }
        }

        return skyscrapers;
    }

    // Validate Skyscrapers
    // returns true/false based on the validity of solved skyscraper
    public static boolean validateSkyscrapers(int[][] skyscrapers)
    {
        // Check for number of visible towers based on hints
        for (int i = 1; i <= 4; i++)
        {
            int rc = 0;
            int cc = 0;
            int rh = 0;
            int ch = 0;

            for (int j = 1; j <= 4; j++)
            {
                // Count visible skyscrapers in each column and row
                if (skyscrapers[i][j] > rh)
                {
                    rh = skyscrapers[i][j];
                    rc++;
                }

                if (skyscrapers[j][i] > ch)
                {
                    ch = skyscrapers[j][i];
                    cc++;
                }
            }

            // If the number of visible skyscrapers in the rows and columns
            // doesn't match the given hints, the board is invalid
            if (rc != skyscrapers[i][0] || cc != skyscrapers[0][i])
            {
                return false;
            }
        }

        // Check for duplicate values in each column/row
        for (int i = 1; i <= 4; i++)
        {
            for (int j = 1; j <= 4; j++)
            {
                int flag = skyscrapers[i][j];

                for (int k = j + 1; k <= 4; k++)
                {
                    if (skyscrapers[i][k] == flag) return false;
                }

                flag = skyscrapers[j][i];

                for (int k = j + 1; k <= 4; k++)
                {
                    if (skyscrapers[k][i] == flag) return false;
                }
            }
        }

        return true;
    }
}