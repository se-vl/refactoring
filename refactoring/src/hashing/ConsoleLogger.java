package hashing;

public class ConsoleLogger implements Logger
{
    public void log(String logEntry)
    {
        System.out.println(logEntry);
    }
}
