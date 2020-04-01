package com.example.distributedsystemsphase2.DB;

import androidx.room.*;

import org.jetbrains.annotations.NotNull;

import java.util.*;

@Entity(tableName = "MULTIPLE_CHOICE_QUESTION")
public class MultipleChoiceQuestion extends Question{

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "questionID")
    public int questionID;

    @ColumnInfo(name = "quizID")
    public int quizID;

    @ColumnInfo(name = "MCprompt")
    public String MCprompt;

    @ColumnInfo(name = "MCanswer")
    public String MCanswer;

    @ColumnInfo(name = "a")
    public String a;

    @ColumnInfo(name = "b")
    public String b;

    @ColumnInfo(name = "c")
    public String c;

    @ColumnInfo(name = "d")
    public String d;
}