package com.example.distributedsystemsphase2.QuoteServer;

import java.io.*;
import java.net.*;

public class QuoteServerClient {

    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buf;

    public QuoteServerClient() {
        try{
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public String sendMessage(String msg) {
        String received = new String();
        try{
            buf = msg.getBytes();
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            received = new String(
                    packet.getData(), 0, packet.getLength());
        }
        catch(Exception e){
            System.out.println(e);
        }
        return received;
    }

    public void close() {
        socket.close();
    }
}
