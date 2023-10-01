package myScan;


import jdk.internal.vm.ThreadContainer;

import java.util.stream.Stream;

public class PortScanner implements Runnable {

    private String ip;
    private int startPort;
    private int finPort;
    Stock stock;
    /*public String ScanPorts(String ip, int first, int last){
        String s = "";
        CountIPAddress countIPAddress = new CountIPAddress();
        for(int i = first; i <= last; i++){
            if(i % 100 == 0) System.out.println(i);
            if(countIPAddress.portIsOpen(ip,i,200)){
                s += i + ",";
            }
        }
        return s;
    }*/

    public PortScanner(String ip, int startPort, int finPort) {
        //super(true);
        this.ip = ip;
        this.startPort = startPort;
        this.finPort = finPort;
        //this.stock = stock;

        CountIPAddress countIPAddress = new CountIPAddress();
        for(int i = startPort; i <= finPort; i++){
            if(i % 523 == 0) System.out.println(i); // process indicator
            if(countIPAddress.portIsOpen(ip,i,1)){
                System.out.println("found port is " + i);
                IPPort ipPort = new IPPort(ip, i);
                Start start = new Start();
                start.addIPPorts(ipPort);
                //System.out.println(ipPort);
            }
        }





    }

    @Override
    public void run() {

    }

    /*public PortScanner(Stock stock){
        this.stock = stock;
    }*/

    public void scan(String ip, int startPort, int lastPort) {
        //public void run() {
        String s = "";
        CountIPAddress countIPAddress = new CountIPAddress();
        for(int i = startPort; i <= lastPort; i++){
            if(i % 100 == 0) System.out.println(i);
            if(countIPAddress.portIsOpen(ip,i,200)){
                //s += i + ",";
                s = ip + "/" + i + ";";
            }
        }
        stock.add(s);
    }



}
