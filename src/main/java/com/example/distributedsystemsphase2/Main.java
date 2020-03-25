package com.example.distributedsystemsphase2;

import androidx.room.*;
import android.app.*;
import android.content.*;
import io.javalin.Javalin;
import com.example.distributedsystemsphase2.DB.*;

public class Main {

    //Author: Trey Roche

    public static void main(String[] args){
        Javalin app = Javalin.create().start(6000);

        app.get("/", ctx -> {
            ctx.status(201);
        });

        app.get("/start", ctx -> {
            ctx.status(201);
        });

        app.get("/join", ctx ->{
            ctx.status(201);
        });

        app.get("/join/addStudent", ctx ->{
            ctx.status(201);
        });

        app.get("/join/takeQuiz", ctx ->{
            ctx.status(201);
        });

        app.get("/start/quizzes", ctx ->{
            ctx.status(201);
        });

        app.get("/start/showCode", ctx ->{
            ctx.status(201);
        });

        app.get("/join/showQuestions", ctx ->{
            ctx.status(201);
        });
    }
}
