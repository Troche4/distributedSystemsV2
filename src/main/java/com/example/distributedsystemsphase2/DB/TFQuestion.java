package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Entity(tableName = "TF_QUESTION")
public class TFQuestion extends Question{

    @ColumnInfo(name = "quizID")
    public int quizID;

    @ColumnInfo(name = "prompt")
    public String prompt;

    @ColumnInfo(name = "answer")
    public String answer;

}