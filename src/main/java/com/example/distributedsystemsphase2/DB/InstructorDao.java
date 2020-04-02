package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Dao
public interface InstructorDao {

    @Query("SELECT * FROM INSTRUCTOR")
    List<Instructor> getInstructors();

    @Query("SELECT QUIZ.* FROM INSTRUCTOR, QUIZ WHERE QUIZ.instructorID = INSTRUCTOR.email AND INSTRUCTOR.email = :email")
    List<Quiz> getQuizzesByInstructorEmail(String email);

    @Query("SELECT * FROM  MULTIPLE_CHOICE_QUESTION, QUIZ WHERE QUIZ.title = :title AND (MULTIPLE_CHOICE_QUESTION.quizID = QUIZ.quizID)")
    List<MultipleChoiceQuestion> getQuestionsByQuizTitle(String title);

    @Insert
    void addInstructor(Instructor i);

    @Delete
    void deleteInstructor(Instructor i);
}
