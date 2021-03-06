package fundamentals;

import java.util.Arrays;
import java.util.Scanner;


public class ArrayExercises {
    public static void findMaxProduct() {
        int[] numbers = {2, 7, 5, 3, 10, 5, -8, -5};
        ;
        int maxPairProduct = Integer.MIN_VALUE;
        int maxA = -1, maxB = -1;

        for (int a = 0; a < numbers.length - 1; a++) {
            for (int b = a + 1; b < numbers.length; b++) {
                if (maxPairProduct < numbers[a] * numbers[b]) {
                    maxPairProduct = numbers[a] * numbers[b];
                    maxA = a;
                    maxB = b;
                }
            }
        }

        System.out.println("Pair is (" + numbers[maxA] + ", " + numbers[maxB] + "), Maximum Product: " + (numbers[maxA] * numbers[maxB]));
    }

    public static void removeElement() {
        Scanner scanner = new Scanner(System.in);
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("My array is : " + Arrays.toString(myArray));

        System.out.println("The number you want to remove is: ");

        int removeIndex = scanner.nextInt();

        for (int i = removeIndex; i < myArray.length - 1; i++) {
            myArray[i] = myArray[i + 1];

        }
        System.out.println("My array without removed element is: " + Arrays.toString(myArray));

    }

    public static void maxArrayNumber() {
        int[] myArray = {1, 2, 3, 4, 5};
        int max = myArray[0];

//        for(int i = 0; i<=myArray.length-1;i=i+2){
//            if (myArray[i]>max){
//                max=myArray[i];
//            }
//            if (myArray[i] > myArray[i + 1]) {
//                if (myArray[i] > max) max = myArray[i];
//            }
//            if (myArray[i] < myArray[i + 1]) {
//                if (myArray[i + 1] > max) max = myArray[i + 1];
//            }
//
//
//        }
//        System.out.println(" Original Array: "+Arrays.toString(myArray));
//        System.out.println(" Maximum value for the above array = " + myArray);
//
//
//
//    }

    }

    public static void duplicateElement() {
        String[] myArray = {"dog", "cat", "phone", "mouse", "dog", "keyboard"};

        for (int i = 0; i < myArray.length-1 ; i++) {
            for (int j = i+1; j < myArray.length; j++)
                if (myArray[i].equals(myArray[j]) && (i != j)) {
                    System.out.println("Duplicate element is : " + myArray[j]);
                }
        }

    }

}


