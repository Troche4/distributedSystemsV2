package com.example.distributedsystemsphase2.QuoteServer;

public class MessageSender {
    QuoteServerClient client;

    public void setup(){
        new QuoteServerThread().start();
        client = new QuoteServerClient();
    }

    public boolean sendTestMessage() {
        String echo = client.sendMessage("hello server");
        boolean firstMsg = "hello server".equals(echo);
        echo = client.sendMessage("server is working");
        boolean secondMsg = !("hello server".equals(echo));
        return (firstMsg && secondMsg);
    }

    public void tearDown() {
        client.sendMessage("end");
        client.close();
    }
}
