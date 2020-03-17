package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

public class QuizMultipleChoiceQuestions {

    @Embedded public Quiz quiz;
    @Relation(
            parentColumn = "quizID",
            entityColumn = "quizID"
    )
    public List<MultipleChoiceQuestion> questions;

}
