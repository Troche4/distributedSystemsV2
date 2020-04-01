package com.example.distributedsystemsphase2.DB;

import androidx.room.TypeConverter;
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
}
