package com.tiennln.itwcdg;

/**
 * @author TienNLN on 18/01/2023
 */
import java.util.*;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {

        Collection<Integer> resultNumbers = new ArrayList<>();

        numbers.forEach(number -> {
            if (!(Collections.frequency(numbers, number) > 1)) {
                resultNumbers.add(number);
            }
        });

        return resultNumbers;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}