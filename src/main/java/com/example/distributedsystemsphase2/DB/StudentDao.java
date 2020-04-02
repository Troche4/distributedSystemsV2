package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM  MULTIPLE_CHOICE_QUESTION, QUIZ WHERE QUIZ.title = :title AND (MULTIPLE_CHOICE_QUESTION.quizID = QUIZ.quizID)")
    List<MultipleChoiceQuestion> getQuestionsByQuizTitle(String title);
}
