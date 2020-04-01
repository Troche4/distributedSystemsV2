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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
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
