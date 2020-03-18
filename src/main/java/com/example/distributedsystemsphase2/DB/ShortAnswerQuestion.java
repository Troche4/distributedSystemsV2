package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Entity(tableName = "SHORT_ANSWER_QUESTION")
public class ShortAnswerQuestion extends Question{

    @ColumnInfo(name = "quizID")
    public int quizID;

    @ColumnInfo(name = "prompt")
    public String prompt;

    @ColumnInfo(name = "answer")
    public String answer;

}