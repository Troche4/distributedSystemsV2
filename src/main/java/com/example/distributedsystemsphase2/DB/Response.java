package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Entity(tableName = "RESPONSE")
public class Response {

    @PrimaryKey
    @ColumnInfo(name = "responseID")
    public int responseID;

    @ColumnInfo(name = "quizID")
    public int quizID;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "time_sent")
    public Date time_sent;

    @ColumnInfo(name = "answers")
    public ArrayList<String> answers;
}