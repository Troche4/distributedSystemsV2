package com.example.distributedsystemsphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.*;

import java.net.DatagramSocket;
import java.util.Arrays;

public class JoinQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_quiz);
        new GetHelloTask().execute();

    }



    private class GetHelloTask extends AsyncTask<Void, Void, Void> {

        String result = "quiz_id:123456789";

        @Override
        protected Void doInBackground(Void... voids){
            try {
                DatagramSocket socket = new DatagramSocket(6000);
                byte[] buf = new byte[256];
                buf = result.getBytes();
                DatagramPacket toSend  = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.0.2.2"), 6060);
                socket.send(toSend);
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
}