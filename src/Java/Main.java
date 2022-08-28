package Java;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static double wordSum = 0;
    static double charSum = 0;
    public static void main(String[] args) throws IOException {
        //1
        int[] array = {95, 98};
        ArrayList<Integer> list = new ArrayList();
        Arrays.sort(array);
        int numbersArrayIndex = 0;
        for (int i = array[0]; i < array[array.length - 1]; i++) {
            if (i == array[numbersArrayIndex]) {
                numbersArrayIndex++;
            } else {
                list.add(i);
            }
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++)
            sum += list.get(i);
        System.out.println(sum);

        //2
        int[] arr1 = {1,3,4};
        int[] arr2 = {1,2,6};
        boolean forArr1 = isArraySorted(arr1);
        boolean forArr2 = isArraySorted(arr2);
        if ((forArr1 == false) || (forArr2 == false)) throw new RuntimeException("arrays are not sorted!");
            int[] arr3 = new int[arr1.length+arr2.length];
            System.out.println(arr3.length);
            arr3 = concatenate(arr1, arr2);
            sort(arr3);
            System.out.println(Arrays.toString(arr3));

        //3
        int[] arrayRating = {55, 67, 98, 115, 61};
        int sumRating = 0;
        for (int i = 0; i < arrayRating.length; i++) {
            sumRating = sumRating + arrayRating[i];
        }
        int a = 5;
        int b = 4;
        int c = 3;
        int d = 2;
        int e = 1;
        int aRating = arrayRating[4]*a;
        int bRating = arrayRating[3]*b;
        int cRating = arrayRating[2]*c;
        int dRating = arrayRating[1]*d;
        int eRating = arrayRating[0]*e;
        double sumCount = aRating+bRating+cRating+dRating+eRating;
        double avgRating = sumCount/sumRating;
        avgRating = avgRating*100;
        avgRating = (double)((int) avgRating);
        avgRating = avgRating /100;
        String aRatingString = "*****";
        String bRatingString = "****";
        String cRatingString = "***";
        String dRatingString = "**";
        String eRatingString = "*";
        if(avgRating >= 4.51){
            System.out.println(avgRating + " " + aRatingString);
        }
        if (avgRating >= 3.51 && avgRating <= 4.50){
            System.out.println(avgRating + " " + bRatingString);
        }
        if (avgRating >= 2.51 && avgRating <= 3.50){
            System.out.println(avgRating + " " + cRatingString);
        }
        if (avgRating >= 1.51 && avgRating <= 2.50){
            System.out.println(avgRating + " " + dRatingString);
        }
        if (avgRating >= 0 && avgRating <= 1.50){
            System.out.println(avgRating + " " + eRatingString);
        }

        //4
        numWords();
    }

    //2
    public static <T> T concatenate(T a, T b) {
        if (!a.getClass().isArray() || !b.getClass().isArray()) {
            throw new IllegalArgumentException();
        }

        Class<?> resCompType;
        Class<?> aCompType = a.getClass().getComponentType();
        Class<?> bCompType = b.getClass().getComponentType();

        if (aCompType.isAssignableFrom(bCompType)) {
            resCompType = aCompType;
        } else if (bCompType.isAssignableFrom(aCompType)) {
            resCompType = bCompType;
        } else {
            throw new IllegalArgumentException();
        }

        int aLen = Array.getLength(a);
        int bLen = Array.getLength(b);

        @SuppressWarnings("unchecked")
        T result = (T) Array.newInstance(resCompType, aLen + bLen);
        System.arraycopy(a, 0, result, 0, aLen);
        System.arraycopy(b, 0, result, aLen, bLen);

        return result;
    }

    //2
    public static void sort(int[] array) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
        }
    public static boolean isArraySorted(int arr[]) {
        for(int i=0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    //4
    public static void numWords() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(inputStreamReader);
        while(true){
            String str = bufferedReader.readLine();
            if(str.equals("end")){
                break;
            }
            System.out.println(str);
            double result = getAverageCharLength(str);
            DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
            String str2 = decimalFormat.format(result);
            System.out.println(str2);
        }
    }
    public static double getAverageCharLength(String str) {
        String strAround = str.replaceAll("(?u)[^\\pL ]","");
        String words[] = strAround.split(" ");
        double numWords = words.length;
        double totalCharacters = 0;
        for(int i = 0; i < numWords; i++)
            totalCharacters = totalCharacters + words[i].length();
        wordSum = wordSum + numWords;
        charSum = charSum + totalCharacters;
        return charSum/wordSum;
    }
}
