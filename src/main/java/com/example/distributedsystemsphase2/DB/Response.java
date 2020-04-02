package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import org.jetbrains.annotations.NotNull;
import java.util.*;

@Entity(tableName = "RESPONSE")
public class Response {

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "responseID")
    public int responseID;

    @ColumnInfo(name = "questionID")
    public int quizID;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "time_sent")
    public String time_sent;

    @ColumnInfo(name = "answer")
    public String answer;
}