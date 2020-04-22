package com.example.distributedsystemsphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class HostQuiz extends AppCompatActivity {

    private Button loadButton;
    private Button makeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_quiz);

        loadButton = (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoadActivity();
            }
        });
        makeButton = (Button) findViewById(R.id.makeButton);
        makeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMakeActivity();
            }
        });
        new SendHelloTask().execute();
    }

        private class SendHelloTask extends AsyncTask<Void, Void, Void> {

            String result = "nothing to report";

            @Override
            protected Void doInBackground(Void... voids){

                DatagramSocket socket = null;
                try {
                    socket = new DatagramSocket(6000);
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                byte[] buf = new byte[256];

                try {
                    while(true){
                        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.0.2.15"), 6000);
                        socket.receive(packet);
                        result = new String(packet.getData(), 0, packet.getLength());
                        packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.0.2.15"), 6000);
                        if(result.equals("quiz_id:123456789")){
                            socket.close();
                            return null;
                        }
                        socket.send(packet);
                    }
                } catch(Exception e) {
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    String exceptionAsString = sw.toString();
                    result = exceptionAsString;
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    }
                });
                super.onPostExecute(aVoid);
            }
        }


    public void openLoadActivity() {
        Intent intent = new Intent(this, LoadQuiz.class);
        startActivity(intent);
    }

    public void openMakeActivity() {
        Intent intent = new Intent(this, MakeQuiz.class);
        startActivity(intent);
    }
}
