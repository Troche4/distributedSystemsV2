package com.example.distributedsystemsphase2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.distributedsystemsphase2.DB.AppDatabase;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    private Button hostButton;
    private Button joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hostButton = (Button) findViewById(R.id.hostButton);
        hostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHostActivity();
            }
        });
        joinButton = (Button) findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJoinActivity();
            }
        });
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "quizSystem").build(); //initialize DB
    }

    public void openHostActivity() {
        Intent intent = new Intent(this, HostQuiz.class);
        startActivity(intent);
    }

    public void openJoinActivity(){
        Intent intent = new Intent(this, JoinQuiz.class);
        startActivity(intent);
    }

}
