package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Entity(tableName = "FILL_IN_BLANK_QUESTION")
public class FillInBlankQuestion {

    @ColumnInfo(name = "prompt")
    public String prompt;

}