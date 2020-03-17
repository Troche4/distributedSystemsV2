package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Entity(tableName = "SHORT_ANSWER_QUESTION")
public class ShortAnswerQuestion {

    @ColumnInfo(name = "prompt")
    public String prompt;

}