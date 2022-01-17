package org.example;

import org.junit.Test;

import static org.example.StringCalculator.add;
import static org.junit.Assert.assertEquals;


public class StringCalculatorShould
{

    @Test
    public void should_return_single_value()
    {
        assertEquals(0, add(""));
        assertEquals(4, add("4"));
        assertEquals(7, add("7"));
    }

    @Test
    public void should_return_sum_of_multiple_values_divided_by_commas(){
        assertEquals(3, add("1,2"));
        assertEquals(4, add("2,2"));
        assertEquals(45, add("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    public void should_return_sum_when_new_line_separator_is_used(){
        assertEquals(6, add("1\n2,3"));
        assertEquals(8, add("1\n2,3\n2"));

    }


}
