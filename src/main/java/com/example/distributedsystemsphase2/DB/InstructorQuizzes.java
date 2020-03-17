package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

public class InstructorQuizzes {

    @Embedded public Instructor instructor;
    @Relation(
            parentColumn = "instructorID",
            entityColumn = "instructorID"
    )
    public List<Quiz> quizzes;
}