package com.example.distributedsystemsphase2.QuoteServer;

import java.util.*;
import java.io.*;
import java.net.*;
import java.util.Date;

public class QuoteServerThread extends Thread {


    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    public QuoteServerThread() {
        try {
            socket = new DatagramSocket(4445);
        }
        catch(SocketException e){
            System.out.println(e);
        }
    }

    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);

            try{
                socket.receive(packet);
            }
            catch(IOException e){
                System.out.println(e);
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received
                    = new String(packet.getData(), 0, packet.getLength());

            if (received.equals("end")) {
                running = false;
                continue;
            }
            try{
                socket.send(packet);
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
        socket.close();
    }

    }

