import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDP_server_implementation {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;
        System.out.println("Server started");
        while (true) {
            DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);  //recieve data form client and store in byte buffer
            System.out.println("Client:-" + data(receive));
            if (data(receive).toString().equals("bye")) {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
            // Clear the buffer after every message.
            receive = new byte[65535];
        }
    }
    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}