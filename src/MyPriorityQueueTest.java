import org.junit.Test;

import static org.junit.Assert.*;

public class MyPriorityQueueTest {


    @Test
    public void queue() {
        MyPriorityQueue<Integer> test = new MyPriorityQueue<>(8);
        assertTrue(test.isEmpty());
        test.offer(88);
        test.offer(300);
        assertEquals(new Integer(300), test.poll());
        assertEquals(new Integer(88), test.peek());
        test.offer(-9);
        test.offer(10);
        test.offer(400);
        assertEquals(new Integer(400), test.poll());
        assertFalse(test.isEmpty());
        assertEquals(new Integer(88), test.poll());
        assertEquals(new Integer(10), test.poll());
        test.clear();
        assertTrue(test.isEmpty());
    }
}