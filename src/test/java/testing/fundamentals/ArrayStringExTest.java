package testing.fundamentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayStringExTest {
    @Test
    void shouldReplaceInString() {
        //Given
        String inputText = "My name is Alex";
        String expectedResult = "My:name:is:Alex";
        ArrayStringEx arrayStringEx = new ArrayStringEx();

        //When
        arrayStringEx.changeSpaceInString(inputText);
        String actualResult = arrayStringEx.changeSpaceInString(inputText);

        //Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldAppendLenght() {
        //Given
        String input = "Characters";
        String expectedResult = "Characters10";
        ArrayStringEx arrayStringEx = new ArrayStringEx();

        //When
        String actualResult = arrayStringEx.appendsLenght(input);
        System.out.println("Actual result = " + actualResult);

        //Then
        assertEquals(expectedResult, actualResult);
       assertThat(actualResult).endsWith("10");

    }


    @Test
    void shouldReplaceEvenNumbers() {
        //Given
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] expectedArray = {1, 1, 2, 5, 3};
        ArrayStringEx arrayStringEx = new ArrayStringEx();

        //When
        int[] resultedArray = arrayStringEx.replaceEvenNumbers(array);
        //Then
        assertArrayEquals(expectedArray, resultedArray);


    }
    //Finds the position of the min element from the array (if they are multiple elements, the last position, if there aren’t => return -1)
    @Test
    void shouldFindMinElement(){
        //Given
        int[] array = {2,3,4,1,5,6};
        int expectedResult = 3;
        ArrayStringEx arrayStringEx = new ArrayStringEx();

        //When
        int actualResult = arrayStringEx.findMinPositionElement(array);

        ///Then
        assertEquals(expectedResult, actualResult);




    }
    @Test
    void shouldReturnDefaultValueForEmptyArray(){
        //Given
        int[] array = {};
        int expectedResult = -1;
        ArrayStringEx arrayStringEx = new ArrayStringEx();

        //When
        int actualResult = arrayStringEx.findMinPositionElement(array);

        //Then
        assertEquals(expectedResult, actualResult);


    }
    //Daca sunt mai multe elemente egale , sa ne returneze ultima pozitie a elementului respectiv!! - TEMA


}