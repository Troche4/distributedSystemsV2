package com.example.distributedsystemsphase2.DB;

import androidx.room.*;

import org.jetbrains.annotations.NotNull;
import java.util.*;

@Entity(tableName = "FILL_IN_BLANK_QUESTION")
public class FillInBlankQuestion extends Question{

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