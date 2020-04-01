package com.example.distributedsystemsphase2.DB;

import androidx.room.*;

import org.jetbrains.annotations.NotNull;

import java.util.*;

@Entity(tableName = "SHORT_ANSWER_QUESTION")
public class ShortAnswerQuestion extends Question{

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "questionID")
    public int questionID;

    @ColumnInfo(name = "quizID")
    public int quizID;

    @ColumnInfo(name = "prompt")
    public String prompt;

    @ColumnInfo(name = "answer")
    public String answer;

}