package testing.fundamentals;
//Write and test a program that:
//Replaces all the spaces in a text with “:”
//Ads in a text, after every “a” letter the length of the text read until then.
//Appends to the end of the text the number of “z” letters found in the text
//Replaces all the even number in an array with their half
//Specifies if the array contains elements that fit inside a number interval
//Finds the position of the min element from the array (if they are multiple elements, the last position, if there aren’t => return -1)


public class ArrayStringEx {
    public String changeSpaceInString(String text) {

        String textChanged;
        //1.Apply split on string and concatenate words with ":"
        //2.Iterate over the string until ' ' and then add ':' in a new string
        //3.Iterate over string and change the string directly
        //4.use replace
//        System.out.println(text);
//        textChanged=text.replace(' ', ':');
//        System.out.println(textChanged);


        return text.replace(' ', ':');

    }

    ////Ads in a text, after every “a” letter the length of the text read until then.
    public String insertLenghtAfterLetterA(String text) {
        return "";


    }

    public String appendsLenght(String text) {
        return text + text.length();

    }

    public int[] replaceEvenNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = array[i] / 2;


            }

        }
        return array;

    }

    //Finds the position of the min element from the array (if they are multiple elements, the last position, if there aren’t => return -1)
    public int findMinPositionElement(int[] array) {
        //int min= Integer.MAX_VALUE;
        //int[] a = {1, 99999,1100}
        //int min = 00;1
        if (array.length == 0 ){
            return -1;
        }

        int min = array[0];
        int position = 0;



        for (int i = 1; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
                position = i;

            }
        }
        return position;
    }
}
