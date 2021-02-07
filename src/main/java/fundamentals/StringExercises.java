package fundamentals;

import java.util.Scanner;

public class StringExercises {
    public static void printGivenIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Original string is: ");
        String myString = scanner.next();
        System.out.println("Type first index : ");
        int index1 = myString.charAt(scanner.nextInt());
        System.out.println("Type second index: ");
        int index2 = myString.charAt(scanner.nextInt());

        System.out.println("The character at first given position is:" + (char) index1);
        System.out.println("The character at second given position is:" + (char) index2);


    }

    public static void givenStringContains() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the original String: ");
        String string1 = scanner.next();
        System.out.println("Type the char value you want to verify: ");
        String string2 = scanner.next();
        System.out.println("Original string: " + string1);
        System.out.println("Sequence of char value: " + string2);
        System.out.println(string1.contains(string2));

    }

    public static void replaceWithAnotherString() {
        String string = "My name is Alex";
        String replacedString = string.replace("Alex", "Eduard");

        System.out.println("The original String is : " + string);
        System.out.println("The changed String is : " + replacedString);

    }

    //    public static void firstLetterUppercase(){
//        String string = "alex";
//        char upperString = Character.toUpperCase(string.charAt(0));
//
//
//        System.out.println(upperString);
//
//
//    }NU AM REUSIT !
    public static void compareStrings() {
        String string1 = "Dog";
        String string2 = "Dog";

        System.out.println("First string is: " + string1);
        System.out.println("Second string is : " + string2);


        if (string1.chars().equals(string2.chars())) {
            System.out.println(string1 + " " + "is equal to " + " " + string2);


        }else
            System.out.println("String1 not equals String2");
    }


}
