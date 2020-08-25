package exceptions;

import java.io.*;
public class BadInputException extends Exception
{
    private String name;
    public BadInputException(String name)
    {
        super(name + " is a bad boy");
    }

}
