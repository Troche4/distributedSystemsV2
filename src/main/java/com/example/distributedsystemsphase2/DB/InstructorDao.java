package com.example.distributedsystemsphase2.DB;

import androidx.room.*;
import java.util.*;

@Dao
public interface InstructorDao {

    @Query("SELECT * FROM INSTRUCTOR")
    List<Instructor> getInstructors();

    @Query("SELECT QUIZ.* FROM INSTRUCTOR, QUIZ WHERE QUIZ.instructorID = INSTRUCTOR.email AND INSTRUCTOR.email = :email")
    List<Quiz> getQuizzesByInstructorEmail(String email);

    @Query("SELECT * FROM ")
    List getQuestionsByQuizTitle(String title);

    @Query("SELECT RESPONSE.* FROM QUIZ, RESPONSE WHERE RESPONSE.quizID = QUIZ.quizID AND QUIZ.title = :title")
    List<Response> getResponsesByQuizTitle(String title);

    @Insert
    void addInstructor(Instructor i);

    @Delete
    void deleteInstructor(Instructor i);
}
