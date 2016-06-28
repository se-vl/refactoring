package hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet
{
    private List<List<String>> _buckets;
    private int _size;
    private Logger _logger;

    public MyHashSet()
    {
        _buckets = new ArrayList<List<String>>(10);
        for (int i = 0; i < 10; ++i)
        {
            _buckets.add(new LinkedList<String>());
        }
        _logger = null;
    }

    public void setLogger(Logger logger)
    {
        _logger = logger;
    }

    public int size()
    {
        return _size;
    }

    public boolean contains(String element)
    {
        if (_logger != null)
        {
            _logger.log(this + " contains " + element);
        }

        int hash = element.hashCode();
        int index = Math.abs(hash) % 10;
        List<String> list = _buckets.get(index);

        return list.contains(element);
    }

    public boolean add(String element)
    {
        if (_logger != null)
        {
            _logger.log(this + " add " + element);
        }

        int hash = element.hashCode();
        int index = Math.abs(hash) % 10;
        List<String> list = _buckets.get(index);

        if (list.contains(element)) return false;

        list.add(element);
        ++_size;
        return true;
    }

    public boolean remove(String element)
    {
        if (_logger != null)
        {
            _logger.log(this + " remove " + element);
        }

        int hash = element.hashCode();
        int index = Math.abs(hash) % 10;
        List<String> list = _buckets.get(index);

        if (!list.contains(element)) return false;

        list.remove(element);
        --_size;
        return true;
    }

    public static boolean isDigit(int x)
    {
        return x >= 0 && x < 10;
    }
}
