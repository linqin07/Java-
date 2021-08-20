import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/10/27
 */
public class getEth0Ip {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getByName("192.168.152.1").toString());
        System.out.println(InetAddress.getLoopbackAddress());

        System.out.println(Arrays.toString(getInet4Address()));
    }

    public static String[] getInet4Address() {
        Enumeration<NetworkInterface> nis;
        String[] data = new String[2];
        try {
            nis = NetworkInterface.getNetworkInterfaces();
            for (; nis.hasMoreElements();) {
                NetworkInterface ni = nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                for (; ias.hasMoreElements();) {
                    InetAddress ia = ias.nextElement();
                    System.out.println(ia.toString());
                    if (ia.toString().contains("wlan0")) {
                        if (!ia.getHostAddress().equals("127.0.0.1")) {
                            data[0] = ia.getHostAddress();
                            data[1] = ia.getHostName();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return data;
    }
}
