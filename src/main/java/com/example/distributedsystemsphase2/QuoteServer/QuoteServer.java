package com.example.distributedsystemsphase2.QuoteServer;

import java.io.*;
import java.net.*;
import java.util.Date;

public class QuoteServer {

    //Author: Trey Roche
    //Sources: Lecture notes and this tutorial: https://www.java-forums.org/java-net/7261-how-create-quote-server-java.html

    public static void main(String[] args) throws IOException {
        new QuoteServerThread().start();
    }

}

    class QuoteServerThread extends Thread {

        private DatagramSocket socket;
        private BufferedReader in;
        private boolean hasQuotes = true;
        private int port = 60000;

        public QuoteServerThread() throws IOException {
            super("QuoteServerThread");
            socket = new DatagramSocket(port);
            try {
                in = new BufferedReader(new InputStreamReader(new FileInputStream("one-liners.txt")));
            } catch (FileNotFoundException e) {
                System.err.println("Could not open quote file. Serving time instead.");
            }
        }

        public void run() {

            while (hasQuotes) {
                try {
                    byte[] buf = new byte[256];

                    // receive request
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);

                    // figure out response
                    String dString = null;
                    if (in == null) {
                        dString = new Date().toString();
                    } else {
                        dString = getNextQuote();
                    }
                    dString.getBytes();

                    // send the response to the client at "address" and "port"
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
                    packet = new DatagramPacket(buf, buf.length, address, port);
                    socket.send(packet);

                } catch (IOException e) {
                    e.printStackTrace();
                    hasQuotes = false;
                }
            }
            socket.close();
        }

        private String getNextQuote() {
            String returnValue;
            try {
                if ((returnValue = in.readLine()) == null) {
                    in.close();
                    hasQuotes = false;
                    returnValue = "No more quotes. Goodbye.";
                }
            } catch (IOException e) {
                returnValue = "IOException occurred in server.";
            }
            return returnValue;
        }

    }

