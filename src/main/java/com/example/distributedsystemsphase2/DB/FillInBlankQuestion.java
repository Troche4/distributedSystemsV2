package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Entity(tableName = "FILL_IN_BLANK_QUESTION")
public class FillInBlankQuestion extends Question{

    @ColumnInfo(name = "quizID")
    public int quizID;

    @ColumnInfo(name = "prompt")
    public String prompt;

    @ColumnInfo(name = "answer")
    public String answer;
}