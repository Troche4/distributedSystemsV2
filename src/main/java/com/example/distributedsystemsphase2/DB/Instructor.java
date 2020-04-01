package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import org.jetbrains.annotations.NotNull;
import java.util.*;

@Entity(tableName = "INSTRUCTOR")
public class Instructor {

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

}