package org.example;

public class MyArraySizeException extends Exception{
    MyArraySizeException(){
        super("Массив неправильного размера.");
    }
}
