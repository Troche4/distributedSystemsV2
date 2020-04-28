package com.example.distributedsystemsphase2.DB;

import androidx.room.TypeConverter;

import com.google.gson.*;

import java.util.*;

public class Converters {

    @TypeConverter
    public static ArrayList<String> fromString(String stringified) {
        return new ArrayList<String>(Arrays.asList(stringified.split(" ")));
    }

    @TypeConverter
    public static String listToString(ArrayList<String> answers) {
        String result = null;
        for(String element: answers){
            result = result + element + " ";
        }
        return result;
    }

    @TypeConverter
    public static List<String> instructorsToJson(List<Instructor> instructors) {
        Gson gson = new Gson();
        List<String> jsonStrings=new ArrayList<>();
        for(Instructor element: instructors){
            jsonStrings.add(gson.toJson(element));
        }
        return jsonStrings;
    }

    @TypeConverter
    public static List<Instructor> jsonToInstructor(List<String> jsonStrings) {
        List<Instructor> instructorList=new ArrayList<>();
        for(String element: jsonStrings){
            Instructor instructor= new Gson().fromJson(element,Instructor.class);
            instructorList.add(instructor);
        }
        return instructorList;
    }


    @TypeConverter
    public static List<String> quizzesToJson(List<Quiz> quizzes) {
        Gson gson = new Gson();
        List<String> jsonStrings=new ArrayList<>();
        for(Quiz element: quizzes){
            jsonStrings.add(gson.toJson(element));
        }
        return jsonStrings;
    }

    @TypeConverter
    public static List<Quiz> jsonToQuizzes(List<String> jsonStrings) {
        List<Quiz> quizList=new ArrayList<>();
        for(String element: jsonStrings){
            Quiz quiz= new Gson().fromJson(element,Quiz.class);
            quizList.add(quiz);
        }
        return quizList;
    }


    @TypeConverter
    public static List<String> multipleChoiceQuestionToJson(List<MultipleChoiceQuestion> multipleChoiceQuestions) {
        Gson gson = new Gson();
        List<String> jsonStrings=new ArrayList<>();
        for(MultipleChoiceQuestion element: multipleChoiceQuestions){
            jsonStrings.add(gson.toJson(element));
        }
        return jsonStrings;
    }

    @TypeConverter
    public static List<MultipleChoiceQuestion> jsonToMultipleChoiceQuestion(List<String> jsonStrings) {
        List<MultipleChoiceQuestion> multipleChoiceQuestionList=new ArrayList<>();
        for(String element: jsonStrings){
            MultipleChoiceQuestion multipleChoiceQuestion= new Gson().fromJson(element,MultipleChoiceQuestion.class);
            multipleChoiceQuestionList.add(multipleChoiceQuestion);
        }
        return multipleChoiceQuestionList;
    }
}
