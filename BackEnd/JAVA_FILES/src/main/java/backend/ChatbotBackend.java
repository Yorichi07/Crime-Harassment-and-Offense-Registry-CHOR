package backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.HashMap;
import java.io.File;

public class ChatbotBackend{

    public HashMap<String, HashMap<String, String>> resultMap;

    public void createbot(){
        try{
            //Create an objectmapper
            ObjectMapper objectMapper = new ObjectMapper();

            //read json data from a file
            File jsonFile = new File("BackEnd\\JAVA_FILES\\queries.json");

            //convert json to a hashmap
            this.resultMap = objectMapper.readValue(jsonFile, new TypeReference<HashMap<String, HashMap<String, String>>>(){ });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  String resolveCrimeDescription(String category, String crime) {
        if (this.resultMap.containsKey(category)) {
            HashMap<String, String> categoryCrimes = this.resultMap.get(category);
            if (categoryCrimes.containsKey(crime)) {
                return categoryCrimes.get(crime);
            } else {
                return "Crime not found in the category.";
            }
        } else {
            return "Category not found in the data.";
        }
    }
}