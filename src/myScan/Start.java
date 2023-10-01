package myScan;

//import java.net.InetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {

    private static ArrayList<IPPort> arrayOfIPPorts = new ArrayList();
    Thread runner;

    public static void main(String[] args) throws UnknownHostException {
        final int MAX_PORTS = 200; //65535;
        int cores = Runtime.getRuntime().availableProcessors(); //эх, где мой 286/287
        String save = ""; //filename to save result

        System.out.println("\nNow input file name to save report: ");
        Scanner scanner = new Scanner(System.in);
        String fn = scanner.nextLine();



        ArrayList<String> ips = new ArrayList<>();

        CountIPAddress countIPAddress = new CountIPAddress();
        String ip = countIPAddress.getMyIP(); // реально неправильно. или не совсем правильно. может попасть адрес, к примеру, VirtualBox. да и в сети может быть несколько адресных пространств. да и маска сети может быть далеко не /24
        System.out.println("this pc address is "+ ip);
        ip = countIPAddress.startIP(ip);
        System.out.println("searching does in net "+ ip);
        do{
            ip = countIPAddress.nextIP(ip);
            //System.out.println(ip);
            try{
                InetAddress inetAddress = InetAddress.getByName(ip);
               //System.out.println(ip);
                if(inetAddress.isReachable(20)){
                    System.out.println("Found ip: " + ip);
                    ips.add(ip);
                }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            //break; //using just router for the test
        } while (ip != "");
        System.out.println("Array of found ips:");
        for(String s : ips){
            System.out.println(s);
        }


        for(String s : ips) {
            //PortScanner portScanner = new PortScanner(s,1,1200);
            ScanThem scanThem = new ScanThem(s);
            scanThem.scanThem();

        }

        String string = "";
        for(String s : ips) {
            string += s;
            for(IPPort p: arrayOfIPPorts){
                if(p.getIp() == s){
                    string += ";" + p.getPort();
                }
            }
            string += "\n";
        }
        System.out.println(string);

        FileWork fw = new FileWork();
        fw.writeFile(fn + ".csv", string);


    }

    public void addIPPorts(IPPort ipPort){
        arrayOfIPPorts.add(ipPort);
    }

}

