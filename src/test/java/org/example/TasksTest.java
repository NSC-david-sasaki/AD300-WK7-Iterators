package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
class TasksTest {

    private Tasks tasks;

    @BeforeEach
    void setUp() {
        tasks = new Tasks();
    }

    @AfterEach
    void tearDown() {
        tasks = null;
        System.gc();
    }

    @Test
    void task1() {
        // Arrange
        Tasks task = new Tasks();
        Random mockRandom = Mockito.mock(Random.class);

        // Define predictable return values for random.nextInt()
        Mockito.when(mockRandom.nextInt()).thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Act
        String result = task.task1(mockRandom);

        // Assert
        String expected = "Total sum is : 55\nFinal list: [null]";
        Assertions.assertEquals(expected, result);
    }
    @Test
    void task2() {
        String result = tasks.task2();
        assertEquals("Key: Theater, Value: 10\n" +
                "After decrement using .setValue Key: Theater, Value: 9\n" +
                "Before removal: {Theater=9, TV=2, Music=4, Movies=8, Books=12}\n" +
                "After removal of last element {TV=2, Music=4, Movies=8, Books=12}\n" +
                "Key: TV, Value: 2\n" +
                "After decrement using .setValue Key: TV, Value: 1\n" +
                "Before removal: {TV=1, Music=4, Movies=8, Books=12}\n" +
                "After removal of last element {Music=4, Movies=8, Books=12}\n" +
                "Key: Music, Value: 4\n" +
                "After decrement using .setValue Key: Music, Value: 3\n" +
                "Before removal: {Music=3, Movies=8, Books=12}\n" +
                "After removal of last element {Movies=8, Books=12}\n" +
                "Key: Movies, Value: 8\n" +
                "After decrement using .setValue Key: Movies, Value: 7\n" +
                "Before removal: {Movies=7, Books=12}\n" +
                "After removal of last element {Books=12}\n" +
                "Key: Books, Value: 12\n" +
                "After decrement using .setValue Key: Books, Value: 11\n" +
                "Before removal: {Books=11}\n" +
                "After removal of last element {}\n",result);
    }

    @Test
    void task3() {
        assertEquals("No value found for key: November\n" +
                "Highest temp was in: [April, May] with temp of: 68.3\n" +
                "Lowest temp was in: [February] with temp of: -28.0\n", tasks.task3());
    }
}
