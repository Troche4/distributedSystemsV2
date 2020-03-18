package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

public interface StudentDao {

    @Query("SELECT * FROM MATCHING_QUESTION, MULTIPLE_CHOICE_QUESTION, FILL_IN_BLANK_QUESTION, SHORT_ANSWER_QUESTION, TF_QUESTION, QUIZ WHERE QUIZ.title = :title AND (MATCHING_QUESTION.quizID = QUIZ.quizID OR MULTIPLE_CHOICE_QUESTION.quizID = QUIZ.quizID OR SHORT_ANSWER_QUESTION.quizID = QUIZ.quizID OR TF_QUESTION.quizID = QUIZ.quizID OR FILL_IN_BLANK_QUESTION.quizID = QUIZ.quizID)")
    List<Question> getQuestionsByQuizTitle(String title);
}
