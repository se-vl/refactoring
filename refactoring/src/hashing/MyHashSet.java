package hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet
{
    private List<List<String>> _buckets;
    private int _size;
    private Logger _logger;

    public static final int INITIAL_NUMBER_OF_BUCKETS = 10;

    public MyHashSet()
    {
        _buckets = new ArrayList<List<String>>(INITIAL_NUMBER_OF_BUCKETS);
        for (int i = 0; i < INITIAL_NUMBER_OF_BUCKETS; ++i)
        {
            _buckets.add(new LinkedList<String>());
        }
        _logger = null;
    }

    private int numberOfBuckets()
    {
        return _buckets.size();
    }

    public void setLogger(Logger logger)
    {
        _logger = logger;
    }

    public int size()
    {
        return _size;
    }

    private List<String> bucketOf(String element)
    {
        int hash = element.hashCode();
        int index = Math.abs(hash) % numberOfBuckets();
        return _buckets.get(index);
    }

    public boolean contains(String element)
    {
        if (_logger != null)
        {
            _logger.log(this + " contains " + element);
        }

        return bucketOf(element).contains(element);
    }

    public boolean add(String element)
    {
        if (_logger != null)
        {
            _logger.log(this + " add " + element);
        }

        List<String> list = bucketOf(element);

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

        List<String> list = bucketOf(element);

        if (!list.contains(element)) return false;

        list.remove(element);
        --_size;
        return true;
    }
}
