package myScan;

public class IPPort {
    private String ip;
    private int port;

    public IPPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
