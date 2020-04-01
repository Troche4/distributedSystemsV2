package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@Entity(tableName = "QUIZ")
public class Quiz {

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "quizID")
    public int quizID;

    @ColumnInfo(name = "instructorID")
    public int instructorID;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "directions")
    public String directions;
}