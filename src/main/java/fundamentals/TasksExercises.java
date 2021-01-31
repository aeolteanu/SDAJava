package fundamentals;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class TasksExercises {
    static float pi = (float) Math.PI;
    int x = 10;
    static int y = 1;


    public static void perimeter() {


        //Write an application that will read diameter of a circle (variable of type float) and
        //calculate perimeter of given circle.
        //Firstly, assume π = 3.14. Later, use value of π from built-in Math class
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert diameter: ");
        float diameter = scanner.nextFloat();

        System.out.println("The perimeter has the following size: " + diameter * pi);
    }

    public static void ex1() {
        // Write an application that takes a positive number from the user (type int) and prints all prime numbers greater than 1 and less than the given number.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number");
        int a = scanner.nextInt();
        for (int x = 1; x < a; x++) {
            System.out.println("Prime numbers smaller than a: " + x);
        }


    }

    public static void ex2() {
        //Write an application calculating BMI (Body Mass Index) and checking if itЀs optimal or not.
        //Your application should read two variables: weight (in kilograms, type float) and height
        //(in centimeters, type int). BMI should be calculated given following formula:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your height: ");
        int height = scanner.nextInt();
        System.out.println("Insert your weight: ");
        float weight = scanner.nextFloat();
        float bmi = weight / height;
        System.out.println("Your BMI is " + bmi);
        if (bmi > 18.5 && bmi < 24.9) {
            System.out.println("Your BMI is optimal");
        } else System.out.println("Your BMI is not optimal");


    }

    public static void ex3() {
        //Write an application that takes a positive number from the user (type int) and writes all
        //numbers from 1 to the given number, each on the next line, with the following changes:
        //● in place of numbers divisible by 3, instead of a number the program should print "Fizz"
        //● in place of numbers divisible by 7, instead of a number the program should write
        //"Buzz"
        //● if the number is divisible by both 3 and 7, the program should print "Fizz buzz"
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul: ");

        int a = scanner.nextInt();
        for (int x = 1; x < a; x++) {
            if (a % 21 == 0) {
                System.out.println("FizzBuz");
            } else if (a % 3 == 0) {
                System.out.println("fizz");
            } else if (a % 7 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(" Nici un numar nu este divizibil cu 3 sau 7");

            }

        }


    }

    public static void FizzBuzz1() {
        //Write an application that takes a positive number from the user (type int) and writes all
        //numbers from 1 to the given number, each on the next line, with the following changes:
        //● in place of numbers divisible by 3, instead of a number the program should print "Fizz"
        //● in place of numbers divisible by 7, instead of a number the program should write
        //"Buzz"
        //● if the number is divisible by both 3 and 7, the program should print "Fizz buzz"
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul: ");

        int a = scanner.nextInt();
        for (int x = 1; x <= a; x++) {
            if (x % 21 == 0) {
                System.out.println("FizzBuz");
                continue;
            }
            if (x % 3 == 0) {
                System.out.println("fizz");
                continue;
            }
            if (x % 7 == 0) {
                System.out.println("buzz");
                continue;
            }

        }
    }


    public static void tooMuchTooLittle() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int a = random.nextInt(10);
        System.out.println("Your number is " + a);
        int b = scanner.nextInt();
        do {
            if (b < a) {
                System.out.println("Not enough!");
            } else if (b > a) {
                System.out.println("Too much!");
            } else System.out.println("Congrulations");
        } while (b == a);

    }
    //write an application that takes a positive number from the user
    //and prints all prime numbers than 1 and less than given number

    public static void printAllPrimeNumbers() {
        System.out.println("Type a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= 1) {
            System.out.println("The number is not greater than 1");
            return;
        }
        for (int i = 2; i < number; i++) {
            if (isPrime(i)) {
                System.out.println(i);


            }
        }

    }

    private static boolean isPrime(int nr) {
        for (int i = 2; i < nr / 2; i++) {
            int rest = nr % i;
            if (rest == 0) {
                return false;


            }
        }
        return true;
    }

    private static boolean isPrime1(int nr) {
        boolean isPrimeNo = true;
        for (int i = 2; i < nr / 2; i++) {
            if (nr % i == 0) {
                isPrimeNo = false;
                break;

            }
        }

        return isPrimeNo;

    }

    private static boolean isPrime3(int nr) {
        if (nr == 2) {
            return true;
        }
        if (nr == 0 || nr == 1 || nr % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= nr; i += 2) {
            if (nr % i == 0) {
                return false;

            }
        }
        return true;
    }


    private static boolean isPrime2(int nr) {
        boolean isPrimeNo = true;
        for (int i = 2; i < nr / 2; i++) {
            if (nr % i != 0) {
                continue;

            }
            isPrimeNo = false;
            break;

        }

        return isPrimeNo;


    }
    //Write an application that will read texts (variables of the String type) until the user gives the text "Enough!"
    // and then writes the longest of the given texts (not including the text "Enough!").
    // If the user does not provide any text, write "No text provided".

    public static void longestWord() {
        System.out.println("Type your word: ");
        Scanner scanner = new Scanner(System.in);
        String word = "";
        String longestWord1 = "";
        do {
            word = scanner.next();
            if (!word.equals("Enough") && longestWord1.length() < word.length()) {
                longestWord1 = word;
            }
        } while (!word.equals("Enough"));
        if (longestWord1.length() == 0) {
            System.out.println("No text provided");
            return;
        }
        System.out.println("Longest word is: " + longestWord1);
    }

    public static void longestWord2() {
        System.out.println("Type your word: ");
        Scanner scanner = new Scanner(System.in);
        String word = "";
        String longestWord1 = "";
        while (!word.equals("Enough")) {
            if (longestWord1.length() < word.length()) {
                longestWord1 = word;
            }
            word = scanner.next();
        }
        if (longestWord1.length() == 0) {
            System.out.println("No text provided");
            return;
        }
        System.out.println("Longest word is: " + longestWord1);
    }

    public static void stutters() {
        //Write an application that "stutters", that is, reads the user's text (type String), and prints
        //the given text, in which each word is printed twice.
        //For example, for the input: "This is my test" the application should print "This This is is
        //my my test test".

        Scanner scan = new Scanner(System.in);
        System.out.print("Type your word: ");

        String text = scan.nextLine();
        String[] words = text.split(" ");

        System.out.print("Stutter: ");

        for (int i = 0; i < words.length - 1; i++) {
            System.out.print(words[i] + " " + words[i] + " ");
        }
        System.out.print(words[words.length - 1] + " " + words[words.length - 1]);
    }


    public static void testStrings() {
        String s1 = "abc", s2 = "abc", s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));


    }

    public void testObjects() {
        Dog dog1 = new Dog("Azorel");
//        dog1.setName("Azorel");

        Dog dog2 = new Dog("Azorel");
//        dog2.setName("Azorel");

        System.out.println(dog1 == dog2);
        System.out.println(dog1.equals(dog2));
//        System.out.println(dog1.getName().equals(dog2.getName()));

    }


}





