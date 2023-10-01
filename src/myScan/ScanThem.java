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


            //Stock stock = new Stock();
            //PortScanner portScanner = new PortScanner(s, nextStart, i < (int)(cores / 2) ? nextStart + (int)(MAX_PORTS / 2) - 1 : MAX_PORTS, stock); //stock - мусор
            //this.runner == new Thread()

            //new Thread();

            Thread thread = new Thread(new PortScanner(ip, nextStart, nextStart + (int) (ports / (int) (cores / 2)) - 1));
            //thread.setName("Th_" + i);
            thread.start();
            //nextStart +=  (int)(ports / (int)(cores / 2)) ;

                        /*)
                                .run();*/


            //new Thread(new PortScanner(ip, nextStart, i < (int)(cores / 2) ? nextStart + (int)(ports / (int)(cores / 2)) - 1 : ports));
            nextStart += (int) (ports / (int) (cores / 2));
        }
    }

}
