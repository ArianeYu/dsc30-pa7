import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;


public class dHeapTester {

    dHeap<Integer> heap1;
    dHeap<Character> heap2;
    dHeap<Integer> heap3;

    @Before
    public void setUp() throws Exception {
        heap1 = new dHeap<>();
        heap3 = new dHeap<>(3, 3, false);
    }

    @Test
    public void testHeap1() {
        assertEquals(0, heap1.size());
        heap1.add(88);
        heap1.add(100);
        heap1.add(50);
        heap1.add(77);
        heap1.add(56);
        heap1.add(-90);
        heap1.add(120);
        heap1.add(300);
        assertEquals(new Integer(300), heap1.element());
        heap1.remove();
        assertEquals(new Integer(120), heap1.element());
        heap1.remove();
        assertEquals(new Integer(100), heap1.element());
        heap1.remove();
        assertEquals(new Integer(88), heap1.element());
        assertEquals(5, heap1.size());
        heap1.remove();
        assertEquals(new Integer(77), heap1.element());
        heap1.remove();
        assertEquals(new Integer(56), heap1.element());
        heap1.remove();
        assertEquals(new Integer(50), heap1.element());
        heap1.remove();
        assertEquals(new Integer(-90), heap1.element());
        heap1.add(83);
        heap1.add(83);
        heap1.add(83);
        assertEquals(new Integer(83), heap1.element());
        assertEquals(4, heap1.size());
        heap1.clear();
        assertEquals(0, heap1.size());
    }

    @Test
    public void testHeap2() {
        heap2 = new dHeap<>(4, 4, true);
        heap2.add('a');
        heap2.add('c');
        heap2.add('m');
        heap2.add('m');
        heap2.add('p');
        heap2.add('o');
        heap2.add('y');
        heap2.add('z');
        heap2.add('b');
        heap2.add('h');
        assertEquals(new Character('z'), heap2.element());
        heap2.remove();
        assertEquals(new Character('y'), heap2.element());
        heap2.remove();
        assertEquals(new Character('p'), heap2.element());
        heap2.remove();
        assertEquals(new Character('o'), heap2.element());
        heap2.remove();
        assertEquals(new Character('m'), heap2.element());
        heap2.remove();
        assertEquals(new Character('m'), heap2.element());
        heap2.remove();
        assertEquals(new Character('h'), heap2.element());
        assertEquals(4, heap2.size());
        heap2.clear();
        assertEquals(0, heap2.size());
    }

    @Test
    public void testHeap3() {
        heap3.add(70);
        heap3.add(200);
        assertEquals(new Integer(70), heap3.element());
        heap3.add(-294);
        assertEquals(new Integer(-294), heap3.element());
        heap3.add(20);
        heap3.remove();
        assertEquals(new Integer(20), heap3.element());
        heap3.clear();
        assertEquals(0, heap3.size());
    }

    @Test (expected = NullPointerException.class)
    public void NPE1() {
        heap2.add(null);
    }

    @Test (expected = NoSuchElementException.class)
    public void NSEE1() {
        heap3.remove();
    }

    @Test (expected = NoSuchElementException.class)
    public void NSEE2() {
        heap3.element();
    }

}