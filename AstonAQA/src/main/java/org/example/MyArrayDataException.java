package org.example;

public class MyArrayDataException extends Exception {

    private int rowIndex;
    private int colIndex;

    MyArrayDataException(String failedValue, int rowIndex, int colIndex, Exception inner){

        super("Не удалось прочитать число (\'" + failedValue + "\').", inner);
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;

    }

    public int getRowIndex(){
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }
}
