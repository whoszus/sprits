package test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Zus on 3/17/16.
 */
public class UDP {


    public static void main(String[] args)throws IOException {
        String str_send = "Hello UDPclient";
        byte[] buf = new byte[1024];
        DatagramSocket ds = new DatagramSocket(10008);
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
        System.out.println("server is on，waiting for client to send data......");
        boolean f = true;
        while(f){
            ds.receive(dp_receive);
            System.out.println("server received data from client：");
            String str_receive = new String(dp_receive.getData(),0,dp_receive.getLength()) +
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
            System.out.println(str_receive);
        }
        ds.close();
    }
}
