package org.example;

import org.junit.Test;

import static org.example.StringCalculator.add;
import static org.junit.Assert.assertEquals;


public class StringCalculatorShould
{

    @Test
    public void should_return_single_value() throws Exception {
        assertEquals(0, add(""));
        assertEquals(4, add("4"));
        assertEquals(7, add("7"));
    }

    @Test
    public void should_return_sum_of_multiple_values_divided_by_commas() throws Exception {
        assertEquals(3, add("1,2"));
        assertEquals(4, add("2,2"));
        assertEquals(45, add("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    public void should_return_sum_when_new_line_separator_is_used() throws Exception {
        assertEquals(6, add("1\n2,3"));
        assertEquals(8, add("1\n2,3\n2"));

    }

    @Test
    public void should_return_sum_when_using_custom_seperator() throws Exception {
        assertEquals(3, add("//;\n1;2"));
        assertEquals(4, add("//X\n2X2"));
    }

    @Test
    public void should_return_sum_while_ignoring_numbers_greater_than_1000() throws Exception {
        assertEquals(2, add("1001,2"));
        assertEquals(5, add("2055,5"));
    }


    @Test
    public void should_throw_error_on_negative_input() throws Exception {
        try {
            add("-1");
        }
        catch (Exception e) {
            final String expected = "negatives not allowed: -1";
            assertEquals( expected, e.getMessage());
        }

        try {
            add("-2");
        }
        catch (Exception e) {
            final String expected = "negatives not allowed: -2";
            assertEquals( expected, e.getMessage());
        }

        try {
            add("-1,-2");
        }
        catch (Exception e) {
            final String expected = "negatives not allowed: -1,-2";
            assertEquals( expected, e.getMessage());
        }
        try {
            add("-1,-2,-5,10");
        }
        catch (Exception e) {
            final String expected = "negatives not allowed: -1,-2,-5";
            assertEquals( expected, e.getMessage());
        }
    }
}
