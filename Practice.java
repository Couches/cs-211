import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Practice
{
    public static void main(String[] args)
    {
        
    }

    public static int swapDigitPairs(int n)
    {
        int res = 0;
        int place = 1;

        while (n >= 10)
        {
            res += ((n % 10) * 10) * place;
            res += ((n / 10) % 10) * place;

            n /= 100;
            place *= 100;
        }

        res += n * place;

        return res;
    }

    public static boolean allDigitsOdd(int n)
    {
        n = Math.abs(n);

        while (n > 0)
        {
            if ((n % 10) % 2 == 0) return false;
            n /= 10;
        }

        return true;
    }

    public static boolean hasAnOddDigit(int n)
    {
        n = Math.abs(n);

        while (n > 0)
        {
            if ((n % 10) % 2 == 1) return true;
            n /= 10;
        }

        return false;
    }

    public static boolean isAllVowels(String str)
    {
        String vowels = "aeiouAEIOU";

        for (char c : str.toCharArray())
        {
            if (!vowels.contains("" + c)) return false;
        }

        return true;
    }

    public static boolean charsSorted(String str)
    {
        for (int i = 0; i < str.length() - 2; i++)
        {
            if (str.charAt(i + 1) < str.charAt(i)) return false;
        }

        return true;
    }

    public static void printBox(Scanner sc, int n)
    {
        System.out.print("+");

        for (int i = 0; i < n + 2; i++)
            System.out.print("-");

        System.out.print("+\n");

        while (sc.hasNextLine())
        {
            String line = sc.nextLine();

            System.out.print("| " + line);

            for (int i = 0; i < n - line.length(); i++)
                System.out.print(" ");

            System.out.print(" |\n");
        }

        System.out.print("+");

        for (int i = 0; i < n + 2; i++)
            System.out.print("-");

        System.out.print("+");
    }

    public static String getFileName() throws FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);

        String line = " ";
        File file = new File(line);

        while (!file.exists())
        {
            System.out.print("Type a file name: ");
            line = sc.nextLine();
            file = new File(line);
        }

        Scanner fsc = new Scanner(file);

        while (fsc.hasNextLine())
        {
            System.out.println(fsc.nextLine());
        }
        
        return line;
    }

    public static void boyGirl(Scanner sc)
    {
        int boyCount = 0;
        int boySum = 0;

        int girlCount = 0;
        int girlSum = 0;

        int difference;

        int i = 0;

        sc.next();

        while (sc.hasNextInt())
        {
            if (i % 2 == 0)
            {
                boyCount++;
                boySum += sc.nextInt();
            }
            else
            {
                girlCount++;
                girlSum += sc.nextInt();
            }

            i++;

            if (sc.hasNext()) sc.next();
        }

        difference = Math.abs(boySum - girlSum);

        System.out.printf("%d boys, %d girls\n", boyCount, girlCount);
        System.out.printf("Difference between boys' and girls' sums: %d", difference);
    }

    public static void evenNumbers(Scanner sc)
    {
        int numCount = 0;
        int sum = 0;
        int evenCount = 0;

        double evenPercent = 0;

        while (sc.hasNextInt())
        {
            int n = sc.nextInt();

            numCount++;
            sum += n;
            if (n % 2 == 0) evenCount++;
        }

        evenPercent = ((double)evenCount / numCount) * 100;

        System.out.printf("%d numbers, sum = %d\n", numCount, sum);
        System.out.printf("%d evens (%.2f%%)", evenCount, evenPercent);
    }

    public static boolean negativeSum(Scanner sc)
    {
        int sum = 0;
        int count = 0;

        while (sc.hasNextInt())
        {
            sum += sc.nextInt();
            count++;

            if (sum < 0)
            {
                System.out.printf("%d after %d steps", sum, count);
                return true;
            }
        }

        System.out.println("no negative sum");
        return false;
    }

    public static void countCoins(Scanner sc)
    {
        double sum = 0;

        while (sc.hasNextInt())
        {
            int n = sc.nextInt();
            String type = sc.next().toLowerCase();

            if (type.equals("pennies"))  sum += 0.01 * n;
            if (type.equals("nickels"))  sum += 0.05 * n;
            if (type.equals("dimes"))    sum += 0.10 * n;
            if (type.equals("quarters")) sum += 0.25 * n;
        }

        System.out.printf("Total money: $%.2f", sum);
    }

    public static void collapseSpaces(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();

            Scanner lsc = new Scanner(line);

            while (lsc.hasNext())
            {
                System.out.printf("%s ", lsc.next());
            }

            System.out.println();
        }
    }

    public static String readEntireFile(Scanner sc)
    {
        String file = "";

        while (sc.hasNextLine())
        {
            file += sc.nextLine() + "\n";
        }

        return file;
    }

    public static void flipLines(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            String line1 = sc.nextLine();
            String line2 = "";
            if (sc.hasNextLine())
            {
                line2 = sc.nextLine();
                System.out.println(line2);
            }
            
            System.out.println(line1);
        }
    }

    public static void doubleSpace(Scanner sc, PrintStream ps)
    {

        while (sc.hasNextLine())
        {
            ps.println(sc.nextLine());
            ps.println();
        }
    }

    public static void wordWrap3(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            String[] line = sc.nextLine().split(" ");
            String newLine = "";

            for (int i = 0; i < line.length; i++)
            {
                if (newLine.length() + line[i].length() <= 60)
                {
                    newLine += line[i] + " ";
                }
                else
                {
                    System.out.println(newLine);
                    newLine = line[i] + " ";
                }
            }

            System.out.println(newLine);
        }
    }

    public static void stripComments(Scanner sc)
    {
        boolean comment = false;

        while (sc.hasNextLine())
        {
            String[] line = sc.nextLine().split(" ");
            String newLine = "";
            
            for (String word : line)
            {
                if (word.equals("//")) break;
                if (word.equals("/*")) comment = true;
                if (word.equals("*/")) comment = false;

                if (!comment) newLine += word + " ";
            }

            System.out.println(newLine);
        }
    }

    public static void printDuplicates(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            int count = 1;

            String line = sc.nextLine();
            String[] words = line.trim().split("\\s+");

            String word = "";

            for (int i = 1; i < words.length; i++)
            {
                String lastWord = words[i - 1];
                String currentWord = words[i];

                word = lastWord;

                if (lastWord.equalsIgnoreCase(currentWord)) count++;
                else
                {
                    if (count > 1) System.out.print(lastWord + "*" + count + " ");
                    count = 1;
                }
            }

            if (count > 1) System.out.print(word + "*" + count + " ");

            System.out.println();
        }
    }

    public static void coinFlip(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            String[] results = sc.nextLine().toLowerCase().trim().split("\\s+");

            int headsCount = 0;
            int tailsCount = 0;

            for (String c : results)
            {
                if (c.equals("h")) headsCount++;
                else tailsCount++;
            }

            double percentage = ((double)headsCount / (headsCount + tailsCount)) * 100;
            System.out.printf("%d heads (%.1f%%)\n", headsCount, percentage);
            if (headsCount > tailsCount) System.out.println("You win!");

            System.out.println();
        }
    }

    public static int mostCommonNames(Scanner sc)
    {
        int uniqueNameCount = 0;

        while (sc.hasNextLine())
        {
            String uniqueNames = "";

            String[] names = sc.nextLine().trim().split("\\s+");
            
            String mostCommonName = "";
            int mostCommonCount = 0;

            for (int i = 0; i < names.length; i++)
            {
                String name = names[i];
                int nameCount = 0;

                for (int j = i; j < names.length; j++)
                {
                    if (names[j].equals(name))
                    {
                        nameCount++;
                    }
                }

                if (nameCount > mostCommonCount)
                {
                    mostCommonName = name;
                    mostCommonCount = nameCount;
                }
            }

            

            for (String name : names)
            {
                if (!uniqueNames.contains(name)) uniqueNames += name + " ";
            }
            
            uniqueNameCount += uniqueNames.trim().split(" ").length;

            System.out.println("Most common: " + mostCommonName);
        }

        return uniqueNameCount;
    }

    public static void inputStats(Scanner sc)
    {
        String longestLine = "";
        int i = 0;

        while (sc.hasNextLine())
        {
            i++;

            String line = sc.nextLine();
            if (line.length() > longestLine.length()) longestLine = line;

            String[] words = line.trim().split("\\s+");
            int longest = 0;
            int tokenCount = 0;
               
            for (String word : words)
            {
                longest = Math.max(longest, word.length());
                tokenCount++;
            }

            System.out.printf("Line %d has %d tokens (longest = %d)\n", 
                    i, tokenCount, longest);
        }

        System.out.println("Longest line: " + longestLine);
    }

    public static void plusScores(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            String name = sc.nextLine();
            char[] scores = sc.nextLine().toCharArray();
            int points = 0;
            
            for (char c : scores)
            {
                if (c == '+') points++;
            }

            double percent = ((double)points / scores.length) * 100;

            System.out.printf("%s: %.1f%% plus\n", name, percent);
        }
    }

    public static void leetSpeak(Scanner sc, PrintStream ps)
    {
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++)
            {
                String word = words[i];
                String newWord = "";

                for (int j = 0; j < word.length(); j++)
                {
                    char c = word.charAt(j);

                    if (c == 'o') newWord += "0";
                    else if (c == 'l') newWord += "1";
                    else if (c == 'e') newWord += "3";
                    else if (c == 'a') newWord += "4";
                    else if (c == 't') newWord += "7";
                    else if (c == 's' && j == word.length() - 1) newWord += "Z";
                    else newWord += c;
                }

                if (newWord.length() > 0) ps.printf("(%s) ", newWord);
            }

            ps.println();
        }
    }

    public static void pigLatin(Scanner sc)
    {
        String vowels = "aeiou";

        while (sc.hasNextLine())
        {
            String line = sc.nextLine().toLowerCase();
            String[] words = line.split(" ");

            for (String word : words)
            {
                if (vowels.indexOf(word.charAt(0)) != -1)
                {
                    System.out.print(word + "yay ");
                }
                else
                {
                    System.out.print(word.substring(1) + word.charAt(0) + "ay ");
                }
            }

            System.out.println();
        }
    }

    public static int max(int[] arr)
    {
        int max = arr[0];
        int maxValue = 0;

        for (int n : arr)
        {
            maxValue = Math.max(maxValue, n);
        }

        return maxValue;
    }

    public static void printElements(int[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            System.out.printf("element [%d] is %d\n", i, data[i]);
        }
    }

    public static void printBackwards(int[] arr)
    {
        for (int i = arr.length; i > 0; i--)
        {
            System.out.printf("element [%d] is %d\n", i - 1, arr[i - 1]);
        }
    }

    public static int countStrings(String[] arr, String target)
    {
        int count = 0;

        for (String str : arr)
        {
            if (str.equals(target)) count++;
        }

        return count;
    }

    public static boolean equalsStrings(String[] arr1, String[] arr2)
    {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++)
        {
            if (!arr1[i].equals(arr2[i])) return false;
        }

        return true;
    }

    public static boolean allLess(int[] arr1, int[] arr2)
    {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] >= arr2[i]) return false;
        }

        return true;
    }

    public static void swapPairs(String[] arr)
    {
        for (int i = 0; i < arr.length / 2; i++)
        {
            String temp = arr[i * 2];
            arr[i * 2] = arr[i * 2 + 1];
            arr[i * 2 + 1] = temp;
        }
    }

    public static double averageLength(String[] arr)
    {
        int sum = 0;

        for (String str : arr)
        {
            sum += str.length();
        }

        return (double)sum / arr.length;
    }

    public static boolean isPalindrome(String[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (!arr[i].equals(arr[arr.length - i - 1])) return false;
        }

        return true;
    }

    public static void rectangularArray(int[][] data)
    {
        for (int i = 0; i < data[2].length; i++)
        {
            data[2][i] = i + 1;
        }
    }

    public static void fiveByTenArray()
    {
        int[][] table = new int[5][10];

        for (int i = 0; i < table.length; i++)
        {
            for (int j = 0; j < table[i].length; j++)
            {
                table[i][j] = i * j;
            }
        }

        for (int[] arr : table)
        {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void copyColum(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][4] = matrix[i][1];
        }
    }

    public static void jaggedArray()
    {
        int[][] jagged = new int[5][];

        int count = 1;

        for (int i = 0; i < jagged.length; i++)
        {
            jagged[i] = new int[i + 1];

            for (int j = 0; j < jagged[i].length; j++)
            {
                jagged[i][j] = count;
                count++;
            }
        }
    }

    public static int lastIndexOf(int[] arr, int target)
    {
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (arr[i] == target) return i;
        }

        return -1;
    }

    public static int range(int[] arr)
    {
        int min = arr[0];
        int max = arr[0];

        for (int n : arr)
        {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return max - min;
    }

    public static int countInRange(int[] arr, int min, int max)
    {
        int count = 0;

        for (int n : arr)
        {
            if (n >= min && n <= max) count++;
        }

        return count;
    }

    public static int mode(int[] arr)
    {
        int mode = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++)
        {
            int currentCount = 0;

            for (int j = 0; j < arr.length; j++)
            {
                if (arr[i] == arr[j]) currentCount++;
            }

            if (currentCount == count && arr[i] < mode)
            {
                mode = arr[i];
            }
            else if (currentCount > count)
            {
                mode = arr[i];
                count = currentCount;
            }
        }

        return mode;
    }

    public static boolean isUnique(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[i] == arr[j] && i != j) return false;
            }
        }

        return true;
    }

    public static int longestSortedSequence(int[] arr)
    {
        if (arr.length == 0) return 0;

        int longest = 1;
        int currentCount = 1;

        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] <= arr[i + 1])
            {
                currentCount++;
            }
            else
            {
                currentCount = 1;
            }

            longest = Math.max(longest, currentCount);
        }

        return longest;
    }

    public static boolean contains(int[] arr1, int[] arr2)
    {
        for (int i = 0; i < arr1.length - arr2.length + 1; i++)
        {
            int count = 0;

            for (int j = 0; j < arr2.length; j++)
            {
                if (arr1[i + j] == arr2[j]) count++;
            }

            if (count == arr2.length) return true;
        }

        return false;
    }

    public static int[] collapse(int[] arr)
    {
        int[] collapsed = new int[(arr.length + 1) / 2];

        for (int i = 0; i < arr.length / 2; i++)
        {
            collapsed[i] = arr[i * 2] + arr[i * 2 + 1];
        }

        if (arr.length % 2 == 1) collapsed[collapsed.length - 1] = arr[arr.length - 1];

        return collapsed;
    }

    public static int[] vowelCount(String str)
    {
        String vowels = "aeiou";
        int[] vowelCount = new int[5];
        
        for (char c : str.toCharArray())
        {
            if (vowels.contains("" + c)) vowelCount[vowels.indexOf(c)]++;
        }

        return vowelCount;
    }

    public static void evenBeforeOdd(int[] arr)
    {
        int k = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k++;
            }
        }
    }

    public static int[][] matrixAdd(int[][] arr1, int[][] arr2)
    {
        int[][] empty = {};
        if (arr1.length == 0) return empty;
        int[][] sum = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++)
        {
            for (int j = 0; j < arr1[0].length; j++)
            {
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return sum;
    }

    public static boolean isMagicSquare(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++)
            if (arr.length != arr[i].length) return false;

        for (int i = 0; i < arr.length; i++)
        {
            int rowSum = 0;
            int colSum = 0;
            int diagSum1 = 0;
            int diagSum2 = 0;

            for (int j = 0; j < arr.length; j++)
            {
                rowSum += arr[i][j];
                colSum += arr[j][i];
                diagSum1 += arr[j][j];
                diagSum2 += arr[arr.length - j - 1][arr.length - j -1];
            }

            if (rowSum != colSum) return false;
            if (diagSum1 != diagSum2) return false;
            if (diagSum1 != colSum) return false;
        }

        return true;
    }

    public static int maxLength(ArrayList<String> list)
    {
        int max = 0;

        for (String str : list)
        {
            max = Math.max(str.length(), max);
        }

        return max;
    }

    public static void mystery1(ArrayList<Integer> list)
    {
        for (int i = list.size() - 1; i > 0; i--)
        {
            if (list.get(i) < list.get(i - 1)) {
                int element = list.get(i);
                list.remove(i);
                list.add(0, element);
            }
        }

        System.out.println(list.toString());
    }

    public static void mystery2(ArrayList<Integer> list)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (i % 2 == 0)
            {
                list.add(list.get(i));
            }
            else
            {
                list.add(0, list.get(i));
            }
        }

        System.out.println(list);
    }

    public static void mystery3(ArrayList<Integer> list)
    {
        for (int i = list.size() - 2; i > 0; i--)
        {
            int a = list.get(i);
            int b = list.get(i + 1);
            list.set(i, a + b);
        }

        System.out.println(list);
    }

    public static void mystery4(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            int element = list.get(i);
            list.remove(i);
            list.add(0, element + 1);
        }

        System.out.println(list);
    }

    public static void swapPairs(ArrayList<String> list)
    {
        for (int i = 0; i < list.size() / 2; i++)
        {
            String temp = list.get(i * 2);
            list.set(i * 2, list.get(i * 2 + 1));
            list.set(i * 2 + 1, temp);
        }
    }

    public static void removeEvenLength(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length() % 2 == 0)
            {
                list.remove(i);
                i--;
            }
        }
    }

    public static void doubleList(ArrayList<String> list)
    {
        int length = list.size();

        for (int i = 0; i < length; i++)
        {
            list.add(i * 2, list.get(i * 2));
        }
    }

    public static void minToFront(ArrayList<Integer> list)
    {
        int min = list.get(0);
        int index = 0;

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) < min)
            {
                min = list.get(i);
                index = i;
            }
        }

        list.remove(index);
        list.add(0, min);
    }

    public static void removeDuplicates(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            String str = list.get(i);

            for (int j = i; j < list.size(); j++)
            {
                if (list.get(j + 1).equals(str))
                {
                    list.remove(j + 1);
                }
            }
        }
    }

    public static void removeInRange(ArrayList<Integer> list, int n, int min, int max)
    {
        for (int i = min; i < max; i++)
        {
            if (list.get(i) == n)
            {
                list.remove(i);
                i--;
                max--;
            }
        }
    }

    public static void stutter(ArrayList<String> list, int n)
    {
        int length = list.size();
        n = Math.max(n, 0);

        for (int i = 0; i < length; i++)
        {
            String str = list.get(i * n);
            list.remove(i * n);

            for (int j = 0; j < n; j++)
            {
                list.add(i * n, str);
            }
        }
    }

    public static void markLength4(ArrayList<String> list)
    {
        int size = list.size();

        for (int i = 0; i < size; i++)
        {
            if (list.get(i).length() == 4) list.add(i, list.get(i));
            size++;
            i++;
        }
    }

    public static void removeShorterStrings(ArrayList<String> list)
    {
        int size = list.size();
        for (int i = 0; i < size / 2; i++)
        {
            if (list.get(i).length() <= list.get(i + 1).length())
            {
                list.remove(i);
            }
            else
            {
                list.remove(i + 1);
            }
        }
    }

    public static void filterRange(ArrayList<Integer> list, int min, int max)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (min <= list.get(i) && list.get(i) <= max)
            {
                list.remove(i);
                i--;
            }
        }
    }

    public static void interleave(ArrayList<Integer> a1, ArrayList<Integer> a2)
    {
        int size = Math.min(a1.size(), a2.size());

        for (int i = 0; i < size; i++)
        {
            a1.add(i * 2 + 1, a2.get(i));
        }

        if (a2.size() > size)
        {
            for (int i = size; i < a2.size(); i++)
            {
                a1.add(a2.get(i));
            }
        }
    }

    public static void mirror(ArrayList<String> list)
    {
        int size = list.size();

        for (int i = size - 1; i >= 0; i--)
        {
            list.add(list.get(i));
        }
    }

    public boolean checkIfExist(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if (i != j)
                {
                    if (0 <= i && j < arr.length)
                    {
                        if (arr[i] == 2 * arr[j])
                        {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean validMountainArray(int[] arr)
    {
        if (arr.length < 3) return false;

        int nextIndex = 0;

        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i + 1] <= arr[i])
            {
                nextIndex = i;
                break;
            }
        }

        if (nextIndex == 0) return false;

        for (int i = nextIndex; i < arr.length - 1; i++)
        {
            if (arr[i + 1] >= arr[i]) return false;
        }

        return true;
    }

    public int[] replaceElements(int[] arr)
    {
        int max = 0;

        for (int i = arr.length - 1; i > 0; i--)
        {
            int n = arr[i];
            arr[i] = max;
            max = Math.max(n, max);
        }

        arr[arr.length - 1] = -1;
        return arr;
    }

    public int removeDuplicates(int[] arr)
    {
        int count = 1;

        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] != arr[i + 1])
            {
                arr[count] = arr[i + 1];
                count++;
            }
        }

        arr = Arrays.copyOf(arr, count);

        return count;
    }

    public void moveZeroes(int[] arr)
    {
        int write = 0;

        for (int read = 1; read < arr.length; read++)
        {
            if (arr[write] != 0) write++;
            else 
            {
                if (arr[read] != 0)
                {
                    arr[write] = arr[read];
                    write++;
                    arr[read] = 0;
                }
            }
        }
    }

    public int[] sortArrayByParity(int[] arr)
    {
        int write = 0;

        for (int read = 1; read < arr.length; read++)
        {
            if (arr[write] % 2 == 0) write++;
            else
            {
                if (arr[read] % 2 == 0)
                {
                    int temp = arr[write];
                    arr[write] = arr[read];
                    write++;
                    arr[read] = temp;
                }
            }
        }

        return arr;
    }

    public int removeElement(int[] arr, int val)
    {
        int i = 0;
        int n = arr.length;

        while (i < n)
        {
            if (arr[i] == val)
            {
                arr[i] = arr[n - 1];
                n--;
            }
            else
            {
                i++;
            }
        }

        return n;
    }

    public int heightChecker(int[] heights)
    {
        int count = 0;

        int[] sorted =  Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorted);

        for (int i = 0; i < heights.length; i++)
        {
            if (heights[i] != sorted[i]) count++;
        }

        return count;
    }

    public List<Integer> alternate(List<Integer> list1, List<Integer> list2)
    {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < Math.max(list1.size(), list2.size()); i++)
        {
            if (i < list1.size()) result.add(list1.get(i));
            if (i < list2.size()) result.add(list2.get(i));
        }

        return result;
    }

    public void removeInRange(List<Integer> list, int n, int startIndex, int endIndex)
    {
        for (int i = startIndex; i < endIndex; i++)
        {
            if (list.get(i) == n)
            {
                list.remove(i);
                endIndex--;
                i--;
            }
        }
    }

    public int countUnique(List<Integer> list)
    {
        Set<Integer> set = new HashSet<Integer>();

        for (int n : list)
        {
            set.add(n);
        }

        return set.size();
    }

    public int countCommon(List<Integer> list1, List<Integer> list2)
    {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for (int n : list1) set1.add(n);
        for (int n : list2) set2.add(n);

        int count = 0;

        for (int n : set1) if (set2.contains(n)) count++;

        return count;
    }

    public int maxLength(Set<String> set)
    {
        int max = 0;

        for (String str : set) max = Math.max(max, str.length());

        return max;
    }

    public boolean hasOdd(Set<Integer> set)
    {
        for (int n : set) if (n % 2 == 1) return true;
        return false;
    }

    public void removeEvenLength(Set<String> set)
    {
        Iterator<String> itr = set.iterator();

        while (itr.hasNext())
        {
            String word = itr.next();

            if (word.length() % 2 == 0) itr.remove();
        }
    }

    public boolean contains3(List<String> list)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String str : list)
        {
            map.put(str, (map.get(str) == null) ? 1 : map.get(str) + 1);
            if (map.get(str) == 3) return true;
        }

        return false;
    }

    public boolean isUnique(Map<String, String> map)
    {
        Set<String> set = new HashSet<String>();

        for (String key : map.keySet())
        {
            if (set.contains(map.get(key))) return false;
            set.add(map.get(key));
        }

        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2)
    {
        Map<String, Integer> result = new HashMap<String, Integer>();

        for (String key : map1.keySet())
        {
            int value = map1.get(key);

            if (map2.get(key) != null)
            {
                if (map2.get(key) == value) result.put(key, value);
            }
        }

        return result;
    }

    public int maxOccurrences(List<Integer> list)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;

        for (int n : list)
        {
            map.put(n, (map.get(n) == null) ? 1 : map.get(n) + 1);
            max = Math.max(max, map.get(n));
        }

        return max;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map)
    {
        Map<String, Integer> result = new HashMap<String, Integer>();

        for (int key : map.keySet())
        {
            result.put(map.get(key), key);
        }

        return result;
    }

    public int rarest(Map<String, Integer> map)
    {
        Map<Integer, Integer> instances = new HashMap<Integer, Integer>();

        int rarest = Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;

        for (String key : map.keySet())
        {
            int n = map.get(key);
            instances.put(n, (instances.get(n) == null) ? 1 : instances.get(n) + 1);
        }

        for (int key : instances.keySet())
        {
            if (instances.get(key) < count)
            {
                count = instances.get(key);
                rarest = key;
            }
            else if (instances.get(key) == count)
            {
                rarest = Math.min(key, rarest);
            }
        }

        return rarest;
    }

    public Map<String, Integer> pairCounts(List<String> list)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String str : list)
        {
            for (int i = 0; i < str.length() - 1; i++)
            {
                String pair = "" + str.charAt(i) + str.charAt(i + 1);
                map.put(pair, (map.get(pair) == null) ? 1 : map.get(pair) + 1);
            }
        }

        return map;
    }

    public static void mapMystery1(Map<String, String> map)
    {
        Map<String, String> result = new TreeMap<String, String>();

        for (String key : map.keySet())
        {
            if (key.compareTo(map.get(key)) < 0)
            {
                result.put(key, map.get(key));
            }
            else
            {
                result.put(map.get(key), key);
            }
        }

        System.out.println(result);
    }

    public static void mapMystery2(Map<String, String> m)
    {
        Set<String> s = new TreeSet<String>();
        
        for (String key : m.keySet())
        {
            if (!m.get(key).equals(key))
            {
                s.add(m.get(key));
            }
            else
            {
                s.remove(m.get(key));
            }
        }

        System.out.println(s);
    }

    public int findMaxConsecutiveOnes(int[] nums)
    {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                
            }
        }

        return max;
    }

    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }

        return null;
    }

    public boolean isPalindrome(String s)
    {
        s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for (int i = 0; i < s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }

        return true;
    }

    public static BigInteger fibonacci(int n)
    {
        return new BigInteger("" + fibonacci(0, 1, 0, n));
    }

    public static int fibonacci(int prev, int curr, int i, int n)
    {
        i++;

        if (i < n) return fibonacci(curr, curr + prev, i, n);

        return curr;
    }
}