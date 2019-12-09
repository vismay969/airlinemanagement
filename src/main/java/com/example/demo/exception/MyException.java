package com.example.demo.exception;


import com.example.demo.util.ARSLogging;
/*test line for push*/
public class MyException extends Exception
{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
        ARSLogging.log.error(getMessage());
        for (int i = 0; i < Thread.currentThread().getStackTrace().length && i <10 ; i++) {
            //System.out.println(i);
            ARSLogging.log.error("line " + Thread.currentThread().getStackTrace()[i].getLineNumber() + " : " +
                    Thread.currentThread().getStackTrace()[i].getClassName() + "  " + Thread.currentThread().getStackTrace()[i].getMethodName());
        }
    }
}

