package com.example.distributedsystemsphase2.DB;


import androidx.room.*;

@Database(entities = {
            Response.class,
            Quiz.class,
            Instructor.class,
            MultipleChoiceQuestion.class,
            MatchingQuestion.class,
            FillInBlankQuestion.class,
            TFQuestion.class,
            ShortAnswerQuestion.class
    }, version = 1)
public abstract class AppDatabase extends RoomDatabase {
        public abstract InstructorDao instructorDao();
        public abstract StudentDao studentDao();
        //TODO add all queries for Daos
}



//initialize DB with this code:

//AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//        AppDatabase.class, "database-name").build();