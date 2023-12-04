package backend;

import java.util.HashMap;

public class CrimePriority {
    public static void main(String[] args) {
        HashMap<String, Integer> crimePriorityMap = new HashMap<>();
        
        crimePriorityMap.put("MURDER", 1);
        crimePriorityMap.put("ATTEMPT TO MURDER", 2);
        crimePriorityMap.put("CULPABLE HOMICIDE NOT AMOUNTING TO MURDER", 4);
        crimePriorityMap.put("RAPE", 3);
        crimePriorityMap.put("CUSTODIAL RAPE", 5);
        crimePriorityMap.put("OTHER RAPE", 6);
        crimePriorityMap.put("KIDNAPPING & ABDUCTION", 7);
        crimePriorityMap.put("KIDNAPPING AND ABDUCTION OF WOMEN & GIRLS", 8);
        crimePriorityMap.put("KIDNAPPING & ABDUCTION OF OTHERS", 9);
        crimePriorityMap.put("DACOITY", 10);
        crimePriorityMap.put("PREPARATION AND ASSEMBLY OF DACOITY", 11);
        crimePriorityMap.put("ROBBERY", 12);
        crimePriorityMap.put("BURGLARY", 13);
        crimePriorityMap.put("THEFT", 14);
        crimePriorityMap.put("AUTO THEFT", 15);
        crimePriorityMap.put("OTHER THEFT", 16);
        crimePriorityMap.put("RIOTS", 17);
        crimePriorityMap.put("CRIMINAL BREACH", 4);
        crimePriorityMap.put("CHEATING", 4);
        crimePriorityMap.put("COUNTERFEITING", 4); 
        crimePriorityMap.put("ARSON", 4);
        crimePriorityMap.put("HURT/CAUSING HURT", 4); 
        crimePriorityMap.put("DOWRY DEATHS", 18);
        crimePriorityMap.put("ASSAULT ON WOMEN WITH INTENT TO OUTRAGE HER MODESTY", 24);
        crimePriorityMap.put("INSULT TO MODESTY OF WOMEN", 25);
        crimePriorityMap.put("CRUELTY BY HUSBAND OR HIS RELATIVES", 19);
        crimePriorityMap.put("IMPORTATION OF GIRLS FROM FOREIGN COUNTRIES", 26);
        crimePriorityMap.put("CAUSING DEATH BY NEGLIGENCE", 27);
        crimePriorityMap.put("IPC CRIMES", 28);
        crimePriorityMap.put("INFANTICIDE & FOETICIDE", 20);
        crimePriorityMap.put("ABETMENT TO SUICIDE", 29);
        crimePriorityMap.put("EXPOSURE & ABANDONMENT", 30);
        crimePriorityMap.put("PROCURATION OF MINOR GIRLS", 23);
        crimePriorityMap.put("BUYING & SELLING GIRLS FOR PROSTITUTION", 21);
        crimePriorityMap.put("CHILD MARRIAGE", 22);
        
        
    }
}

