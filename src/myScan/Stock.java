package myScan;

public class Stock {
    private String s = "";
    public synchronized void add(String t){
        s += t;
    }

}
