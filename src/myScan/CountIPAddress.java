package myScan;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class CountIPAddress {

    public String  getMyIP () throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostAddress();
    }


    public boolean portIsOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public String startIP(String s){
        // реально нужна только последняя точка, но коли сделал, переделывать.. lastIndexOf.. мало того, это не старт, а ноль, почему-то))
        String[] breaked = s.split("\\.");
        String start = "";
        for (int i = 0; i < 3; i++) {
            start += breaked[i] + ".";
        }
        start += "0";
        return start;
    }

    public String nextIP(String s){
        //Повторное использование startIP
        String[] breaked = s.split("\\.");
        String start = "";
        for (int i = 0; i < 3; i++) {
            start += breaked[i] + ".";
        }
        int i = Integer.valueOf(breaked[3]) + 1;
        start += "" + i;
        if(i == 255) start = "";
        return start;
    }

}
