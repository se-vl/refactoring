package hashing;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyHashSetTest
{
    private MyHashSet set = new MyHashSet();

    @Test
    public void newSetIsEmpty()
    {
        assertEquals(0, set.size());
    }

    @Test
    public void addFunny()
    {
        set.add("hochenwiseler");
        assertEquals(1, set.size());
        assertTrue(set.contains("hochenwiseler"));
    }

    @Test
    public void addOneElement()
    {
        set.add("hello");
        assertEquals(1, set.size());
        assertTrue(set.contains("hello"));
        assertFalse(set.contains("world"));
    }

    @Test
    public void addTwoElements()
    {
        set.add("hello");
        set.add("world");
        assertEquals(2, set.size());
        assertTrue(set.contains("hello"));
        assertTrue(set.contains("world"));
    }

    @Test
    public void addTheSameElementTwice()
    {
        set.add("hello");
        set.add("hello");
        assertEquals(1, set.size());
    }

    @Test
    public void removeOneElement()
    {
        set.add("hello");
        assertEquals(1, set.size());

        set.remove("hello");
        assertFalse(set.contains("hello"));
        assertEquals(0, set.size());
    }

    @Test
    public void removeTheSameElementTwice()
    {
        set.add("hello");
        set.remove("hello");
        set.remove("hello");
        assertEquals(0, set.size());
    }

    @Test
    public void addTheSameElementTwiceAndThenRemoveIt()
    {
        set.add("hello");
        set.add("hello");
        assertEquals(1, set.size());

        set.remove("hello");
        assertFalse(set.contains("hello"));
        assertEquals(0, set.size());
    }
}
