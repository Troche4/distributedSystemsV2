package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Entity(tableName = "MULTIPLE_CHOICE_QUESTION")
public class MultipleChoiceQuestion {

    @ColumnInfo(name = "prompt")
    public String prompt;

    @ColumnInfo(name = "answer")
    public String answer;

    @ColumnInfo(name = "a")
    public String a;

    @ColumnInfo(name = "b")
    public String b;

    @ColumnInfo(name = "c")
    public String c;

    @ColumnInfo(name = "d")
    public String d;
}