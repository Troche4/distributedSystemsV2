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
    public static List<String> instructorsToGson(List<Instructor> instructors) {
        Gson gson = new Gson();
        List<String> jsonStrings=new ArrayList<>();
        for(Instructor element: instructors){
            jsonStrings.add(gson.toJson(element));
        }
        return jsonStrings;
    }

    @TypeConverter
    public static List<String> quizzesToGson(List<Quiz> quizzes) {
        Gson gson = new Gson();
        List<String> jsonStrings=new ArrayList<>();
        for(Quiz element: quizzes){
            jsonStrings.add(gson.toJson(element));
        }
        return jsonStrings;
    }

    @TypeConverter
    public static List<String> multipleChoiceQuestionToGson(List<MultipleChoiceQuestion> multipleChoiceQuestions) {
        Gson gson = new Gson();
        List<String> jsonStrings=new ArrayList<>();
        for(MultipleChoiceQuestion element: multipleChoiceQuestions){
            jsonStrings.add(gson.toJson(element));
        }
        return jsonStrings;
    }
}
