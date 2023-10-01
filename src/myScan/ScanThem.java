package myScan;

public class ScanThem{
    String ip;
    //int nextStart = 1;
    //int ports = 65535;

    public ScanThem(String ip) {
        this.ip = ip;
        //this.nextStart = nextStart;
        //this.ports = ports;
    }

    public void scanThem(){//String ip, int ports, int cores){


        final int ports = 65535;
        int cores = Runtime.getRuntime().availableProcessors();
        //cores = 20;
        int nextStart = 1;
        for (int i = 1; i <= (int)(cores / 2); i++) {
            System.out.println(nextStart + " - " + (nextStart + (int) (ports / (int) (cores / 2)) - 1));


            Thread thread = new Thread(new PortScanner(ip, nextStart, nextStart + (int) (ports / (int) (cores / 2)) - 1));

            thread.start();
            nextStart += (int) (ports / (int) (cores / 2));
        }
    }

}
