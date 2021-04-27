package com.tikivn.utility.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonHelper {

    private final static String jsonPath = "src/main/resources/data/";

    public static String getPathFile(String filename) {
        String filePath = null;
        filePath = new File(filename).getAbsolutePath();
        return filePath;
    }

    @SuppressWarnings("deprecation")
    public static synchronized Object[][] getDataFile(String fileName, String testName) {

        Object[][] data;

        // Read json file data using Gson library
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(getPathFile(jsonPath + fileName)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JsonElement jsonElement = new JsonParser().parse(br);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Get test data for the specific test case
        JsonArray jsonArray = jsonObject.getAsJsonArray(testName);
        data = jsonArrayToObjectArray(jsonArray);
        return data;
    }

    public static synchronized Object[][] jsonArrayToObjectArray(JsonArray jsonArray) {

        Object[][] data = new Object[0][1];
        int index = 0;
        Gson gson = new Gson();

        if (jsonArray.size() > 0) {
            data = new Object[jsonArray.size()][1];
            for (Object obj : jsonArray) {
                Hashtable<String, String> hashTable = new Hashtable<String, String>();
                data[index][0] = gson.fromJson((JsonElement) obj, hashTable.getClass());
                index++;
            }
        }
        return data;
    }
}
