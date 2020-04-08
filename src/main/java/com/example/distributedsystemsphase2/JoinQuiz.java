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

        String result = "Loading...";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                DatagramSocket socket = new DatagramSocket(4445);
                byte[] buf = new byte[256];
                DatagramPacket received = new DatagramPacket(buf, buf.length);
                socket.receive(received);
                result = received.getData().toString();
                socket.close();
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                result = sw.toString();
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
            TextView textView = (TextView) findViewById(R.id.out);
            textView.setText(result);
            super.onPostExecute(aVoid);
        }
    }
}